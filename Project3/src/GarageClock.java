import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static java.lang.Thread.sleep;

public class GarageClock implements Runnable{
    // GarageClock is an observable for GarageAnnouncer and Mechanic
    // https://docs.oracle.com/javase/tutorial/uiswing/events/propertychangelistener.html
    // https://www.baeldung.com/java-observer-pattern
    private Integer time;
    private PropertyChangeSupport support;

    GarageClock() {
        this.support = new PropertyChangeSupport(this);
    }

    public void run() {
        for (int counter = 8; counter <= 20; counter++) {
            try {
                sleep((int) (1000));
                this.setTime(counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.support.firePropertyChange("time", this.time, time);
        this.time = time;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        this.support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        this.support.removePropertyChangeListener(pcl);
    }
}
