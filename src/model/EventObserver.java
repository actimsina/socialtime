package model;

/**
 * Created by achyut on 06/04/17.
 */
public interface EventObserver {
    void showNotification(Event event);
    void showCandidateTimeSlots(Event event);
}
