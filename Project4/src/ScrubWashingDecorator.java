public class ScrubWashingDecorator extends WashingDecorator{
    // Decorator Pattern implementation
    ScrubWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Scrubbed. ";
    }
}
