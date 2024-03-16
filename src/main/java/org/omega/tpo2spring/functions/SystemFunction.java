package org.omega.tpo2spring.functions;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.functions.logs.Ln;
import org.omega.tpo2spring.functions.logs.Log10;
import org.omega.tpo2spring.functions.logs.Log3;
import org.omega.tpo2spring.functions.logs.Log5;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.lang.Math.pow;

@Component
@RequiredArgsConstructor
public class SystemFunction implements Function<Double, Double> {
    private final Ln ln;
    private final Log10 log10;
    private final Log5 log5;
    private final Log3 log3;
    private final Sec sec;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Csc csc;
    private final Sin sin;

    @Override
    public Double apply(Double x) {
        if (x <= 0) {
            return ((pow((pow((((((((pow((((pow((pow(((sec.apply(x) * cos.apply(x)) * tan.apply(x)),3)),2)) - cot.apply(x)) - sin.apply(x)),2)) + sec.apply(x)) / sin.apply(x)) + (cos.apply(x) / tan.apply(x))) + (cos.apply(x) / cos.apply(x))) + (csc.apply(x) * (((((pow(sec.apply(x),3)) * (pow(cos.apply(x),3))) / sec.apply(x)) + cos.apply(x)) * csc.apply(x)))) + ((((cot.apply(x) - csc.apply(x)) * tan.apply(x)) + (cot.apply(x) + tan.apply(x))) - (tan.apply(x) / sin.apply(x)))),3)),2)) / (((cos.apply(x) / (cot.apply(x) - csc.apply(x))) + ((((((pow(cos.apply(x),3)) / tan.apply(x)) / csc.apply(x)) * sin.apply(x)) * (((tan.apply(x) / sec.apply(x)) / tan.apply(x)) * cos.apply(x))) / cot.apply(x))) - ((((sin.apply(x) + (pow(sin.apply(x),2))) * (sec.apply(x) / (((tan.apply(x) - (tan.apply(x) * cot.apply(x))) / (pow(sec.apply(x),3))) * cot.apply(x)))) / csc.apply(x)) + cos.apply(x))));
        } else {
            return (pow(((((ln.apply(x) - log10.apply(x)) - log5.apply(x)) * log5.apply(x)) / (log3.apply(x) + ln.apply(x))), 3));
        }
    }
}
