package study.lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> evenNumbers = filterEvenNumber(numbers);
        System.out.println("evenNumbers = " + evenNumbers);
        List<Integer> oddNumbers = filterOddNumber(numbers);
        System.out.println("oddNumbers = " + oddNumbers);
    }

    private static List<Integer> filterEvenNumber(List<Integer> numbers) {
        ArrayList<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            if(number % 2 ==0) filtered.add(number);
        }
        return filtered;
    }    private static List<Integer> filterOddNumber(List<Integer> numbers) {
        ArrayList<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            if(number % 2 ==1) filtered.add(number);
        }
        return filtered;
    }

}
