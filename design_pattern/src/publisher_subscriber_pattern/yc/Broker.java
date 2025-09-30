package publisher_subscriber_pattern.yc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Broker {
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void subscribe(String topic, Subscriber subscriber) {
        subscribers.computeIfAbsent(
                topic, k -> new ArrayList<>()
        ).add(subscriber);
    }

    public void publish(Message message) {
        List<Subscriber> topicSubscribers = subscribers.get(message.getTopic());

        if (topicSubscribers != null) {
            for (Subscriber subscriber : topicSubscribers) {
                subscriber.update(message);
            }
        }
    }
}
