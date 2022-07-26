public class TruckFactory extends VehicleFactory{
    // Factory pattern implementation
    @Override
    public Vehicle getVehicle(String vehicleType) {
        // Instantiating trucks using factory pattern
        if (vehicleType.equalsIgnoreCase("Pickup")) {
            return new Pickup(new VehicleUnlockStrategy());
            // Adding a strategy during instantiation
        } else if (vehicleType.equalsIgnoreCase("Delivery")) {
            return new Delivery(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Monster")) {
            return new Monster(new VehicleUnlockStrategy());
        }
        return null;
    }
}
