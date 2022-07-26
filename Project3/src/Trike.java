public class Trike extends Motorcycle {
    //Trike is inheriting the class Motorcycle

    static int counter = 0;
    Trike(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
