public class FishingBoat extends Boat {
    //FishingBoat is inheriting the class Boat

    static int counter = 0;
    FishingBoat() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
