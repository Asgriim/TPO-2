package org.omega.tpo2spring.functions.trig;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.functions.Factorial;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.lang.Math.pow;

@Component
@RequiredArgsConstructor
public class Sin implements Function<Double, Double> {

    @Value("${taylor.steps}")
    private double steps;
    private final Factorial factorial;

    @Value("${funcs.is_using_math}")
    private boolean isUsingMath;

    @Override
    public Double apply(Double x) {
        if (isUsingMath) {
            return Math.sin(x);
        }
        double sum = 0;
        for (int n = 0; n <= steps; n++){
            sum += Math.pow(-1, n) * Math.pow(x, 2*n + 1) / factorial.apply((long)(2*n + 1));
        }
        return sum;
    }
}
