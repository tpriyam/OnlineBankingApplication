public class MotorcycleFactory extends VehicleFactory{
    // Factory pattern implementation
    @Override
    public Vehicle getVehicle(String vehicleType) {
        // Instantiating motorcycles using factory pattern
        if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Trike")) {
            return new Trike(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Sidecar")) {
            return new Sidecar(new VehicleUnlockStrategy());
        }
        return null;
    }
}
