public class Motorcycle extends Vehicle {
    //Motorcycle is inheriting the class Vehicle
    Motorcycle(UnlockStrategy unlockStrategy) {
        super.setUnlockStrategy(unlockStrategy);
    }
}
