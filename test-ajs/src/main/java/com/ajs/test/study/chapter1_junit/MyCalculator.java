package com.ajs.test.study.chapter1_junit;

import com.ajs.test.study.chapter1_junit.exception.ZeroDivideException;
import lombok.Data;
import org.springframework.http.ZeroCopyHttpOutputMessage;

@Data
public class MyCalculator {
    private Double result;

    public MyCalculator() {
        this.result = 0.0;
    }

    public MyCalculator(Double initResult) {
        this.result = initResult;
    }

    public MyCalculator add(Double value) {
        this.result += value;
        return this;
    }

    public MyCalculator minus(Double value) {
        this.result -= value;
        return this;
    }

    public MyCalculator multiply(Double value) {
        this.result *= value;
        return this;
    }

    public MyCalculator divide(Double value) {
        if(value == 0) {
            throw new ZeroDivideException();
        }
        this.result /= value;
        return this;
    }
}
