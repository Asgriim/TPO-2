package org.omega.tpo2spring.trig;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.omega.tpo2spring.functions.logs.BigLogFunction;
import org.omega.tpo2spring.functions.trig.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OmegaTrigFuncIntegrationTests {

    @Autowired
    private Cos cos;

    @Autowired
    private Cot cot;

    @Autowired
    private Csc csc;

    @Autowired
    private Sec sec;

    @Autowired
    private Sin sin;

    @Autowired
    private Tan tan;

    @Value("${funcs.log.precision.percentage}")
    private double precision;

    private static final Cos cosMock = mock(Cos.class);
    private static final Cot cotMock = mock(Cot.class);
    private static final Csc cscMock = mock(Csc.class);
    private static final Sec secMock = mock(Sec.class);
    private static final Sin sinMock = mock(Sin.class);
    private static final Tan tanMock = mock(Tan.class);


    private static void initMock(String path, Function<Double, Double> function) {
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            csvReader.readAll().forEach(s -> {
                double x = Double.parseDouble(s[0]);
                double y = Double.parseDouble(s[1]);
                when(function.apply(x)).thenReturn(y);
            });
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }


    @BeforeAll
    static void setupMocks() {
        initMock("src/test/resources/trigCsv/cosData.csv", cosMock);
        initMock("src/test/resources/trigCsv/cotData.csv", cotMock);
        initMock("src/test/resources/trigCsv/cscData.csv", cscMock);
        initMock("src/test/resources/trigCsv/secData.csv", secMock);
        initMock("src/test/resources/trigCsv/sinData.csv", sinMock);
        initMock("src/test/resources/trigCsv/tanData.csv", tanMock);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/omegaTrigData.csv")
    @DisplayName("trig function test with full mocks")
    void testFullMocks(double x, double expected) {
        OmegaBigFunc omegaBigFunc = new OmegaBigFunc(secMock, cosMock, tanMock, cotMock, cscMock, sinMock);
        assertThat(omegaBigFunc.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/omegaTrigData.csv")
    @DisplayName("trig function test with sec")
    void testWithSec(double x, double expected) {
        OmegaBigFunc omegaBigFunc = new OmegaBigFunc(sec, cosMock, tanMock, cotMock, cscMock, sinMock);
        assertThat(omegaBigFunc.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/omegaTrigData.csv")
    @DisplayName("trig function test with cos")
    void testWithCos(double x, double expected) {
        OmegaBigFunc omegaBigFunc = new OmegaBigFunc(sec, cos, tanMock, cotMock, cscMock, sinMock);
        assertThat(omegaBigFunc.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/omegaTrigData.csv")
    @DisplayName("trig function test with tan")
    void testWithTan(double x, double expected) {
        OmegaBigFunc omegaBigFunc = new OmegaBigFunc(sec, cos, tan, cotMock, cscMock, sinMock);
        assertThat(omegaBigFunc.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/omegaTrigData.csv")
    @DisplayName("trig function test with cot")
    void testWithCot(double x, double expected) {
        OmegaBigFunc omegaBigFunc = new OmegaBigFunc(sec, cos, tan, cot, cscMock, sinMock);
        assertThat(omegaBigFunc.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/omegaTrigData.csv")
    @DisplayName("trig function test with csc")
    void testWithCsc(double x, double expected) {
        OmegaBigFunc omegaBigFunc = new OmegaBigFunc(sec, cos, tan, cot, csc, sinMock);
        assertThat(omegaBigFunc.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/omegaTrigData.csv")
    @DisplayName("trig function test with sin")
    void testWithSin(double x, double expected) {
        OmegaBigFunc omegaBigFunc = new OmegaBigFunc(sec, cos, tan, cot, csc, sin);
        assertThat(omegaBigFunc.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }

}
