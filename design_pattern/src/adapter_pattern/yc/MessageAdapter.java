package adapter_pattern.yc;

public class MessageAdapter implements ModernMessageSender {
    private OldMessageSender oldMessageSystem;

    public MessageAdapter(OldMessageSender oldMessageSystem) {
        this.oldMessageSystem = oldMessageSystem;
    }

    @Override
    public void sendMessage(String message, String recipient) {
        String[] messageData = {message, recipient};
        int result = oldMessageSystem.send(messageData);
        if (result != 1) {
            System.out.println("Failed to send message");

        }
    }
}
