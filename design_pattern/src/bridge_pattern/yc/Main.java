package bridge_pattern.yc;

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        BasicRemote basicRemote = new BasicRemote(tv);
        basicRemote.power();
        basicRemote.volumeUp();

        System.out.println();

        Radio radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.power();
        advancedRemote.mute();

    }
}
