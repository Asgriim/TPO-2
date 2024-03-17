package org.omega.tpo2spring;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.csv.CsvWriteBuilder;
import org.omega.tpo2spring.functions.*;
import org.omega.tpo2spring.functions.logs.BigLogFunction;
import org.omega.tpo2spring.functions.logs.Ln;
import org.omega.tpo2spring.functions.trig.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Tpo2SpringApplication implements CommandLineRunner {
    private final SystemFunction systemFunction;
    private final BigLogFunction bigLogFunction;
    private final OmegaBigFunc omegaBigFunc;
    private final Ln ln;

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
        csvWriteBuilder
//                .func((x) -> Math.log(x) / Math.log(l))
                .func(omegaBigFunc)
//                .func(Math::cos)
                .begin(-3.88)
                .end(-3.86)
                .delta(0.0001)
                .writeHeader(false)
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/omegaTrigData.csv")
                .execute()
                .func(cos)
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/cosData.csv")
                .execute()
                .func(cot)
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/cotData.csv")
                .execute()
                .func(csc)
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/cscData.csv")
                .execute()
                .func(sec)
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/secData.csv")
                .execute()
                .func(sin)
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/sinData.csv")
                .execute()
                .func(tan)
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/trigCsv/tanData.csv")
                .execute()

        ;
    }
}
