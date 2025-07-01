package study.lambda.mystream;

import java.util.List;

public class MyStreamLoofMain {

    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Apple", 100),
                new Student("Banana", 880),
                new Student("Berry", 70),
                new Student("Tomato", 50),
                new Student("Orange", 34));

        List<String> result = MyStreamV3.of(students).filter(s -> s.getScore() >= 80).map(s -> s.getName()).toList();
        System.out.println("result = " + result);

        for (String s : result) {
            System.out.println("name : " + s);
        }
       MyStreamV3.of(students).filter(s -> s.getScore() >= 80).forEach(s -> System.out.println("student : " + s.getName()));
    }


}
