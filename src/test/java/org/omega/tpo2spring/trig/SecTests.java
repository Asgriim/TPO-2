package org.omega.tpo2spring.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.omega.tpo2spring.functions.trig.Sec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

@SpringBootTest
public class SecTests {

    @Autowired
    private Sec sec;

    @Value("${funcs.log.precision}")
    private double precision;

    @ParameterizedTest
    @CsvFileSource(resources = "/trigCsv/secData.csv")
    @DisplayName("sec table points tests")
    void testTableValues(Double x, Double expected) {
        assertThat(sec.apply(x))
                .as("sec(x) should be :" + expected)
                .isEqualTo(expected, withPrecision(precision));
    }
}
