package org.omega.tpo2spring.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

public class CsvWriteBuilder {
    private String filePath;
    private double end;
    private double begin;
    private double delta;
    private Function<Double, Double> function;
    private boolean header;

    public CsvWriteBuilder file(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public CsvWriteBuilder begin(double begin) {
        this.begin = begin;
        return this;
    }

    public CsvWriteBuilder end(double end) {
        this.end = end;
        return this;
    }

    public CsvWriteBuilder delta(double delta) {
        this.delta = delta;
        return this;
    }

    public CsvWriteBuilder func(Function<Double, Double> function) {
        this.function = function;
        return this;
    }

    public CsvWriteBuilder writeHeader(boolean header) {
        this.header = header;
        return this;
    }

    public CsvWriteBuilder execute() throws IOException {
        CsvWriter csvWriter = new CsvWriter(new BufferedWriter(new FileWriter(filePath)), function);
        csvWriter.write(begin,end,delta, header);
        return this;
    }
}
