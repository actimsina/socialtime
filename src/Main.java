import model.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by achyut on 03/04/17.
 */
public class Main {
    public static void main(String[] args) {

        // Create a user
        User u = new User();
        u.setId(1);
        u.setName("Ram");

        // Create some TimeSlot objects using TimeSlotFactory
        // Look at the TimeSlot factory to find how I have used simple factory to create flyweight objects
        TimeSlot t1 = TimeSlotFactory.getTimeSlot(1, 1);
        TimeSlot t2 = TimeSlotFactory.getTimeSlot(1, 4);
        TimeSlot t3 = TimeSlotFactory.getTimeSlot(1, 7);

        // Set created TimeSlots to the user u
        u.getAvailableTS().add(t1);
        u.getAvailableTS().add(t2);
        u.getAvailableTS().add(t3);

        // Create a new user
        User u1 = new User();
        u1.setId(2);
        u1.setName("Shyam");

        // Set some more TimeSlot objects to User u1
        u1.getAvailableTS().add(TimeSlotFactory.getTimeSlot(1, 4));
        u1.getAvailableTS().add(TimeSlotFactory.getTimeSlot(1, 7));
        u1.getAvailableTS().add(TimeSlotFactory.getTimeSlot(1, 5));

        // Create a new Event
        Event e = new Event();
        e.setId(1);
        e.setName("Bday");

        // Set invitees for the event
        e.getInvitees().add(u1);

        // Set inviter for the event
        e.setInviter(u);

        // Send notification or invitation to the invitees
        e.sendNotification();
    }
}
