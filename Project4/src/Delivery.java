public class Delivery extends Truck {
    //Delivery is inheriting the class Truck

    static int counter = 0;
    Delivery(UnlockStrategy unlockStrategy) {
        super.setUnlockStrategy(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
        super.setClassName(this.getClass().getName());
    }
}
