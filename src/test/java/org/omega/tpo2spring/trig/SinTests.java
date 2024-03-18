package org.omega.tpo2spring.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.omega.tpo2spring.functions.trig.Sin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

@SpringBootTest
public class SinTests {

    @Autowired
    private Sin sin;

    @Value("${funcs.log.precision}")
    private double precision;


    @ParameterizedTest
    @CsvSource(value = {
            "-4, 0.757",
            "-1.5, -0.997",
            "1, 0.841",
            "5, -0.959",
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("sin border points tests")
    void testBorderPoints(Double x, Double expected) {
        assertThat(sin.apply(x))
                .as("sin(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/unit/sinData.csv")
    @DisplayName("sin table points tests")
    void testTableValues(Double x, Double expected) {
        assertThat(sin.apply(x))
                .as("sin(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }
}
