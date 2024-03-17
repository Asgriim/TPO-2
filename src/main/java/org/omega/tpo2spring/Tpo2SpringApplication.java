package org.omega.tpo2spring;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.csv.CsvWriteBuilder;
import org.omega.tpo2spring.functions.Factorial;
import org.omega.tpo2spring.functions.SystemFunction;
import org.omega.tpo2spring.functions.logs.BigLogFunction;
import org.omega.tpo2spring.functions.logs.Ln;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Tpo2SpringApplication implements CommandLineRunner {
    private final SystemFunction systemFunction;
    private final BigLogFunction bigLogFunction;
    private final Ln ln;

    public static void main(String[] args) {
        SpringApplication.run(Tpo2SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CsvWriteBuilder csvWriteBuilder = new CsvWriteBuilder();
        final double l = 3d;
        csvWriteBuilder
//                .func((x) -> Math.log(x) / Math.log(l))
                .func(bigLogFunction)
                .begin(1)
                .end(10)
                .delta(0.5)
                .writeHeader(false)
//                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/logCsv/lnData.csv")
                .file("/home/asgrim/IdeaProjects/TPO-2-spring/src/test/resources/logCsv/bigLogFunction.csv")
                .execute();
    }
}
