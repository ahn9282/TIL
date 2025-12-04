package com.ajs.test.study.chapter1_junit;

import com.ajs.test.study.chapter1_junit.exception.ZeroDivideException;

public class MyCalculatorApplication {

    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();

        myCalculator.add(10.0);

        System.out.println("result = " + myCalculator.getResult());

        myCalculator.minus(3.0);
        System.out.println("result = " + myCalculator.getResult());
        myCalculator.multiply(1.5);
        System.out.println("result = " + myCalculator.getResult());

        try {
            myCalculator.divide(0.0);

        } catch(ZeroDivideException e) {
            System.out.println("occired ZeroDevideExcepttion");
        }

        myCalculator.divide(3.5);
        System.out.println("result = " + myCalculator.getResult());
    }
}
