package org.omega.tpo2spring.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class Cot implements Function<Double, Double> {
    private final Sin sin;
    private final Cos cos;

    @Override
    public Double apply(Double x) {
        return cos.apply(x) / sin.apply(x);
    }
}
