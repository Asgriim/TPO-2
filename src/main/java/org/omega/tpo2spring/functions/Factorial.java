package org.omega.tpo2spring.functions;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@NoArgsConstructor
public class Factorial implements Function<Long, Long> {

    @Override
    public Long apply(Long x) {
        if (x < 0) {
            throw new ArithmeticException("Factorial is unknown if n < 0");
        }
        long n = 1;

        for (int i = 1; i <= x; i++) {
            n *= i;
        }

        return n;
    }
}
