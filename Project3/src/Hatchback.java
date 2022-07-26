public class Hatchback extends Car {
    //Hatchback is inheriting the class Car

    static int counter = 0;
    Hatchback(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
