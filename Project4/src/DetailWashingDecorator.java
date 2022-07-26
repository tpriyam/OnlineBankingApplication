public class DetailWashingDecorator extends WashingDecorator{
    // Decorator Pattern implementation
    DetailWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Detailed. ";
    }
}
