package org.omega.tpo2spring.csv;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
@Data
public class CsvWriter {
    private final BufferedWriter writer;
    private final Function<Double, Double> function;
    private String delimiter = ",";

    public void write(double begin, double end, double delta, boolean header) throws IOException {
        if (header) {
            writer.write("x" + delimiter + "y\n");
        }
        for (double i = begin; i <= end; i += delta) {
            writer.write(String.format("%f" + delimiter + "%f\n", i, function.apply(i)));
        }
        writer.flush();
    }

    public void write(List<Double> points, boolean header) throws IOException {
        if (header) {
            writer.write("x" + delimiter + "y\n");
        }
        points.forEach(i -> {
            try {
                writer.write(String.format("%f" + delimiter + "%f\n", i, function.apply(i)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.flush();

    }

}
