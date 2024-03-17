package org.omega.tpo2spring;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.csv.CsvWriteBuilder;
import org.omega.tpo2spring.functions.*;
import org.omega.tpo2spring.functions.logs.BigLogFunction;
import org.omega.tpo2spring.functions.logs.Ln;
import org.omega.tpo2spring.functions.trig.Cos;
import org.omega.tpo2spring.functions.trig.Cot;
import org.omega.tpo2spring.functions.trig.Sin;
import org.omega.tpo2spring.functions.trig.Tan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Tpo2SpringApplication implements CommandLineRunner {
    private final SystemFunction systemFunction;
    private final BigLogFunction bigLogFunction;
    private final Ln ln;

    private final Sin sin;

    private final Cos cos;
    private final Cot cot;
    private final Tan tan;

    public static void main(String[] args) {
        SpringApplication.run(Tpo2SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CsvWriteBuilder csvWriteBuilder = new CsvWriteBuilder();
        final double l = 3d;
        for (double i = 0; i <= 3;i+=0.2){
            System.out.println(i + " : " + sin.apply(i));
        }
        csvWriteBuilder
//                .func((x) -> Math.log(x) / Math.log(l))
                .func(sin)
                .begin(0)
                .end(Math.PI)
                .delta(0.2)
                .writeHeader(false)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/logCsv/lnData.csv")
//                .file("C:/Users/vagae/IdeaProjects/TPO-2/csvFilesOutput/sin.csv")
//                .execute();
        ;
    }
}
