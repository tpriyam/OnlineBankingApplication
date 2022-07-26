import java.util.List;

public class UnlockCommand implements Command{
    // Command Pattern implementation
    private Mechanic mechanic;
    private List<Vehicle> vehicleList;

    public UnlockCommand(Mechanic mechanic, List<Vehicle> vehicleList) {
        this.mechanic = mechanic;
        this.vehicleList = vehicleList;
    }

    @Override
    public void execute() {
        for(Vehicle v: this.vehicleList) {
            mechanic.unlock(v);
            System.out.println(v.getClassName() + " " + v.getLicensePlate() + " " + v.unlocked() + ".");
        }

    }

    @Override
    public void undo() {
        return;
    }
}
