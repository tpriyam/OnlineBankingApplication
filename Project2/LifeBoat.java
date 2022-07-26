public class LifeBoat extends Boat {
    //LifeBoat is inheriting the class Boat

    static int counter = 0;
    LifeBoat() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
