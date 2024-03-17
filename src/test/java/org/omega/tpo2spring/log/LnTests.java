package org.omega.tpo2spring.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.omega.tpo2spring.functions.logs.Ln;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class LnTests {

    @Autowired
    private Ln ln;

    @Value("${funcs.log.precision}")
    private double precision;

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 1, 2, Math.E, 10})
    @DisplayName("ln(x) border points tests")
    void testBorderPoints(double x) {
        assertThat(ln.apply(x))
                .as("Ln should be :" + Math.log(x))
                .isEqualTo(Math.log(x), withPrecision(precision));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logCsv/lnData.csv")
    @DisplayName("ln(x) table points tests")
    void testTableValues(Double x, Double expected) {
        assertThat(ln.apply(x))
                .as("ln(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }



}
