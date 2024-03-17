package org.omega.tpo2spring.csv;

import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.function.Function;

@RequiredArgsConstructor
public class CsvWriter {
    private final BufferedWriter writer;
    private final Function<Double, Double> function;

    public void write(double begin, double end, double delta, boolean header) throws IOException {
        if (header) {
            writer.write("x,y\n");
        }
        for (double i = begin; i <= end; i+= delta) {
            writer.write(String.format("%f,%f\n", i, function.apply(i)));
        }
        writer.flush();
    }
}
