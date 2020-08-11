package models.events;

import models.attended.Attended;
import models.attendant.Attendant;
import controllers.EventLoop;

public abstract class Event implements Comparable<Event> {
    private long entryTime, closeTime;
    private final long duration;
    private final int priority;
    private final Attended attended;
    private Attendant attendant;
    
    protected Event(long duration, int priority, Attended attended) {
        this.duration = duration;
        this.priority = priority;
        this.attended = attended;
        this.attendant = null;
        this.entryTime = 0;
        this.closeTime = 0;
    }
    
    public long getDuration() {
        return duration;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
    
    public long getEntryTime() {
        return entryTime;
    }
    
    public void setCloseTime(long closeTime) {
        this.closeTime = closeTime;
    }
    
    public long getCloseTime() {
        return closeTime;
    }

    public Attended getAttended() {
        return attended;
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }
    
    public Attendant getAttendant() {
        return attendant;
    }
    
    public abstract void run(EventLoop loop);

    @Override
    public int compareTo(Event t) {
        if (priority > t.priority)
            return 1;
        else if (priority < t.priority)
            return -1;
        
        if (getEntryTime() > getEntryTime())
            return 1;
        else if (getEntryTime() < getEntryTime())
            return -1;
        
        return 0;
    }
    
    @Override
    public String toString() {
        return entryTime + 
                "/" + 
                closeTime + 
                "(" + 
                duration + 
                ") - Atendido:" + 
                attended + 
                " - Atendente: " 
                + attendant;
    }
}
