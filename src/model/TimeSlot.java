package model;

/**
 * Created by achyut on 03/04/17.
 */
public class TimeSlot {
    final private int day;
    final private int hour;

    public TimeSlot(int day, int hour) {
        this.day = day;
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString(){
        return  Integer.toString(day) + " " +Integer.toString(hour);
    }

}
