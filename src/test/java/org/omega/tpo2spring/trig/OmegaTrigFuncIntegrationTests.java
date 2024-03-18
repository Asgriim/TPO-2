package org.omega.tpo2spring.trig;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
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
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @Mock
    private Cos cosMock;

    @Mock
    private Cot cotMock;

    @Mock
    private Csc cscMock;

    @Mock
    private Sec secMock;

    @Mock
    private Sin sinMock;

    @Mock
    private Tan tanMock;


    private void initMock(String path, Function<Double, Double> function) {
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
    void setupMocks() {
        initMock("src/test/resources/trigCsv/cosData.csv", cosMock);
        initMock("src/test/resources/trigCsv/cotData.csv", cotMock);
        initMock("src/test/resources/trigCsv/cscData.csv", cscMock);
        initMock("src/test/resources/trigCsv/secData.csv", secMock);
        initMock("src/test/resources/trigCsv/sinData.csv", sinMock);
        initMock("src/test/resources/trigCsv/tanData.csv", tanMock);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/cosData.csv")
    @DisplayName("cos function test with full mocks")
    void testCosMock(double x, double expected) {
        Cos cosTest = new Cos(sinMock);
        assertThat(cosTest.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/cscData.csv")
    @DisplayName("csc function test with full mocks")
    void testCscMock(double x, double expected) {
        Csc cscTest = new Csc(sinMock);
        assertThat(cscTest.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/cotData.csv")
    @DisplayName("cot function test with full mocks")
    void testCotMock(double x, double expected) {
        Cot cotTest = new Cot(sinMock, cosMock);
        assertThat(cotTest.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/secData.csv")
    @DisplayName("sec function test with full mocks")
    void testSecMock(double x, double expected) {
        Sec secTest = new Sec(cosMock);
        assertThat(secTest.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/tanData.csv")
    @DisplayName("tan function test with full mocks")
    void testTanMock(double x, double expected) {
        Tan tanTest = new Tan(sinMock, cosMock);
        assertThat(tanTest.apply(x))
                .isCloseTo(expected, withinPercentage(precision));
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
