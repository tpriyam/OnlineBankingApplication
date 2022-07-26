public class SoapWashingDecorator extends WashingDecorator{
    // Decorator Pattern implementation
    SoapWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Soaped. ";
    }

}
