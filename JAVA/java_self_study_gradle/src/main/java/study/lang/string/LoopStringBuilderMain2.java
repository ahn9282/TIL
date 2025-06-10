package study.lang.string;

public class LoopStringBuilderMain2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String result = sb.append("A").append("B").append("C").append("D")
                .insert(4, "java")
                .delete(4, 8)
                .reverse().toString();

        System.out.println("result = " + result);
    }
}
