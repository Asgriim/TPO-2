package org.omega.tpo2spring;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.csv.CsvWriteBuilder;
import org.omega.tpo2spring.functions.*;
import org.omega.tpo2spring.functions.logs.*;
import org.omega.tpo2spring.functions.trig.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Tpo2SpringApplication implements CommandLineRunner {
    private final SystemFunction systemFunction;
    private final BigLogFunction bigLogFunction;
    private final OmegaBigFunc omegaBigFunc;
    private final Ln ln;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    private final Sin sin;

    private final Cos cos;
    private final Cot cot;
    private final Tan tan;
    private final Csc csc;
    private final Sec sec;

    public static void main(String[] args) {
        SpringApplication.run(Tpo2SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CsvWriteBuilder csvWriteBuilder = new CsvWriteBuilder();
//        final double l = 3d;
//        for (double i = 0; i <= 3;i+=0.2){
//            System.out.println(i + " : " + sin.apply(i));
//        }
        List<Double> points = List.of(
                -2.274,
                -2.3136,
                -2.3597,
                -2.52,
                -2.6108,
                -3.483,
                -3.562,
                -3.733,
                -3.844,
                -3.846,
                -3.947
        );
        csvWriteBuilder
//                .func((x) -> Math.log(x) / Math.log(l))
//                .func(omegaBigFunc)
//                .func(Math::cos)
                .begin(-5)
                .end(5)
                .delta(0.2)
                .writeHeader(false)
                .func(bigLogFunction)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/logCsv/bigLogFunction.csv")
//                .execute(points)
//                .func(ln)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/logCsv/lnFunction.csv")
//                .execute(points)
//                .func()
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/logCsv/bigLogFunction.csv")
//                .execute(points)
//                .func(cos)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/cosData.csv")
//                .execute(points)
//                .func(cot)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/cotData.csv")
//                .execute(points)
//                .func(csc)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/cscData.csv")
//                .execute(points)
//                .func(sec)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/secData.csv")
//                .execute(points)
//                .func(sin)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/sinData.csv")
//                .execute(points)
//                .func(tan)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/tanData.csv")
//                .execute(points)


        ;
    }
}
