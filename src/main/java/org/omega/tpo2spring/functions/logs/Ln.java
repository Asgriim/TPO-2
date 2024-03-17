package org.omega.tpo2spring.functions.logs;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.function.Function;

@Component
@NoArgsConstructor
public class Ln implements Function<Double, Double> {

    @Value("${taylor.steps}")
    private double steps;

    @Value("${funcs.is_using_math}")
    private boolean isUsingMath;

    @Override
    public Double apply(Double x) {
        if (isUsingMath) {
            return Math.log(x);
        }
        double num, mul, cal, sum = 0;

        num = (x - 1) / (x + 1);

        for (int i = 1; i <= steps; i++) {
            mul = (2 * i) - 1;
            cal = Math.pow(num, mul);
            cal = cal / mul;
            sum = sum + cal;
        }

        sum = 2 * sum;
        return sum;
    }


}
