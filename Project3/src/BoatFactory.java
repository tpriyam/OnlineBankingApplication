public class BoatFactory extends VehicleFactory{
    // Factory pattern implementation
    @Override
    public Vehicle getVehicle(String vehicleType) {
        // Instantiating boats using factory pattern
        if (vehicleType.equalsIgnoreCase("FishingBoat")) {
            return new FishingBoat(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("LifeBoat")) {
            return new LifeBoat(new VehicleUnlockStrategy());
        }
        return null;
    }
}
