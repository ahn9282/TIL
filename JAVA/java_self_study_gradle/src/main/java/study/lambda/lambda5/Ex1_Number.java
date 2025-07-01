package study.lambda.lambda5;

import study.lambda.lambda5.filter.GenericFilter;
import study.lambda.lambda5.map.GenericMapper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Ex1_Number {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResults = direct(numbers);
        List<Integer> lambdaResults = lambda(numbers);
        System.out.println("directResults = " + directResults);
        System.out.println("lambdaResults = " + lambdaResults);
    }

    private static List<Integer> direct(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : numbers) {
            if(i % 2 ==0){
                int e = i * 2;
                result.add(e);
            }
        }
        return result;
    }
    private static List<Integer> lambda(List<Integer> numbers) {
        List<Integer> filter = GenericFilter.filter(numbers, i -> i % 2 == 0);
        List<Integer> mappedList = GenericMapper.map(filter, n -> Integer.valueOf(n * 2));
        return mappedList;
    }
}
