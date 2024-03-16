package org.omega.tpo2spring.functions;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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


    @Override
    public Double apply(Double x) {
        return pow(-1, steps) * pow(x, 2 * steps + 1) / factorial.apply((long) (2 * steps + 1));
    }
}
