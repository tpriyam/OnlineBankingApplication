public class CarFactory extends VehicleFactory{
    // Factory pattern implementation
    @Override
    public Vehicle getVehicle(String vehicleType) {
        // Instantiating cars using factory pattern
        if (vehicleType.equalsIgnoreCase("Convertible")) {
            Vehicle convertible = new Convertible(new VehicleUnlockStrategy());
            convertible = new SoapWashingDecorator(convertible);
            convertible = new ScrubWashingDecorator(convertible);
            convertible = new RinseWashingDecorator(convertible);
            convertible = new DryWashingDecorator(convertible);
            convertible = new WaxWashingDecorator(convertible);
            convertible = new DetailWashingDecorator(convertible);
            convertible = new DetailWashingDecorator(convertible);
            return convertible;
        } else if (vehicleType.equalsIgnoreCase("HatchBack")) {
            Vehicle hatchback = new Hatchback(new VehicleUnlockStrategy());
            hatchback = new SoapWashingDecorator(hatchback);
            hatchback = new ScrubWashingDecorator(hatchback);
            hatchback = new RinseWashingDecorator(hatchback);
            hatchback = new DryWashingDecorator(hatchback);
            return hatchback;
        } else if (vehicleType.equalsIgnoreCase("Wagon")) {
            Vehicle wagon = new Wagon(new VehicleUnlockStrategy());
            wagon = new SoapWashingDecorator(wagon);
            wagon = new ScrubWashingDecorator(wagon);
            wagon = new RinseWashingDecorator(wagon);
            wagon = new DryWashingDecorator(wagon);
            return wagon;
        } else if (vehicleType.equalsIgnoreCase("SUV")) {
            Vehicle suv = new SUV(new VehicleUnlockStrategy());
            suv = new SoapWashingDecorator(suv);
            suv = new ScrubWashingDecorator(suv);
            suv = new RinseWashingDecorator(suv);
            suv = new DryWashingDecorator(suv);
            return suv;
        }
        return null;
    }
}
