public class Pickup extends Truck {
    //Pickup is inheriting the class Truck

    static int counter = 0;
    Pickup() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
