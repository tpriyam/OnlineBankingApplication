public class BoatFactory extends VehicleFactory{
    // Factory pattern implementation
    @Override
    public Vehicle getVehicle(String vehicleType) {
        // Instantiating boats using factory pattern
        if (vehicleType.equalsIgnoreCase("FishingBoat")) {
            Vehicle fishingBoat = new FishingBoat(new VehicleUnlockStrategy());
            fishingBoat = new SoapWashingDecorator(fishingBoat);
            fishingBoat = new ScrubWashingDecorator(fishingBoat);
            fishingBoat = new RinseWashingDecorator(fishingBoat);
            fishingBoat = new DryWashingDecorator(fishingBoat);
            return fishingBoat;
        } else if (vehicleType.equalsIgnoreCase("LifeBoat")) {
            Vehicle lifeBoat = new LifeBoat(new VehicleUnlockStrategy());
            lifeBoat = new SoapWashingDecorator(lifeBoat);
            lifeBoat = new ScrubWashingDecorator(lifeBoat);
            lifeBoat = new RinseWashingDecorator(lifeBoat);
            lifeBoat = new DryWashingDecorator(lifeBoat);
            return lifeBoat;
        }
        return null;
    }
}
