public class TruckFactory extends VehicleFactory{
    // Factory pattern implementation
    @Override
    public Vehicle getVehicle(String vehicleType) {
        // Instantiating trucks using factory pattern
        if (vehicleType.equalsIgnoreCase("Pickup")) {
            Vehicle pickup = new Pickup(new VehicleUnlockStrategy());
            pickup = new SoapWashingDecorator(pickup);
            pickup = new ScrubWashingDecorator(pickup);
            pickup = new RinseWashingDecorator(pickup);
            pickup = new DryWashingDecorator(pickup);
            return pickup;
            // Adding a strategy during instantiation
        } else if (vehicleType.equalsIgnoreCase("Delivery")) {
            Vehicle delivery = new Delivery(new VehicleUnlockStrategy());
            delivery = new SoapWashingDecorator(delivery);
            delivery = new ScrubWashingDecorator(delivery);
            delivery = new RinseWashingDecorator(delivery);
            delivery = new DryWashingDecorator(delivery);
            return delivery;
        } else if (vehicleType.equalsIgnoreCase("Monster")) {
            Vehicle monster = new Monster(new VehicleUnlockStrategy());
            monster = new SoapWashingDecorator(monster);
            monster = new ScrubWashingDecorator(monster);
            monster = new RinseWashingDecorator(monster);
            monster = new DryWashingDecorator(monster);
            monster = new WaxWashingDecorator(monster);
            monster = new WaxWashingDecorator(monster);
            monster = new PolishWashingDecorator(monster);
            monster = new DetailWashingDecorator(monster);
            return monster;
        }
        return null;
    }
}
