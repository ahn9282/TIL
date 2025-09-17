package factory_pattern.yc;

abstract class VehicleFactory {
    abstract Vehicle createVehicle();

    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.println("Delivering the vehicle");
        vehicle.drive();
    }
}
