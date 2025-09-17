package factory_pattern.yc;

public class Main {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        carFactory.deliverVehicle();

        MotorcycleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.deliverVehicle();
    }
}
