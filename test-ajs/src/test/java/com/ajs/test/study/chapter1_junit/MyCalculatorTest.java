package com.ajs.test.study.chapter1_junit;

import com.ajs.test.study.chapter1_junit.exception.ZeroDivideException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyCalculatorTest {

    @Test
    void add() {
        MyCalculator myCalculator = new MyCalculator();
        myCalculator.add(10.0);
        assertThat(myCalculator.getResult()).isEqualTo(10.0);
    }

    @Test
    void minus() {
        MyCalculator myCalculator = new MyCalculator();
        myCalculator.minus(3.0);
        assertThat(myCalculator.getResult()).isEqualTo(-3.0);
    }

    @Test
    void multiply() {
        MyCalculator myCalculator = new MyCalculator();
        myCalculator.add(10.0);
        myCalculator.multiply(1.5);
        assertThat(myCalculator.getResult()).isEqualTo(15.0);
    }

    @Test
    void divide() {
        MyCalculator myCalculator = new MyCalculator();
        assertThatThrownBy(() -> myCalculator.divide(0.0))
                .isInstanceOf(ZeroDivideException.class);

        myCalculator.divide(3.5);
        assertThat(myCalculator.getResult()).isEqualTo(0.0);

    }

    @Test
    void complicatedCalculateTest() {
        MyCalculator myCalculator = new MyCalculator();

        myCalculator.add(10.0).minus(4.0).multiply(3.0).divide(2.0);
        assertThat(myCalculator.getResult()).isEqualTo(9.0);
    }
}
