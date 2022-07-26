import java.util.Random;

public class Vehicle {
    //encapsulation: licensePlate is hidden via private access modifier and can be accessed via getters/setters

    //Identity of Vehicle: Each vehicle has a unique licensePlate
    private String licensePlate;
    private UnlockStrategy unlockStrategy;

    public Vehicle(UnlockStrategy unlockStrategy) {
        this.unlockStrategy = unlockStrategy;
    }
    // Strategy pattern implementation on unlock

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String initLicensePlate(int counter) {
        // https://stackoverflow.com/questions/17696946/how-to-format-a-3-digit-integer-to-a-4-digit-string
        return this.getClass().getName().toCharArray()[0]+String.format("%05d", counter);
    }

    // base implementation of methods
    public void setUnlockStrategy(UnlockStrategy unlockStrategy) {
        this.unlockStrategy = unlockStrategy;
    }

    public String unlocked() {
        return this.unlockStrategy.unlockStrategy();
    }

    public String shines() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt > 30) {
            return "shines";
        } else {
            return "sparkles";
        }
    }

    public String runs() {
        return "runs";
    }

    public String drives() {
        return "drives";
    }

    public String locked() {
        return "locked";
    }
}

