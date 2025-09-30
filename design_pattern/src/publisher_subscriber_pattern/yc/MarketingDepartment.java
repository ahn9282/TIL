package publisher_subscriber_pattern.yc;

public class MarketingDepartment {
    private EmailDeliveryService emailService;
    private String eventType;

    public MarketingDepartment(EmailDeliveryService emailService, String eventType) {
        this.emailService = emailService;
        this.eventType = eventType;
    }

    public void launchCampaign(String message) {
        System.out.println("Launching campaign : " + message);
        emailService.sendEmails(eventType, message);
    }
}
