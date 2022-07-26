public class Delivery extends Truck {
    //Delivery is inheriting the class Truck

    static int counter = 0;
    Delivery(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
