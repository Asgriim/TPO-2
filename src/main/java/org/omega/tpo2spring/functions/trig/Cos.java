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
        int coefficient = 1;
        double tempX = Math.abs(x);
        while (tempX > 2 * PI){
            tempX -= 2 * PI;
        }
        if (tempX > PI / 2 && tempX < 3 * PI / 2) coefficient *= -1;
        double res = coefficient * Math.sqrt(1 - Math.pow(sin.apply(x),2));
        return res;
//        return sin.apply(PI / 2 - x);
    }
}
