package org.omega.tpo2spring.functions;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.functions.logs.*;
import org.omega.tpo2spring.functions.trig.*;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.lang.Math.pow;

@Component
@RequiredArgsConstructor
public class SystemFunction implements Function<Double, Double> {
    private final BigLogFunction bigLogFunction;
    private final OmegaBigFunc omegaBigFunc;

    @Override
    public Double apply(Double x) {
        if (x <= 0) {
            return omegaBigFunc.apply(x);
        } else {
            return bigLogFunction.apply(x);
        }
    }
}
