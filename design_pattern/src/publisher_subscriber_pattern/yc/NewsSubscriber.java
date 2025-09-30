package publisher_subscriber_pattern.yc;

public class NewsSubscriber implements Subscriber {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Message message) {
        System.out.println(name + " received. on  topic : " + message.getTopic());
    }
}
