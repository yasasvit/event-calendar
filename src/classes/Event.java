package classes;
import java.util.Date;
// EVENT WORKS
public class Event implements Comparable<Event>{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact; // include department and email
    private int duration; // in minutes

    // Constructors
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    // Getter methods
    public Date getDate() {
        return date;
    }

    public Timeslot getStartTime() {
        return startTime;
    }

    public Location getLocation() {
        return location;
    }

    public Contact getContact() {
        return contact;
    }

    public int getDuration() {
        return duration;
    }
    // Methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Event event = (Event) obj;

        if (!date.equals(event.date)) return false;
        if (!startTime.equals(event.startTime)) return false;
        return location.equals(event.location);
    }

    // Hashcode method (auto-generated by IDE)
    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }

    // CompareTo method
    @Override
    public int compareTo(Event other) {
        int dateComparison = date.compareTo(other.date);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return other.startTime.compareTo(startTime);
    }

//     Need to implement toString method
    @Override
    public String toString() {
        String dateFormat = String.format("%02d/%02d/%04d", date.getMonth(), date.getDay(), date.getYear());

        int startHour = startTime.getHour();
        int startMinute = startTime.getMinute();
        int endHour = (startHour + duration / 60) % 24;
        int endMinute = (startMinute + duration % 60) % 60;

        String startTimeStr = String.format("%d:%02d%s", (startHour == 0 || startHour == 12) ? 12 : startHour % 12, startMinute, (startHour < 12) ? "am" : "pm");
        String endTimeStr = String.format("%d:%02d%s", (endHour == 0 || endHour == 12) ? 12 : endHour % 12, endMinute, (endHour < 12) ? "am" : "pm");

        String result = "[Event Date: " + dateFormat + "] [Start: " + startTimeStr + "] [End: " +
                endTimeStr + "] @" + location.toString() + " [Contact: " + contact.getDepartmentName()
                + ", " + contact.getEmail() + "]";
        return result;
    }

    public static void main(String [] args) {
        testSameEvents();
        testDiffEvents();
    }

    private static void testSameEvents() {
        Date date1 = new Date("12/20/2023");
        Timeslot startTime1 = Timeslot.AFTERNOON;
        Location location1 = Location.AB2225;
        Contact contact1 = new Contact(Department.EE, "ee@rutgers.edu");
        int duration1 = 40;

        Event event1 = new Event(date1, startTime1, location1, contact1, duration1);

        Date date2 = new Date("12/20/2023");
        Timeslot startTime2 = Timeslot.AFTERNOON;
        Location location2 = Location.AB2225;
        Contact contact2 = new Contact(Department.ITI, "iti@rutgers.edu");
        int duration2 = 80;

        Event event2 = new Event(date2, startTime2, location2, contact2, duration2);

        boolean expectedOutput = true;
        boolean actualOutput = event1.equals(event2);
        testResult(event1, event2, expectedOutput, actualOutput);
    }

    private static void testDiffEvents() {
        Date date1 = new Date("10/21/2023");
        Timeslot startTime1 = Timeslot.MORNING;
        Location location1 = Location.HLL114;
        Contact contact1 = new Contact(Department.CS, "cs@rutgers.edu");
        int duration1 = 60;

        Event event1 = new Event(date1, startTime1, location1, contact1, duration1);

        Date date2 = new Date("11/21/2023");
        Timeslot startTime2 = Timeslot.MORNING;
        Location location2 = Location.HLL114;
        Contact contact2 = new Contact(Department.BAIT, "cs@rutgers.edu");
        int duration2 = 60;

        Event event2 = new Event(date2, startTime2, location2, contact2, duration2);

        boolean expectedOutput = false;
        boolean actualOutput = event1.equals(event2);
        testResult(event1, event2, expectedOutput, actualOutput);
    }


    private static void testResult(Event event1, Event event2, boolean expected, boolean actual) {
        System.out.println("Event 1: " + event1.toString());
        System.out.println("Event 2: " + event2.toString());
//        System.out.println(expected + " " + actual);
        System.out.println("Result: " + (expected == actual ? "Passed" : "Failed"));
    }

}