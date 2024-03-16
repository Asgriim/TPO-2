package org.omega.tpo2spring.functions.logs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class Log5 implements Function<Double, Double> {
    private final Ln ln;

    @Override
    public Double apply(Double x) {
        return ln.apply(x) / ln.apply(5D);
    }
}
