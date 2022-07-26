import java.util.List;

public class TestDriveCommand implements Command{
    // Command Pattern implementation
    private Mechanic mechanic;
    private List<Vehicle> vehicleList;

    public TestDriveCommand(Mechanic mechanic, List<Vehicle> vehicleList) {
        this.mechanic = mechanic;
        this.vehicleList = vehicleList;
    }

    @Override
    public void execute() {
        for(Vehicle v: this.vehicleList) {
            mechanic.testDrive(v);
            String d = v.drives();
            System.out.println(v.getClassName() + " " + v.getLicensePlate() + " " + d + ".");
            if(v.getClass().getName().equals("Monster") && d.equals("crashes")) {
                System.out.println("System exiting due to crash.");
                System.exit(0);
            }
        }

    }

    @Override
    public void undo() {
        return;
    }
}
