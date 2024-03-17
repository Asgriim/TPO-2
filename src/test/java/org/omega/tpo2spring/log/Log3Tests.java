package org.omega.tpo2spring.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.omega.tpo2spring.functions.logs.Log3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

@SpringBootTest
public class Log3Tests {

    @Autowired
    private Log3 log3;

    @Value("${funcs.log.precision}")
    private double precision;


    @ParameterizedTest
    @CsvSource(value = {
            "1, 0",
            "3, 1",
            "9, 2",
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("log3(x) border points tests")
    void testBorderPoints(double x, double expected) {
        assertThat(log3.apply(x))
                .as("Log3 should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/log3Data.csv")
    @DisplayName("log3(x) table points tests")
    void testTableValues(Double x, Double expected) {
        assertThat(log3.apply(x))
                .as("log3(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }
}
