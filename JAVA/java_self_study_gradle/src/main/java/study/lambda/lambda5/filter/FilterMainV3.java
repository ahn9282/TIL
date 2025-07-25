package study.lambda.lambda5.filter;

import study.lambda.lambda5.map.IntegerFilter;

import java.util.List;

public class FilterMainV3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = IntegerFilter.filter(numbers, n -> n % 2 ==0);
        System.out.println("evenNumbers = " + evenNumbers);
        List<Integer> oddNumbers =  IntegerFilter.filter(numbers, n -> n % 2 == 1);
        System.out.println("oddNumbers = " + oddNumbers);
    }
}
