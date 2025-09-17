package singleton_pattern.yc;

public class Button {
    private String label;

    public Button(String label){
        this.label = label;
    }

    public void display(){
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Button [" + label + "] display in : " + themeColor + " theme.");
    }
}
