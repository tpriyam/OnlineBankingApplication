public class PolishWashingDecorator extends WashingDecorator{
    // Decorator Pattern implementation
    PolishWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Polished. ";
    }
}
