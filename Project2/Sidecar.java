public class Sidecar extends Motorcycle {
    //Sidecar is inheriting the class Motorcycle

    static int counter = 0;
    Sidecar() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
