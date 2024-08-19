package org.example.model;

import javax.swing.text.Position;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private Place place;
    private LocalDateTime dateTime;
    private int numberOfPlace;
    private List<Billet> billets;

    public Event(String eventName, Place place, LocalDateTime dateTime, int numberOfPlace) {
        this.eventName = eventName;
        this.place = place;
        this.dateTime = dateTime;
        this.numberOfPlace = numberOfPlace;
        billets = new ArrayList<Billet>();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    public void addBillet(Billet billet) {
        billets.add(billet);
    }

    public List<Billet> getBillets() {
        return billets;
    }
}
