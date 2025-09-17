package singleton_pattern.yc;

public class TextField {

    private String text;

    public TextField(String text){
        this.text = text;
    }

    public void display(){
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("TextField [" + text + "] display in : " + themeColor + " theme.");
    }
}
