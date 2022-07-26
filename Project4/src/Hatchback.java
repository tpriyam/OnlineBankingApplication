public class Hatchback extends Car {
    //Hatchback is inheriting the class Car

    static int counter = 0;
    Hatchback(UnlockStrategy unlockStrategy) {
        super.setUnlockStrategy(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
        super.setClassName(this.getClass().getName());
    }
}
