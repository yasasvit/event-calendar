package classes;

public class Event implements Comparable<Event>{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact; // include department and email
    private int duration; // in minutes
}
