package classes;
/**
 Represents the timeslot
 @author Pranav Gummaluri, Yasasvi Tallapaneni
 */
public enum Timeslot {
    MORNING(10, 30),
    morning(10, 30),
    AFTERNOON(14, 0),
    afternoon(14, 0),
    EVENING(18, 30),
    evening(18, 30);

    private final int hour;
    private final int minute;
    /**
     * Creates a timeslot object with the hour and minute
     * @param hour of the timeslot
     * @param minute of the timeslot
     */
    private Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    /**
     * Returns the hour
     * @return int representing the hour
     */
    public int getHour() {
        return hour;
    }
    /**
     * Returns the minute
     * @return int representing the minute
     */
    public int getMinute() {
        return minute;
    }
    /**
     * Checks if the two timeslots are equal
     * @param Timeslot representing the other timeslot
     * @return true if timeslots are same, false otherwise
     */
    public boolean equals(Timeslot otherTimeslot) {
        return this == otherTimeslot;
    }
    /**
     * Checks if the timeslot is valid
     * @param String representing the timeslot
     * @return true if timeslot is valid, false otherwise
     */
    public static boolean isValid(String timeslotString) {
        for (Timeslot timeslot : Timeslot.values()) {
            if (timeslot.toString().equals(timeslotString)) {
                return true;
            }
        }
        return false;
    }
}