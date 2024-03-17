package org.omega.tpo2spring.functions.trig;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.lang.Math.PI;

@Component
@RequiredArgsConstructor
public class Cos implements Function<Double, Double> {
    private final Sin sin;

    @Override
    public Double apply(Double x) {
        return sin.apply(PI / 2 - x);
    }
}
