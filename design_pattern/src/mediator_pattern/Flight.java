package mediator_pattern;

public class Flight {
    private AirportMediator mediator;
    private String flightNumber;

    public Flight(AirportMediator mediator, String flightNumber) {
        this.mediator = mediator;
        this.flightNumber = flightNumber;
    }

    public void land(){
        if(mediator.isRunwayAvailable()){
            System.out.println("Flight " + flightNumber + " Landed");
            mediator.setRunwayAvailable(false);
        } else {
            System.out.println("Flight " + flightNumber + " is waiting to land");
        }
    }
}
