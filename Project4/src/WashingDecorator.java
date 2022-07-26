public abstract class WashingDecorator extends Vehicle {
    // Decorator Pattern implementation
    // https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
    private Vehicle vehicle;

    public WashingDecorator(Vehicle vehicle) {
        super();
        this.setVehicle(vehicle);
    }

    @Override
    public String shines() {
        return getVehicle().shines();
    }

    @Override
    public UnlockStrategy getUnlockStrategy() {
        return getVehicle().getUnlockStrategy();
    }

    @Override
    public String unlocked() {
        return getVehicle().getUnlockStrategy().unlockStrategy();
    }

    @Override
    public String getLicensePlate() {
        return getVehicle().getLicensePlate();
    }

    @Override
    public String getClassName() {
        return getVehicle().getClassName();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
