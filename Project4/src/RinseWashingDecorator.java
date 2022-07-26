public class RinseWashingDecorator extends WashingDecorator{
    // Decorator Pattern implementation
    RinseWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Rinsed. ";
    }
}
