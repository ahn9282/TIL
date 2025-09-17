package factory_pattern.yc;

public class MotorcycleFactory extends VehicleFactory{
    @Override
    Vehicle createVehicle() {
        return new Motorcycle();
    }
}
