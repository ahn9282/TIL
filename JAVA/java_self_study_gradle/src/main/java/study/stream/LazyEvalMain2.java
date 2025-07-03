package study.stream;

import study.lambda.mystream.MyStreamV3;

import java.util.List;
import java.util.stream.Stream;


public class LazyEvalMain2 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        ex1(list);
        ex2(list);
    }

    public static void ex1(List<Integer> data){
        System.out.println("== MyStreamV3 시작 ===");
        Integer result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행 : " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행 : " + i + "(" + mapped + ")");
                    return mapped;
                }).getFirst();
        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ===");
    }
    public static void ex2(List<Integer> data){
        System.out.println("== MyStreamV3 시작 ===");
        data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행 : " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행 : " + i + "(" + mapped + ")");
                    return mapped;
                }).findFirst().get();
        System.out.println("== MyStreamV3 종료 ===");
    }
}
