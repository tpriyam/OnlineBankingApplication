import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage {

    public static void main(String[] args) throws InterruptedException {

        // input number of days
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days : ");
        int numberOfDays = sc.nextInt();

        // list of Mechanics available for work
        List<String> mechanicNames = new ArrayList<>();
        mechanicNames.add("Marco");
        mechanicNames.add("Paula");
        mechanicNames.add("Robert");
        Mechanic mechanic = new Mechanic(mechanicNames.get(0));
        mechanicNames.remove(0);

        // Vehicle factories
        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();
        VehicleFactory boatFactory = new BoatFactory();

        // vehicle list of vehicles in garage
        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Bike"));
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Bike"));
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Trike"));
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Trike"));
        vehiclesInGarage.add(motorcycleFactory.getVehicle("SideCar"));
        vehiclesInGarage.add(motorcycleFactory.getVehicle("SideCar"));
        vehiclesInGarage.add(carFactory.getVehicle("HatchBack"));
        vehiclesInGarage.add(carFactory.getVehicle("HatchBack"));
        vehiclesInGarage.add(carFactory.getVehicle("SUV"));
        vehiclesInGarage.add(carFactory.getVehicle("SUV"));
        vehiclesInGarage.add(carFactory.getVehicle("Wagon"));
        vehiclesInGarage.add(carFactory.getVehicle("Wagon"));
        vehiclesInGarage.add(carFactory.getVehicle("Convertible"));
        vehiclesInGarage.add(carFactory.getVehicle("Convertible"));
        vehiclesInGarage.add(truckFactory.getVehicle("Pickup"));
        vehiclesInGarage.add(truckFactory.getVehicle("Pickup"));
        vehiclesInGarage.add(truckFactory.getVehicle("Delivery"));
        vehiclesInGarage.add(truckFactory.getVehicle("Delivery"));
        vehiclesInGarage.add(truckFactory.getVehicle("Monster"));
        vehiclesInGarage.add(truckFactory.getVehicle("Monster"));
        vehiclesInGarage.add(boatFactory.getVehicle("FishingBoat"));
        vehiclesInGarage.add(boatFactory.getVehicle("FishingBoat"));
        vehiclesInGarage.add(boatFactory.getVehicle("LifeBoat"));
        vehiclesInGarage.add(boatFactory.getVehicle("LifeBoat"));

        GarageClock garageClock = new GarageClock();
        GarageAnnouncer garageAnnouncer = new GarageAnnouncer("Gary");
        Thread thread;

        // processing each day of work
        for (int counter = 0; counter < numberOfDays; counter++) {
            System.out.println("Mechanic " + mechanic.getName() + " arrives at Garage on Day " + (counter+1) + ".");

            mechanic.addPropertyChangeListener(garageAnnouncer);
            garageClock.addPropertyChangeListener(mechanic);
            garageClock.addPropertyChangeListener(garageAnnouncer);
            thread = new Thread(garageClock);
            thread.start();

            mechanic.setState("unlock");
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic.unlock(v);

                // Polymorphism: Bike class is calling method defined in Vehicle
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.unlocked() + ".");
            }
            System.out.println();
            mechanic.setState("wash");
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic.wash(v);
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.shines() + ".");
            }
            System.out.println();
            mechanic.setState("tune up");
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic.tuneUp(v);
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.runs() + ".");
            }
            System.out.println();
            mechanic.setState("drive");
            for(int ind = 0; ind < vehiclesInGarage.size(); ind++) {
                Vehicle v = vehiclesInGarage.get(ind);
                //Polymorphism: mechanic is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic.testDrive(v);
                String d = v.drives();
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + d + ".");
                if(v.getClass().getName().equals("Monster") && d.equals("crashes")) {
                    vehiclesInGarage.remove(ind);
                    ind = ind - 1;
                    System.out.println("Mechanic " + mechanic.getName() + " leaves at Garage. ");
                    mechanic.removePropertyChangeListener(garageAnnouncer);
                    garageClock.removePropertyChangeListener(mechanic);
                    mechanic = new Mechanic(mechanicNames.get(0));
                    mechanicNames.remove(0);
                    mechanic.addPropertyChangeListener(garageAnnouncer);
                    garageClock.addPropertyChangeListener(mechanic);
                    System.out.println("Mechanic " + mechanic.getName() + " arrives at Garage. ");
                }
            }
            System.out.println();
            mechanic.setState("lock up");
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic.lockUp(v);
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.locked() + ".");
            }

            thread.join();
            System.out.println("Mechanic " + mechanic.getName() + " leaves at Garage on Day " + (counter+1) +".");
            System.out.println();

            mechanic.removePropertyChangeListener(garageAnnouncer);
            garageClock.removePropertyChangeListener(mechanic);
            garageClock.removePropertyChangeListener(garageAnnouncer);

        }
        // done processing all the days
    }
}