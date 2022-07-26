public class LifeBoat extends Boat {
    //LifeBoat is inheriting the class Boat

    static int counter = 0;
    LifeBoat(UnlockStrategy unlockStrategy) {
        super.setUnlockStrategy(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
        super.setClassName(this.getClass().getName());
    }
}
