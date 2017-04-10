package model;

import controller.EventController;

import java.util.ArrayList;

/**
 * Created by achyut on 03/04/17.
 * I have used Observer pattern in between Event and Invitees
 * All user objects can be the observers for the event object
 * Event object is the subject or the publisher for the user objects
 */


public class User implements EventObserver{
    private int id;
    private String name;

    private ArrayList<TimeSlot> availableTS;
    private ArrayList<TimeSlot> unavailableTS;

    public User() {
        this.availableTS = new ArrayList<>();
        this.unavailableTS = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TimeSlot> getAvailableTS() {
        return availableTS;
    }

    public void setAvailableTS(ArrayList<TimeSlot> availableTS) {
        this.availableTS = availableTS;
    }

    public ArrayList<TimeSlot> getUnavailableTS() {
        return unavailableTS;
    }

    public void setUnavailableTS(ArrayList<TimeSlot> unavailableTS) {
        this.unavailableTS = unavailableTS;
    }

    @Override
    public void showNotification(Event event) {
        System.out.println("Do you want to attend "+event.getName()+" event " +
                "created by "+event.getInviter().getName()+" ?");
        if (true){
            event.setNumberOfAcceptedInvitees(event.getNumberOfAcceptedInvitees() + 1);
            if (event.getNumberOfAcceptedInvitees() >= event.getMinAttendees()) {
                System.out.println("Calculating candidate time slots");
                new EventController().calculateCandidateTimeSlot(event);
            }
        }
    }

    @Override
    public void showCandidateTimeSlots(Event event) {
        System.out.println("Event: " + event.getName());
        System.out.println("Please pick your preferred time slot ");
        for (CandidateTimeSlot cts: event.getCandidateTimeSlots()) {
            System.out.println(cts.getTimeSlot().toString()+ " : "+cts.getVote());
        }
    }
}
