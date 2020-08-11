package models.events;

import models.attended.Attended;
import controllers.EventLoop;

public class EventIn extends Event {
    public EventIn(long duration, int priority, Attended attended) {
        super(duration, priority, attended);
    }

    @Override
    public void run(EventLoop loop) {
        System.out.println("Atendeu: " + getAttended().getName() + " por " + getAttendant().getName());
        setCloseTime(System.currentTimeMillis());
        getAttendant().setAvailable(false);
        
        EventOut event = new EventOut(getDuration(), getPriority(), getAttended());
        event.setEntryTime(System.currentTimeMillis());
        event.setAttendant(getAttendant());
        loop.addEvent(event);
    }
    
    @Override
    public String toString() {
        return "EventIn: " + super.toString();
    }
}
