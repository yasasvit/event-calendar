package classes;

/**
This class contains the information for the 3 timeslots
@author Pranav Gummaluri, Yasasvi Tallapaneni
*/

public enum Timeslot {
    //timing information
    MORNING(10, 30),
    AFTERNOON(14, 0),
    EVENING(18, 30);

    //instance variables
    private final int hour;
    private final int minute;

    //constructor
    private Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    //Getters
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    //method to check if the info matches
    public boolean equals(Timeslot otherTimeslot) {
        return this == otherTimeslot;
    }
}
