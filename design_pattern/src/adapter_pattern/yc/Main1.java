package adapter_pattern.yc;

public class Main1 {
    public static void main(String[] args) {

        OldMessageSender oldSystem = new OldMessageSystem();
        MessageAdapter adapter = new MessageAdapter(oldSystem);

        adapter.sendMessage("Hello World", "jsa@design.pattern");
    }
}
