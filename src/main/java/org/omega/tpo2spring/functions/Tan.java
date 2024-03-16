package org.omega.tpo2spring.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class Tan implements Function<Double, Double> {
    private final Sin sin;
    private final Cos cos;

    @Override
    public Double apply(Double x) {
        return sin.apply(x) / cos.apply(x);
    }
}
