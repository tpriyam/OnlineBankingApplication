import java.util.List;

public class LockCommand implements Command{
    // Command Pattern implementation
    private Mechanic mechanic;
    private List<Vehicle> vehicleList;

    public LockCommand(Mechanic mechanic, List<Vehicle> vehicleList) {
        this.mechanic = mechanic;
        this.vehicleList = vehicleList;
    }

    @Override
    public void execute() {
        for(Vehicle v: this.vehicleList) {
            mechanic.lockUp(v);
            System.out.println(v.getClassName() + " " + v.getLicensePlate() + " " + v.locked() + ".");
        }

    }

    @Override
    public void undo() {
        return;
    }
}
