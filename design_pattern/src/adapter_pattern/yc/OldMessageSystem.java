package adapter_pattern.yc;

public class OldMessageSystem implements OldMessageSender {

    @Override
    public int send(String[] messageData) {
        System.out.println("OleMessageSystem : Sending message : "
                + messageData[0] + " to " + messageData[1]);
        return 1;
    }

}
