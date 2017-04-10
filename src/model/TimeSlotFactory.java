package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by achyut on 04/04/17.
 * It is the simple factory for creating TimeSlot objects
 * Look how I have used Flyweight pattern to generate a fixed set of TimeSlot objects
 */
public class TimeSlotFactory {

    private static Map<String, TimeSlot> allPossibleTS = new HashMap<>();

    public static TimeSlot getTimeSlot(int day, int hour){
        String key = Integer.toString(day) + Integer.toString(hour);
        if (allPossibleTS.containsKey(key))
            return allPossibleTS.get(key);

        TimeSlot ts = new TimeSlot(day, hour);
        allPossibleTS.put(key, ts);
        return ts;
    }
}
