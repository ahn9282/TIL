package factory_pattern.yc;

public class CarFactory extends VehicleFactory{
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
