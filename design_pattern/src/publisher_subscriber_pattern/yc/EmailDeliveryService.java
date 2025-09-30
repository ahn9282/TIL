package publisher_subscriber_pattern.yc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailDeliveryService {
    private Map<String, List<Customer>> customerGroups = new HashMap<>();
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void subscribe(String eventType, Customer customer) {
        customerGroups.computeIfAbsent(eventType, k -> new ArrayList<>()).add(customer);
    }

    public void sendEmails(String eventType, String message) {
        List<Customer> customers = customerGroups.get(eventType);
        if (customers != null) {
            for (Customer customer : customers) {
                executorService.submit(() -> customer.receiveEmail(message));
            }
        }
    }
    public void shutdown(){
        executorService.shutdown();
    }
}
