public class SUV extends Car {
    //SUV is inheriting the class Car

    static int counter = 50000;
    SUV(UnlockStrategy unlockStrategy) {
        super.setUnlockStrategy(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
        super.setClassName(this.getClass().getName());
    }
}
