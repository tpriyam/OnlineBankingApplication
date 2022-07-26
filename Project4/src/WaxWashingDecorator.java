public class WaxWashingDecorator extends WashingDecorator{
    // Decorator Pattern implementation
    WaxWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Waxed. ";
    }
}
