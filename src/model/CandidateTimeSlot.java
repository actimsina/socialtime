package model;

/**
 * Created by achyut on 04/04/17.
 * Class for holding Candidate TimeSlots and the votes for each TimeSlot
 */
public class CandidateTimeSlot {
    private TimeSlot timeSlot;
    private int vote;

    public TimeSlot getTimeSlot(){
        return this.timeSlot;
    }

    public void setTs(TimeSlot ts) {
        this.timeSlot = ts;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
