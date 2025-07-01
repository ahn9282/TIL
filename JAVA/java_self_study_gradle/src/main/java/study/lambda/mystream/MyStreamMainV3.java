package study.lambda.mystream;

import java.util.List;

public class MyStreamMainV3 {

    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Apple", 100),
                new Student("Banana", 880),
                new Student("Berry", 70),
                new Student("Tomato", 50),
                new Student("Orange", 34));

        List<String> result1 = ex1(students);
        System.out.println("result1 = " + result1);
        List<String> result2 = ex2(students);
        System.out.println("result2 = " + result2);
    }

    private static List<String> ex1(List<Student> students) {
        return MyStreamV3.of(students).filter(s -> s.getScore() >= 80).map(s -> s.getName()).toList();
    }
    private static List<String> ex2(List<Student> students) {
        return MyStreamV3.of(students).filter(s -> s.getScore() >= 80 && s.getName().length() >=5).map(s -> s.getName().toUpperCase()).toList();
    }

}
