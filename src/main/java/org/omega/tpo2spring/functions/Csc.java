package org.omega.tpo2spring.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class Csc implements Function<Double, Double> {
    private final Sin sin;

    @Override
    public Double apply(Double x) {
        return 1 / sin.apply(x);
    }
}
