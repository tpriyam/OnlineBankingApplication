public class LifeBoat extends Boat {
    //LifeBoat is inheriting the class Boat

    static int counter = 0;
    LifeBoat(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
