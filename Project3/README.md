# OOAD Project3 - Garage

## Tavishi Priyam and Manan Khasgiwale

### Repository Comments
Project3 contains the Java code for a garage full of vehicles. There are four different types of vehicles in the garage 
including Motorcycle, Car, Truck and Boat. Each type of vehicle has subclasses as follows: 
**Motorcycle** - Bike, Trike, Sidecar; **Car** - Hatchback, SUV, Wagon, Convertible; 
**Truck** - Pickup, Delivery, Monster; **Boat** - Lifeboat, FishingBoat.
Each vehicle has been instantiated at least twice with the help of Vehicle Factory for each Vehicle subclass. 
The class files for this project are:

* **Garage.java:** This class contains the main method. Run this class to run the java program.


* **VehicleFactory.java:** This is an abstract class for creating vehicle instances implemented using factory pattern guidelines.
* **BoatFactory.java:** This is a class for creating boat instances.
* **CarFactory.java:** This is a class for creating car instances.
* **MotorcycleFactory.java:** This is a class for creating motorcycle instances.
* **TruckFactory.java:** This is a class for creating truck instances.


* **UnlockStrategy.java:** This is an interface for creating vehicle unlock strategies using strategy pattern guidelines.
* **VehicleUnlockStrategy.java:** This is a class for implementing a particular vehicle unlock strategy.


* **Vehicle.java:** This class defines identity for each vehicle in the form of a licensePlate and returns string after a task gets completed by the mechanic.


* **GarageEmployee.java:** This class is an abstract class being inherited by the class Mechanic. It defines all the methods performed by the mechanic.
* **Mechanic.java:** This class inherits the abstract class GarageEmployee. It observes the GarageClock and is an observable to GarageAnnouncer.
* **GarageAnnouncer.java:** This class inherits the abstract class GarageEmployee. It observes the GarageClock and Mechanic.
* **GarageClock.java:** This class that maintains the garage time on a particular day. It is an observable to GarageAnnouncer and Mechanic.


* **Motorcycle.java:** This class inherits Vehicle.
* **Car.java:** This class inherits Vehicle.
* **Truck.java:** This class inherits Vehicle.
* **Boat.java:** This class inherits Vehicle.


* **Bike.java:** This class inherits Motorcycle and initiates licensePlate for each Bike.
* **Trike.java:** This class inherits Motorcycle and initiates licensePlate for each Trike.
* **Sidecar.java:** This class inherits Motorcycle and initiates licensePlate for each Sidecar.


* **Hatchback.java:** This class inherits Car and initiates licensePlate for each Hatchback.
* **SUV.java:** This class inherits Car and initiates licensePlate for each SUV.
* **Wagon.java:** This class inherits Car and initiates licensePlate for each Wagon.
* **Convertible.java:** This class inherits Car and initiates licensePlate for each Convertible.


* **Pickup.java:** This class inherits Truck and initiates licensePlate for each Pickup.
* **Delivery.java:** This class inherits Truck and initiates licensePlate for each Delivery.
* **Monster.java:** This class inherits Truck and initiates licensePlate for each Monster.


* **LifeBoat.java:** This class inherits Boat and initiates licensePlate for each LifeBoat.
* **FishingBoat.java:** This class inherits Boat and initiates licensePlate for each FishingBoat.

### Project Comments
This project is a virtual garage. Using this project, one can complete the following tasks:
* Create vehicle factory and add vehicles to garage.
* Add/update vehicle unlock strategy for vehicles.
* Remove vehicles from the garage.
* Add mechanic to the garage.
* Remove mechanic from the garage.
* Mechanic performs the tasks on the vehicles including: unlock, wash, tuneUp, testDrive, lockUp. 
* Mechanic performs these tasks at a particular time.
* Vehicle responds to the tasks.
* Perform these tasks for n number of days.
* GarageAnnouncer announcer announces the events.
* GarageClock maintains the time.

### Assumptions
* There a limited number of mechanics working in the garage.
* Only one mechanic can work in the garage at once.
* One mechanic can work on only one vehicle at a time.
* The same GarageAnnouncer arrives and leaves every day.
* Have made providing unlock strategy mandatory by making it the constructor argument.

### Issues encountered
* One issue that we encountered was figuring out how to remove mechanic from the garage once monster crashes and make 
  the next one pick up where the last one left off.
* This was resolved by making use of a list to store all the mechanics and removing instance from the list everytime 
  a mechanic stops working.
* For the Observer Pattern, using the inbuilt Observer/Observable was not possible as the classes were already inheriting the GarageEmployee class. 
  Hence, we decided to use the PropertyChangeListener to implement the Observer pattern.
* Running the GarageClock timer in parallel to the other functions was tricky. We used Runnable to run the thread. This 
  also helps in restarting of the thread multiple times.
  Also included sleep in mechanic to wait for the exact time to run the event. Sleep was also necessary to give the 
  control back to other threads running, else the system was getting blocked while waiting for the time to increment.
  This was due to the PropertyChange method not being called.

### Execution instructions
* Select the Garage.java file and click on the run button.
* Enter the number of days to run the program. 

