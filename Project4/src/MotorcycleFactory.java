public class MotorcycleFactory extends VehicleFactory{
    // Factory pattern implementation
    @Override
    public Vehicle getVehicle(String vehicleType) {
        // Instantiating motorcycles using factory pattern
        if (vehicleType.equalsIgnoreCase("Bike")) {
            Vehicle bike = new Bike(new VehicleUnlockStrategy());
            bike = new SoapWashingDecorator(bike);
            bike = new ScrubWashingDecorator(bike);
            bike = new RinseWashingDecorator(bike);
            bike = new DryWashingDecorator(bike);
            return bike;
        } else if (vehicleType.equalsIgnoreCase("Trike")) {
            Vehicle trike = new Trike(new VehicleUnlockStrategy());
            trike = new SoapWashingDecorator(trike);
            trike = new ScrubWashingDecorator(trike);
            trike = new RinseWashingDecorator(trike);
            trike = new DryWashingDecorator(trike);
            return trike;
        } else if (vehicleType.equalsIgnoreCase("Sidecar")) {
            Vehicle sidecar = new Sidecar(new VehicleUnlockStrategy());
            sidecar = new SoapWashingDecorator(sidecar);
            sidecar = new ScrubWashingDecorator(sidecar);
            sidecar = new RinseWashingDecorator(sidecar);
            sidecar = new DryWashingDecorator(sidecar);
            return sidecar;
        }
        return null;
    }
}
