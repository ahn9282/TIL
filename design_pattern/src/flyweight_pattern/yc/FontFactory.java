package flyweight_pattern.yc;

import java.util.HashMap;

public class FontFactory {
    private static final HashMap<String, Font> fontMap = new HashMap<>();

    public static Font getFont(String font, int size, String color){
        String key = font + size + color;
        Font fontObject = fontMap.get(key);

        if(fontObject == null){
            fontObject = new ConcreteFont(font, size, color);
            fontMap.put(key, fontObject);
            System.out.println("Creating Font : " + font);
        } else {
            System.out.println("Reusing Font : " + key);
        }
        return fontObject;
    }
}
