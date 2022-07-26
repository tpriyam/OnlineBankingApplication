import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage {

    public static void main(String[] args) throws InterruptedException {

        // Vehicle factories
        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();
        VehicleFactory boatFactory = new BoatFactory();

        // vehicle list of vehicles in garage
        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Bike"));
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Trike"));
        vehiclesInGarage.add(motorcycleFactory.getVehicle("SideCar"));
        vehiclesInGarage.add(carFactory.getVehicle("HatchBack"));
        vehiclesInGarage.add(carFactory.getVehicle("SUV"));
        vehiclesInGarage.add(carFactory.getVehicle("Wagon"));
        vehiclesInGarage.add(carFactory.getVehicle("Convertible"));
        vehiclesInGarage.add(truckFactory.getVehicle("Pickup"));
        vehiclesInGarage.add(truckFactory.getVehicle("Delivery"));
        vehiclesInGarage.add(truckFactory.getVehicle("Monster"));
        vehiclesInGarage.add(boatFactory.getVehicle("FishingBoat"));
        vehiclesInGarage.add(boatFactory.getVehicle("LifeBoat"));

        System.out.println("A Day at the Garage");
        User user = User.getInstance();

        Scanner sc = new Scanner(System.in);

        // Instantiating the commands
        UnlockCommand unlockCommand = new UnlockCommand(user, vehiclesInGarage);
        WashCommand washCommand = new WashCommand(user, vehiclesInGarage);
        TuneUpCommand tuneUpCommand = new TuneUpCommand(user, vehiclesInGarage);
        TestDriveCommand testDriveCommand = new TestDriveCommand(user, vehiclesInGarage);
        LockCommand lockCommand = new LockCommand(user, vehiclesInGarage);

        int selection;
        boolean isVehicleUnlocked = false;

        int currentTime = 9;

        while (currentTime <= 20) {
            System.out.println(String.format("Garage menu. Current time is " + currentTime++ + "00!", "%2d"));
            System.out.println("1. Unlock all vehicles");
            System.out.println("2. Wash all vehicles");
            System.out.println("3. Tune-up all vehicles");
            System.out.println("4. Test Drive all vehicles");
            System.out.println("5. Lock all vehicles");
            System.out.println("9. Leave for the day");
            System.out.println("Press your selection: ");

            selection = sc.nextInt();

            switch (selection) {
                case 1:
                    user.setCommand(unlockCommand);
                    unlockCommand.execute();
                    isVehicleUnlocked = true;
                    System.out.println("All vehicles are unlocked.");
                    System.out.println();
                    break;
                case 2:
                    if (isVehicleUnlocked == false) {
                        System.out.println("ERROR: Need to unlock vehicles before this action.");
                    } else {
                        user.setCommand(washCommand);
                        washCommand.execute();
                        System.out.println("All vehicles are washed.");
                        System.out.println();
                    }
                    break;
                case 3:
                    if (isVehicleUnlocked == false) {
                        System.out.println("ERROR: Need to unlock vehicles before this action.");
                    } else {
                        user.setCommand(tuneUpCommand);
                        tuneUpCommand.execute();
                        System.out.println("All vehicles are tuned up.");
                        System.out.println();
                    }
                    break;
                case 4:
                    if (isVehicleUnlocked == false) {
                        System.out.println("ERROR: Need to unlock vehicles before this action.");
                    } else {
                        user.setCommand(testDriveCommand);
                        testDriveCommand.execute();
                        System.out.println("All vehicles drive.");
                        System.out.println();
                    }
                    break;
                case 5:
                    if (isVehicleUnlocked == false) {
                        System.out.println("ERROR: Need to unlock vehicles before this action.");
                    } else {
                        user.setCommand(lockCommand);
                        lockCommand.execute();
                        isVehicleUnlocked = false;
                        System.out.println("All vehicles are locked.");
                        System.out.println();
                    }
                    break;
                case 9:
                    System.out.println("Ending for the day...");
                    return;
            }
        }
        System.out.println("Closing time. Good day!");
    }
}