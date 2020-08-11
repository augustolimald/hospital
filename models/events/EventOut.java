package models.events;

import controllers.EventLoop;
import models.attended.Attended;

public class EventOut extends Event {
    public EventOut(long duration, int priority, Attended attended) {
        super(duration, priority, attended);
    }

    @Override
    public void run(EventLoop loop) {
        System.out.println("Finalizou atendimento de " + getAttended().getName() + " por " + getAttendant().getName());
        setCloseTime(System.currentTimeMillis());
        getAttendant().setAvailable(true);
    }
    
    @Override
    public String toString() {
        return "EventOut: " + super.toString();
    }
}
