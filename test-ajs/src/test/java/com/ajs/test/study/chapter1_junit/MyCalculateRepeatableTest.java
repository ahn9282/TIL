package com.ajs.test.study.chapter1_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.annotation.Repeatable;
import java.util.stream.Stream;

public class MyCalculateRepeatableTest {


    @DisplayName("덧셈을 5번 단순 반복하며 테스트")
    @RepeatedTest(5)
    public void repeatableAddTest(){
        MyCalculator calculator = new MyCalculator().add(10.0);

        Assertions.assertEquals(10.0, calculator.getResult());
    }

    @DisplayName("덧셈을 5번 파라미터를 넣어가며 테스트 @MethodSource에서 메서드를 가져옴 Arguments")
    @ParameterizedTest
    @MethodSource("parameterizedAddTestParameters")
    public void parameterizedAddTest(Double addValue, Double expectValue){
        MyCalculator calculator = new MyCalculator().add(10.0);

        Assertions.assertEquals(10.0, calculator.getResult());
    }

    public static Stream<Arguments> parameterizedAddTestParameters(){
        return Stream.of(
                Arguments.of(10.0, 10.0)
                , Arguments.of(20.0, 20.0)
                , Arguments.of(8.0, 8.0)
                , Arguments.of(13.0, 13.0)
                , Arguments.of(16.0, 16.0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterizedComplicatedCalculateTestParameters")
    public void parameterizedComplicatedCalculateTest(
            Double addValue, Double minusValue, Double multiplyValue, Double divideValue, Double expectValue
    ){
        MyCalculator myCalculator = new MyCalculator(0.0);

        Double result = myCalculator.add(addValue)
                .minus(minusValue)
                .multiply(multiplyValue)
                .divide(divideValue)
                .getResult();

        Assertions.assertEquals(result, expectValue);
    }

    public static Stream<Arguments> parameterizedComplicatedCalculateTestParameters(){
        return Stream.of(
                Arguments.of(10.0, 4.0, 2.0, 3.0, 4.0)
                , Arguments.of(4.0, 2.0, 4.0, 4.0, 2.0)
        );
    }

}
