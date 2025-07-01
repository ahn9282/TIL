package study.lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = filter(numbers, n -> n % 2 ==0);
        System.out.println("evenNumbers = " + evenNumbers);
        List<Integer> oddNumbers = filter(numbers, n -> n % 2 == 1);
        System.out.println("oddNumbers = " + oddNumbers);
    }



    private static List<Integer> filter( List<Integer> numbers, Predicate<Integer> tester) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            boolean test = tester.test(number);
            if(test){
                filtered.add(number);
            }
        }
        return filtered;
    }

}
