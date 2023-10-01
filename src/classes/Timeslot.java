package classes;

public enum Timeslot {
    MORNING(10, 30),
    AFTERNOON(14, 0),
    EVENING(18, 30);

    private final int hour;
    private final int minute;

    private Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean equals(Timeslot otherTimeslot) {
        return this == otherTimeslot;
    }
}