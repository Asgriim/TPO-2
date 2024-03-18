package org.omega.tpo2spring.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.omega.tpo2spring.functions.trig.Tan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

@SpringBootTest
public class TanTest {

    @Autowired
    private Tan tan;

    @Value("${funcs.log.precision}")
    private double precision;

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/unit/tanData.csv")
    @DisplayName("tan table points tests")
    void testTableValues(Double x, Double expected) {
        assertThat(tan.apply(x))
                .as("tan(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }
}
