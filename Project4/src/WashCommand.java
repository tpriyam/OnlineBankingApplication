import java.util.List;
import java.util.Random;

public class WashCommand implements Command{
    // Command Pattern implementation
    private Mechanic mechanic;
    private List<Vehicle> vehicleList;

    public WashCommand(Mechanic mechanic, List<Vehicle> vehicleList) {
        this.mechanic = mechanic;
        this.vehicleList = vehicleList;
    }

    @Override
    public void execute() {
        for(Vehicle v: this.vehicleList) {
            mechanic.wash(v);
            System.out.print(v.shines());
            Random random = new Random();
            int randomInt = random.nextInt(100);
            if (randomInt > 30) {
                System.out.print(v.getClassName() + " " + v.getLicensePlate() + " shines. ");
            } else {
                System.out.print(v.getClassName() + " " + v.getLicensePlate() + " sparkles. ");
            }
            System.out.println();
        }
    }

    @Override
    public void undo() {
        return;
    }
}
