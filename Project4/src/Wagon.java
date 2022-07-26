public class Wagon extends Car {
    //Wagon is inheriting the class Car

    static int counter = 0;
    Wagon(UnlockStrategy unlockStrategy) {
        super.setUnlockStrategy(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
        super.setClassName(this.getClass().getName());
    }
}
