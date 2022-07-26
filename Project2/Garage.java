import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage {

    public static void main(String[] args) {

        // input number of days
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days : ");
        int numberOfDays = sc.nextInt();

        // list of Mechanics available for work
        List<String> mechanicNames = new ArrayList<>();
        mechanicNames.add("Marco");
        mechanicNames.add("Paula");
        mechanicNames.add("Robert");
        Mechanic mechanic1 = new Mechanic(mechanicNames.get(0));
        mechanicNames.remove(0);

        // various vehicle instances in garage
        Bike b1 = new Bike();
        Bike b2 = new Bike();
        Trike t1 = new Trike();
        Trike t2 = new Trike();
        Sidecar s1 = new Sidecar();
        Sidecar s2 = new Sidecar();

        Hatchback h1 = new Hatchback();
        Hatchback h2 = new Hatchback();
        SUV suv1 = new SUV();
        SUV suv2 = new SUV();
        Wagon w1 = new Wagon();
        Wagon w2 = new Wagon();
        Convertible c1 = new Convertible();
        Convertible c2 = new Convertible();

        Pickup p1 = new Pickup();
        Pickup p2 = new Pickup();
        Delivery d1 = new Delivery();
        Delivery d2 = new Delivery();
        Monster m1 = new Monster();
        Monster m2 = new Monster();

        LifeBoat l1 = new LifeBoat();
        LifeBoat l2 = new LifeBoat();
        FishingBoat f1 = new FishingBoat();
        FishingBoat f2 = new FishingBoat();

        // vehicle list of vehicles in garage
        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(b1);
        vehiclesInGarage.add(b2);
        vehiclesInGarage.add(t1);
        vehiclesInGarage.add(t2);
        vehiclesInGarage.add(s1);
        vehiclesInGarage.add(s2);
        vehiclesInGarage.add(h1);
        vehiclesInGarage.add(h2);
        vehiclesInGarage.add(suv1);
        vehiclesInGarage.add(suv2);
        vehiclesInGarage.add(w1);
        vehiclesInGarage.add(w2);
        vehiclesInGarage.add(c1);
        vehiclesInGarage.add(c2);
        vehiclesInGarage.add(p1);
        vehiclesInGarage.add(p2);
        vehiclesInGarage.add(d1);
        vehiclesInGarage.add(d2);
        vehiclesInGarage.add(m1);
        vehiclesInGarage.add(m2);
        vehiclesInGarage.add(l1);
        vehiclesInGarage.add(l2);
        vehiclesInGarage.add(f1);
        vehiclesInGarage.add(f2);

        // processing each day of work
        for (int counter = 0; counter < numberOfDays; counter++) {
            System.out.println("Mechanic " + mechanic1.getName() + " arrives at Garage on Day " + (counter+1) + ".");
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic1 is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic1.unlock(v);

                // Polymorphism: Bike class is calling method defined in Vehicle
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.unlocked() + ".");
            }
            System.out.println();
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic1 is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic1.wash(v);
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.shines() + ".");
            }
            System.out.println();
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic1 is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic1.tuneUp(v);
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.runs() + ".");
            }
            System.out.println();

            for(int ind = 0; ind < vehiclesInGarage.size(); ind++) {
                Vehicle v = vehiclesInGarage.get(ind);
                //Polymorphism: mechanic1 is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic1.testDrive(v);
                String d = v.drives();
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + d + ".");
                if(v.getClass().getName().equals("Monster") && d.equals("crashes")) {
                    vehiclesInGarage.remove(ind);
                    ind = ind - 1;
                    System.out.println("Mechanic " + mechanic1.getName() + " leaves at Garage. ");
                    mechanic1 = new Mechanic(mechanicNames.get(0));
                    mechanicNames.remove(0);
                    System.out.println("Mechanic " + mechanic1.getName() + " arrives at Garage. ");
                }
            }
            System.out.println();
            for(Vehicle v : vehiclesInGarage) {
                //Polymorphism: mechanic1 is polymorphically being treated as GarageEmployee since Mechanic inherits GarageEmployee
                mechanic1.lockUp(v);
                System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.locked() + ".");
            }
            System.out.println("Mechanic " + mechanic1.getName() + " leaves at Garage on Day " + (counter+1) +".");
            System.out.println();
        }
        // done processing all the days
    }
}