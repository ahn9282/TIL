package chain_of_reponsibility_pattern.yc;

public class Main1 {
    public static void main(String[] args) {
        PositiveHandler positive = new PositiveHandler();
        EvenHandler even = new EvenHandler();
        DivisibleBy3Handler divisibleBy3 = new DivisibleBy3Handler();

        positive.setNext(even);
        even.setNext(divisibleBy3);

        positive.handle(-2);
        positive.handle(4);
        positive.handle(6);
    }
}
