package org.omega.tpo2spring.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class Sec implements Function<Double, Double> {
    private final Cos cos;

    @Override
    public Double apply(Double x) {
        return 1 / cos.apply(x);
    }
}
