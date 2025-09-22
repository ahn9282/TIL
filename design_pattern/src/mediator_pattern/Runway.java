package mediator_pattern;

public class Runway {
    private AirportMediator mediator;

    public Runway(AirportMediator mediator) {
        this.mediator = mediator;
    }

    public void clear(){
        System.out.println("runway cleared");
        mediator.setRunwayAvailable(true);
    }
}
