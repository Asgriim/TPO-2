package org.omega.tpo2spring;

import lombok.RequiredArgsConstructor;
import org.omega.tpo2spring.csv.CsvWriteBuilder;
import org.omega.tpo2spring.functions.Factorial;
import org.omega.tpo2spring.functions.SystemFunction;
import org.omega.tpo2spring.functions.logs.Ln;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Tpo2SpringApplication implements CommandLineRunner {
    private final SystemFunction systemFunction;
    private final Ln ln;

    public static void main(String[] args) {
        SpringApplication.run(Tpo2SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CsvWriteBuilder csvWriteBuilder = new CsvWriteBuilder();
        csvWriteBuilder.func(ln)
                .begin(0.000001)
                .end(20000)
                .delta(100)
                .file("govno-penis.csv")
                .execute();
    }
}
