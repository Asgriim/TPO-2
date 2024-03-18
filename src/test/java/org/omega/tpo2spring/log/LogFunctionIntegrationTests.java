package org.omega.tpo2spring.log;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.omega.tpo2spring.functions.SystemFunction;
import org.omega.tpo2spring.functions.logs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogFunctionIntegrationTests {

    @Autowired
    private Ln ln;

    @Autowired
    private Log10 log10;

    @Autowired
    private Log5 log5;

    @Autowired
    private Log3 log3;

    @Autowired
    private BigLogFunction logFunction;

    @Value("${funcs.log.precision}")
    private double precision;

    @Mock
    private Ln lnMock;

    @Mock
    private Log10 log10Mock;

    @Mock
    private Log5 log5Mock;

    @Mock
    private Log3 log3Mock;



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
        initMock("src/test/resources/logCsv/lnData.csv", lnMock);
        initMock("src/test/resources/logCsv/log3Data.csv", log3Mock);
        initMock("src/test/resources/logCsv/log5Data.csv", log5Mock);
        initMock("src/test/resources/logCsv/log10Data.csv", log10Mock);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/bigLogFunction.csv")
    @DisplayName("logarithmic function test with full mocks")
    void testFullMocks(double x, double expected) {
        BigLogFunction bigLogFunction = new BigLogFunction(lnMock, log10Mock, log5Mock, log3Mock);
        assertThat(bigLogFunction.apply(x))
                .isEqualTo(expected, withPrecision(precision));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/bigLogFunction.csv")
    @DisplayName("logarithmic function test with ln")
    void testWithLn(double x, double expected) {
        BigLogFunction bigLogFunction = new BigLogFunction(ln, log10Mock, log5Mock, log3Mock);
        assertThat(bigLogFunction.apply(x))
                .isEqualTo(expected, withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/bigLogFunction.csv")
    @DisplayName("logarithmic function test with log10")
    void testWithLog10(double x, double expected) {
        BigLogFunction bigLogFunction = new BigLogFunction(ln, log10, log5Mock, log3Mock);
        assertThat(bigLogFunction.apply(x))
                .isEqualTo(expected, withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/bigLogFunction.csv")
    @DisplayName("logarithmic function test with log5")
    void testWithLog5(double x, double expected) {
        BigLogFunction bigLogFunction = new BigLogFunction(ln, log10, log5, log3Mock);
        assertThat(bigLogFunction.apply(x))
                .isEqualTo(expected, withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/bigLogFunction.csv")
    @DisplayName("logarithmic function test with log3")
    void testWithLog3(double x, double expected) {
        BigLogFunction bigLogFunction = new BigLogFunction(ln, log10, log5, log3);
        assertThat(bigLogFunction.apply(x))
                .isEqualTo(expected, withPrecision(precision));
    }






}
