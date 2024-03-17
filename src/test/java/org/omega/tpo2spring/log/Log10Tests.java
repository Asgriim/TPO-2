package org.omega.tpo2spring.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.omega.tpo2spring.functions.logs.Log10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

@SpringBootTest
public class Log10Tests {

    @Autowired
    private Log10 log10;

    @Value("${funcs.log.precision}")
    private double precision;


    @ParameterizedTest
    @ValueSource(doubles = {1, 10})
    @DisplayName("log10(x) border points tests")
    void testBorderPoints(double x) {
        assertThat(log10.apply(x))
                .as("Log10 should be :" + Math.log10(x))
                .isEqualTo(Math.log10(x), withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/log10Data.csv")
    @DisplayName("log10(x) table points tests")
    void testTableValues(Double x, Double expected) {
        assertThat(log10.apply(x))
                .as("log10(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }

}
