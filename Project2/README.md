# OOAD Project2 - Garage

## Tavishi Priyam and Manan Khasgiwale

### Repository Comments
Project2 contains the Java code for a garage full of vehicles. There are four different types of vehicles in the garage including Motorcycle, Car,Truck and Boat.
Each type of vehicle has subclasses as follows: **Motorcycle** - Bike, Trike, Sidecar; **Car** - Hatchback, SUV, Wagon, Convertible; **Truck** - Pickup, Delivery, Monster; **Boat** - Lifeboat, Fishingboat. 
Each vehicle has been instantiated atleast twice. The class files for this project are:
* **Garage.java:** This class contains the main method. Run this class to run the java program.


* **Vehicle.java:** This class defines identity for each vehicle in the form of a licensePlate and returns string after a task is completed by the mechanic.


* **GarageEmployee.java:** This class is an abstract class being inherited by the class Mechanic. It defines all the methods being performed by the mechanic. 
* **Mechanic.java:** This class inherits the abstract class GarageEmployee.


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
* Add vehicles to garage.
* Remove vehicles from the garage.
* Add mechanic to the garage.
* Remove mechanic from the garage.
* Mechanic performs the tasks on the vehicles including: unlock, wash, tuneUp, testDrive, lockUp.
* Vehicle responds to the tasks.
* Perform these tasks for n number of days.

### Assumptions
* There a limited number of mechanics working in the garage.
* Only one mechanic can work in the garage at once.
* One mechanic can work on only one vehicle at a time.

### Issues encountered
* One issue that we encountered was figuring out how to remove mechanic from the garage once monster crashes and make the next one pick up where the last one left off. 
* This was resolved by making use of a list to store all the mechanics and removing instance from the list everytime a mechanic stops working.

### Execution instructions
* Select the Garage.java file and click on the run button.
* Enter the number of days to run the program. 

