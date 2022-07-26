public class Sidecar extends Motorcycle {
    //Sidecar is inheriting the class Motorcycle

    static int counter = 0;
    Sidecar(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
