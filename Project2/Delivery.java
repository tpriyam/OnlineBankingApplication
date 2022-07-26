public class Delivery extends Truck {
    //Delivery is inheriting the class Truck

    static int counter = 0;
    Delivery() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
