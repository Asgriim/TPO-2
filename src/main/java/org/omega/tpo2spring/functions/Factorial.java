package org.omega.tpo2spring.functions;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@NoArgsConstructor
public class Factorial implements Function<Long, Double> {

    @Override
    public Double apply(Long x) {
        if (x < 0) {
            throw new ArithmeticException("Factorial is unknown if n < 0");
        }
        double z = 1;
        for (int i = 1; i <= x; i++){
            z *= i;
        }
        return z;
    }
}
