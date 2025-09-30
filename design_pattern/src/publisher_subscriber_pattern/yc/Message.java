package publisher_subscriber_pattern.yc;

public class Message {
    private String content;
    private String topic;

    public Message(String content, String topic) {
        this.content = content;
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public String getTopic() {
        return topic;
    }
}
