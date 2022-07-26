public class Pickup extends Truck {
    //Pickup is inheriting the class Truck

    static int counter = 0;
    Pickup(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
