import java.util.Random;

public class Monster extends Truck {
    //Monster is inheriting the class Truck

    static int counter = 0;
    Monster() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }

    // Polymorphism: runs method of Monster will be called
    @Override
    public String drives() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt > 20) {
            return super.drives();
        } else {
            return "crashes";
        }
    }
}
