package model;

import java.util.ArrayList;

/**
 * Created by achyut on 03/04/17.
 */
public class Event {
    private int id;
    private String name;

    private int minAttendees = 2;

    private int numberOfAcceptedInvitees = 1;

    private User inviter;
    private ArrayList<User> invitees;

    // Candidate TimeSlot objects for this event
    private ArrayList<CandidateTimeSlot> candidateTimeSlots;

    public Event() {
        this.invitees = new ArrayList<>();
        this.candidateTimeSlots = new ArrayList<>();
    }

    public int getMinAttendees() {
        return minAttendees;
    }

    public void setMinAttendees(int minAttendees) {
        this.minAttendees = minAttendees;
    }

    public int getNumberOfAcceptedInvitees() {
        return numberOfAcceptedInvitees;
    }

    public void setNumberOfAcceptedInvitees(int numberOfAcceptedInvitees) {
        this.numberOfAcceptedInvitees = numberOfAcceptedInvitees;
    }

    public ArrayList<User> getInvitees() {
        return invitees;
    }

    public User getInviter() {
        return inviter;
    }

    public void setInviter(User inviter) {
        this.inviter = inviter;
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


    public ArrayList<CandidateTimeSlot> getCandidateTimeSlots() {
        return candidateTimeSlots;
    }

    public void setCandidateTimeSlots(ArrayList<CandidateTimeSlot> candidateTimeSlots) {
        this.candidateTimeSlots = candidateTimeSlots;
    }

    public void sendNotification(){
        for (EventObserver observer: invitees) {
            observer.showNotification(this);
        }
    }

    public void sendCandidateTimeSlots(){
        for (EventObserver observer: invitees)
            observer.showCandidateTimeSlots(this);
    }

}
