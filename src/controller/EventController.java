package controller;


import model.CandidateTimeSlot;
import model.Event;
import model.TimeSlot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by achyut on 07/04/17.
 * This is the most important part for calculating the candidate TimeSlot objects
 */
public class EventController {

    public void calculateCandidateTimeSlot(Event event){
        // ArrayList for holding all available TimeSlot objects of
        // all invitees and inviter
        ArrayList<TimeSlot> allTS = new ArrayList<>();
        // Adding TimeSlots of inviter
        allTS.addAll(event.getInviter().getAvailableTS());
        // Adding TimeSlots of all invitees
        for (int i = 0; i< event.getInvitees().size(); i++)
            allTS.addAll(event.getInvitees().get(i).getAvailableTS());

        // Create a unique set of TimeSlot objects for finding the frequency of each TimeSlot
        Set<TimeSlot> uniqueTS = new HashSet<>(allTS);

        /**
         *
         */
        for (TimeSlot uts : uniqueTS){
            // It will find the frequency of each unique TimeSlot object in all collection of available TimeSlots
            if (Collections.frequency(allTS, uts) >= event.getMinAttendees()) {
                // If we one timeslot with frequency higher than the threshold value,
                // create a new Candidate TimeSlot object
                CandidateTimeSlot c = new CandidateTimeSlot();
                c.setTs(uts);
                c.setVote(0);
                event.getCandidateTimeSlots().add(c);
            }
        }
        // Now we have all the Candidate TimeSlots, Just send them to the invitees
        event.sendCandidateTimeSlots();

    }
}
