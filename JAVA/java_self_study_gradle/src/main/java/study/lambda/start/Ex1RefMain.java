package study.lambda.start;

import study.lambda.Procedure;

import java.util.Random;

public class Ex1RefMain {

    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("실행시간 : " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        hello(new Dice());
        hello(new Sum());
    }

    static class Dice implements Procedure {
        public void run() {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        }
    }

    static class Sum implements Procedure {
        public void run(){
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        }

    }

}
