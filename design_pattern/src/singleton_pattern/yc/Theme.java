package singleton_pattern.yc;

public class Theme {
    private static Theme instance;
    private String themeColor;

    private Theme(){
        this.themeColor = "light";
    }

    public static Theme getInstance(){
        if(instance == null){
            instance = new Theme();
        }
        return instance;
    }

    public String getThemeColor(){
        return themeColor;
    }
    public void setThemeColor(String themeColor){
        this.themeColor = themeColor;
    }
}
