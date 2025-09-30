package publisher_subscriber_pattern.yc;

public class Main2 {
    public static void main(String[] args) {
        EmailDeliveryService emailService = new EmailDeliveryService();

        MarketingDepartment marketing = new MarketingDepartment(emailService, "ProductLaunch");

        Customer customer1 = new IndividualCustomer("Customer 1");
        Customer customer2 = new IndividualCustomer("Customer 2");

        emailService.subscribe("ProductLaunch", customer1);
        emailService.subscribe("ProductLaunch", customer2);

        marketing.launchCampaign("New Product");

        Customer customer3 = new IndividualCustomer("Customer 3");
        emailService.subscribe("ProductLaunch", customer3);

        marketing.launchCampaign("Update");

        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        emailService.shutdown();
    }
}
