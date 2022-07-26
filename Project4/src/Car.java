import java.util.Random;

public class Car extends Vehicle {
    //Car is inheriting the class Vehicle
//    Car(UnlockStrategy unlockStrategy) {
//        super.setUnlockStrategy(unlockStrategy);
//    }

    // Polymorphism: runs method of Car will be called
    // for Car and it's subclasses
    @Override
    public String runs() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt > 25) {
            return super.runs();
        } else {
            return "sputters";
        }
    }
}
