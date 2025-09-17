package singleton_pattern.yc;

public class Label {
    private String text;

    public Label(String text){
        this.text = text;
    }

    public void display(){
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Label [" + text + "] display in : " + themeColor + " theme.");
    }
}
