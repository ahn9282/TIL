package decorator_pattern.yc;

public class Main2 {
    public static void main(String[] args) {

        Text text = new PlainText("Hello Decorator Pattern!!");
        System.out.println("Plain text : " + text.getContent());

        text = new TextDecorator.BoldDecorator(text);
        System.out.println("Bold text = " + text);

        text = new TextDecorator.ItalicDecorator(text);
        System.out.println("Italic text = " + text);

        text = new TextDecorator.UnderlineDecorator(text);
        System.out.println("Underline text = " + text);
    }
}
