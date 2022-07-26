import java.util.List;

public class TuneUpCommand implements Command{
    // Command Pattern implementation
    private Mechanic mechanic;
    private List<Vehicle> vehicleList;

    public TuneUpCommand(Mechanic mechanic, List<Vehicle> vehicleList) {
        this.mechanic = mechanic;
        this.vehicleList = vehicleList;
    }

    @Override
    public void execute() {
        for(Vehicle v: this.vehicleList) {
            mechanic.tuneUp(v);
            System.out.println(v.getClassName() + " " + v.getLicensePlate() + " " + v.runs() + ".");
        }

    }

    @Override
    public void undo() {
        return;
    }
}
