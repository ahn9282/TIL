package study.stream.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFlatMap {

    public static void main(String[] args) {
        List<List<Integer>> outerList = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));

        ArrayList<Integer> forResult = new ArrayList<>();
        for (List<Integer> integers : outerList) {
            for (Integer i : integers) {
                forResult.add(i);
            }
        }
        System.out.println("forResult = " + forResult);

        Map<Integer, Integer> collectMap = outerList.stream().flatMap(List::stream).collect(Collectors.toMap(i -> i, i -> i));
        List<Integer> collectList = outerList.stream().flatMap(List::stream).toList();
        System.out.println("collectMap = " + collectMap);
        System.out.println("collectList = " + collectList);
    }
}
