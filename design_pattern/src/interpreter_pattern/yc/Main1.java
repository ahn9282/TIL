package interpreter_pattern.yc;

public class Main1 {
    public static void main(String[] args) {

        Number five = new Number(5);
        Number two = new Number(2);
        Number three = new Number(3);

        Expression addExpression = new Add(five, two);

        Subtract subtractExpression = new Subtract(addExpression, three);

        System.out.println("(5 + 2) - 3 = " + subtractExpression.interpret());
    }
}
