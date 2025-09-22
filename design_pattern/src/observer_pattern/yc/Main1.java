package observer_pattern.yc;

public class Main1 {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel channel1 = new NewsChannel("Channel 1");
        NewsChannel channel2 = new NewsChannel("Channel 2");

        agency.registerObserver(channel1);
        agency.registerObserver(channel2);

        agency.setNews("Breaking news : Observer Pattern in action!!");

        agency.removeObserver(channel2);
        agency.setNews("Another update : Channel 2 unSubscribed!!");

    }
}
