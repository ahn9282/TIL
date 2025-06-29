package study.lambda.lambda2.ex2;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
    // 고차 함수, 함수를 인자로 받아, 리스트의 각 요소를 변환
    public static List<String> map(List<String> list, StringFunction func) {
        // 코드 작성
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
           result.add(func.apply(list.get(i)));
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);
        // 1. 대문자 변환
        // 코드 작성
        List<String> uppers = map(words, String::toUpperCase);
        System.out.println("uppers = " + uppers);

        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        // 코드 작성
        List<String> withStars = map(words, word -> "***" + word);
        System.out.println("withStars = " + withStars);
    }
}