package study.user.template;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.template_3.dataObject.Calculator;

import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

public class CalcSumTest {

    Calculator calculator;
    String numFilePath;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
        this.numFilePath = Objects.requireNonNull(getClass().getResource("/txt/numbers.txt")).getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();

        int sum = calculator.calcSum(numFilePath);
        assertThat(sum).isEqualTo(10);
    }
}
