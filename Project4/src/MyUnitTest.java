import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyUnitTest {
    // Test case implementation with Junit
    // https://www.baeldung.com/junit

    VehicleFactory motorcycleFactory = new MotorcycleFactory();
    VehicleFactory carFactory = new CarFactory();
    VehicleFactory truckFactory = new TruckFactory();
    VehicleFactory boatFactory = new BoatFactory();

    @Test
    public void testBoatRuns() {
        MyUnitTest myUnit = new MyUnitTest();
        Vehicle b1 = boatFactory.getVehicle("FishingBoat");
        Vehicle b2 = boatFactory.getVehicle("LifeBoat");
        // testing runs() method by instantiating boat object
        assertEquals("runs", b1.runs());
        assertEquals("runs", b2.runs());
    }

    @Test
    public void testMonsterDrivesOrCrash(){
        Vehicle m2 = truckFactory.getVehicle("Monster");
        String result = m2.drives();
        // testing monster crash exception
        assertTrue(result.equals("drives") || result.equals("crashes"));
    }

    @Test
    public void testCarRunsOrSputters(){
        Vehicle c1 = carFactory.getVehicle("Convertible");
        Vehicle h1 = carFactory.getVehicle("Hatchback");
        Vehicle suv1 = carFactory.getVehicle("SUV");
        Vehicle w1 = carFactory.getVehicle("Wagon");
        // testing sputters and runs for all cars
        String r1 = c1.runs();
        String r2 = h1.runs();
        String r3 = suv1.runs();
        String r4 = w1.runs();

        assertTrue(r1.equals("sputters") || r1.equals("runs"));
        assertTrue(r2.equals("sputters") || r2.equals("runs"));
        assertTrue(r3.equals("sputters") || r3.equals("runs"));
        assertTrue(r4.equals("sputters") || r4.equals("runs"));
    }

    @Test
    public void testCorrectClassTypeInstantiationFromFactory(){
        Vehicle p1 = truckFactory.getVehicle("Pickup");
        String p1_class = p1.getClassName();

        assertTrue(p1_class.equals("Pickup"));
    }

    @Test
    public void testUserCreation(){
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();
        assertNotNull(u1);
    }

    @Test
    public void testUserSingletonWithMultipleInstantiations(){
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();
        System.setIn(System.in);
        assertNotNull(u1);

        User u2 = User.getInstance();
        assertNotNull(u2);
        assertEquals(u1, u2);
    }

    @Test
    public void testUserCommandTruckUnlock(){
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(truckFactory.getVehicle("Monster"));
        vehiclesInGarage.add(truckFactory.getVehicle("Delivery"));

        Command unlockCommand = new UnlockCommand(u1, vehiclesInGarage);
        u1.setCommand(unlockCommand);
        unlockCommand.execute();
        String result = "Tav unlocking Monster M00001. Monster M00001 unlocked." + System.lineSeparator()+ "Tav unlocking Delivery D00000. Delivery D00000 unlocked.";
        assertEquals(result, outContent.toString().trim());
    }


    @Test
    public void testUserCommandConvertibleWashDecorator(){
        //testing wash decorator for convertible
        String input = "Tav";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Vehicle c2 = carFactory.getVehicle("Convertible");
        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(c2);

        Command washCommand = new WashCommand(u1, vehiclesInGarage);
        u1.setCommand(washCommand);
        washCommand.execute();
        String out = outContent.toString().trim();

        System.setOut(System.out);

        String expectedResultSparkles = "Tav washing Convertible C00001. Convertible C00001 Soaped. Convertible C00001 Scrubbed. Convertible C00001 Rinsed. Convertible C00001 Dried. Convertible C00001 Waxed. Convertible C00001 Detailed. Convertible C00001 Detailed. Convertible C00001 sparkles.";
        String expectedResultShines = "Tav washing Convertible C00001. Convertible C00001 Soaped. Convertible C00001 Scrubbed. Convertible C00001 Rinsed. Convertible C00001 Dried. Convertible C00001 Waxed. Convertible C00001 Detailed. Convertible C00001 Detailed. Convertible C00001 shines.";
        assertEquals(expectedResultShines, out);
        assertTrue(out.equals(expectedResultSparkles) || out.equals(expectedResultShines));
    }

    @Test
    public void testUserCommandMonsterWashDecorator(){
        //testing wash decorator for monster
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(truckFactory.getVehicle("Monster"));

        Command washCommand = new WashCommand(u1, vehiclesInGarage);
        u1.setCommand(washCommand);
        washCommand.execute();
        String out = outContent.toString().trim();

        System.out.println(out);
        String expectedResult = "Tav washing Monster M00002. Monster M00002 Soaped. Monster M00002 Scrubbed. Monster M00002 Rinsed. Monster M00002 Dried. Monster M00002 Waxed. Monster M00002 Waxed. Monster M00002 Polished. Monster M00002 Detailed. Monster M00002 sparkles.";
        String expectedResultShines = "Tav washing Monster M00002. Monster M00002 Soaped. Monster M00002 Scrubbed. Monster M00002 Rinsed. Monster M00002 Dried. Monster M00002 Waxed. Monster M00002 Waxed. Monster M00002 Polished. Monster M00002 Detailed. Monster M00002 shines.";

        assertTrue(out.equals(expectedResult) || out.equals(expectedResultShines));
    }

    @Test
    public void testUserCommandLockMotorCycle(){

        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Bike"));

        Command lockCommand = new LockCommand(u1, vehiclesInGarage);
        u1.setCommand(lockCommand);
        lockCommand.execute();
        String out = outContent.toString().trim();
        String expectedResult= "Tav locking up Bike B00000. Bike B00000 locked.";

        assertEquals(expectedResult,outContent.toString().trim());

    }
}


