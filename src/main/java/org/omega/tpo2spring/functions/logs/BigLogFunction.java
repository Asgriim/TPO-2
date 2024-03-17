package org.omega.tpo2spring.functions.logs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.lang.Math.pow;

@Component
@RequiredArgsConstructor
public class BigLogFunction implements Function<Double, Double> {
    private final Ln ln;
    private final Log10 log10;
    private final Log5 log5;
    private final Log3 log3;

    @Override
    public Double apply(Double x) {
        return (pow(((((ln.apply(x) - log10.apply(x)) - log5.apply(x)) * log5.apply(x)) / (log3.apply(x) + ln.apply(x))), 3));
    }
}
