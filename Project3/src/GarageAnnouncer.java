import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GarageAnnouncer extends GarageEmployee implements PropertyChangeListener {
    // GarageAnnouncer is an observer. It is implementing the PropertyChangeListener
    // https://www.baeldung.com/java-observer-pattern
    // https://docs.oracle.com/javase/tutorial/uiswing/events/propertychangelistener.html
    private String mechanicState;
    private Integer time;

    GarageAnnouncer(String name) {
        super(name);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "time") {
            Integer time = (Integer) evt.getNewValue();
            this.setTime(time);
            System.out.println("This is GarageAnnouncer " + this.getName() +
                    ". The current time is " + time + "00.");
            if (time == 20) {
                System.out.println("This is GarageAnnouncer. Garage is closing for the day...");
            }
        } else if (evt.getPropertyName() == "state") {
            String state = (String) evt.getNewValue();
            this.setMechanicState(state);
            System.out.println("This is GarageAnnouncer " + this.getName() +
                    ". The Mechanic is about to " + state + " the vehicles.");
        } else {
            System.out.println("Unsupported property change event.");
        }
    }

    public String getMechanicState() {
        return this.mechanicState;
    }

    public void setMechanicState(String mechanicState) {
        this.mechanicState = mechanicState;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

}
