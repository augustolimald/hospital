package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import models.attendant.Attendant;
import models.events.Event;

public class EventLoop implements Runnable {
    private final ArrayList<Event> events;
    private final ArrayList<Event> finishedEvents;
    private final ArrayList<Attendant> attendants;
    
    public EventLoop() {
        events = new ArrayList<>();
        finishedEvents = new ArrayList<>();
        attendants = new ArrayList<>();
    }
    
    private List<Attendant> getAvailableAttendants() {
        List<Attendant> availableDoctors = new ArrayList<>();
        
        for(Attendant attendant: attendants) {
            if (attendant.isAvailable()) {
                availableDoctors.add(attendant);
            }
        }
        
        return availableDoctors;
    }
    
    private List<Event> getAvailableEvents() {
        Collections.sort(events);
        List<Event> availableEvents = new ArrayList<>();
        
        for(Event event: events) {
            if (event.getEntryTime() == 0) {
                availableEvents.add(0, event);
            }
        }
        
        return availableEvents;
    }
    
    private void removeFinishedEvents() {
        List<Event> finished = new ArrayList<>();
        
        for(Event event: events) {
            if (event.getCloseTime() > 0) {
                finished.add(event);
            }
            
            if (event.getEntryTime() > 0 && event.getCloseTime() == 0 && event.getEntryTime() + event.getDuration() < System.currentTimeMillis()) {
                event.run(this);
                finished.add(event);
            }
        }
        
        finishedEvents.addAll(finished);
        events.removeAll(finished);
    }
    
    public void addAttendant(Attendant attendant) {
        attendants.add(attendant);
    }
    
    public void addEvent(Event event) {
        events.add(event);
    }
    
    public List<Event> getFinishedEvents() {
        return finishedEvents;
    }
    
    @Override
    public void run() {
        while (!events.isEmpty()) {
            removeFinishedEvents();
            
            // Avaliando disponibilidade de eventos
            List<Event> availableEvents = getAvailableEvents();
            if (availableEvents.isEmpty()) {
                sleep(500);
                continue;
            }

            // Avaliando disponibilidade de atendentes
            List<Attendant> availableAttendants = getAvailableAttendants();
            if (availableAttendants.isEmpty()) {
                sleep(500);
                continue;
            }
            
            // Iniciando atendimentos
            int eventIndex = 0;
            for(Attendant attendant: availableAttendants) {
                Event nextEvent = availableEvents.get(eventIndex);
                events.remove(nextEvent);
                nextEvent.setEntryTime(System.currentTimeMillis());
                nextEvent.setAttendant(attendant);
                nextEvent.run(this);
                sleep(200);
                
                eventIndex++;
                if (eventIndex == availableEvents.size()) break;
            }

            sleep(100);
        }
        
        try {
            FileManipulator.writeStats("/src/estatisticas.txt", this);
        } catch (Exception e) {}
    }
    
    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) { }
    }
}
