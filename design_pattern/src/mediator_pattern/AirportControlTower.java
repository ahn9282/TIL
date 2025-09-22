package mediator_pattern;

public class AirportControlTower implements AirportMediator {

    private boolean isRunwayAvailable = true;

    @Override
    public boolean isRunwayAvailable() {
        return isRunwayAvailable;
    }

    @Override
    public void setRunwayAvailable(boolean status) {
        isRunwayAvailable = status;
    }
}
