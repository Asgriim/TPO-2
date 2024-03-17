package org.omega.tpo2spring.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.omega.tpo2spring.functions.logs.Log5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

@SpringBootTest
public class Log5Tests {
    @Autowired
    private Log5 log5;

    @Value("${funcs.log.precision}")
    private double precision;


    @ParameterizedTest
    @CsvSource(value = {
            "1, 0",
            "5, 1",
            "25, 2",
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("log5(x) border points tests")
    void testBorderPoints(double x, double expected) {
        assertThat(log5.apply(x))
                .as("Log5(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/log5Data.csv")
    @DisplayName("log5(x) table points tests")
    void testTableValues(Double x, Double expected) {
        assertThat(log5.apply(x))
                .as("log5(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }
}
