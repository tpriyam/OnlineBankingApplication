import java.util.Random;

public class Bike extends Motorcycle {
    //Bike is inheriting the class Motorcycle

    static int counter = 0;
    Bike(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setUnlockStrategy(unlockStrategy);
        //Abstraction: initLicensePlate implementation details are hidden
        super.setLicensePlate(super.initLicensePlate(counter++));
        super.setClassName(this.getClass().getName());
    }
}
