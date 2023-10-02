package classes;
import java.util.Objects;
import java.util.Scanner;
/**
 Represents the event organizer with the event calendar object
 @author Pranav Gummaluri, Yasasvi Tallapaneni
 */
public class EventOrganizer {
    private EventCalendar eventCalendar;
    private Scanner scanner;
    /**
     * Creates the event organizer object and starts scanning the input
     */
    public static void main(String[] args) {
        EventOrganizer organizer = new EventOrganizer();
        organizer.run();
    }
    /**
     * Constructs the event organizer object
     */
    public EventOrganizer() {
        this.eventCalendar = new EventCalendar();
        System.out.println("Event Organizer running....");
    }
    /**
     * Starts scanning for input
     */
    public void run() {
        scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && !processCommand(input)) {
                System.out.println("Event Organizer terminated");
                break;
            }

        }
        scanner.close();
    }
    /**
     * Processes the command that we received
     * @param String representing the command line
     * @return false if commmand Q is entered, true otherwise
     */
    private boolean processCommand(String input) {
//        System.out.println("Received input: " + input);
        String[] preProcessedTokens = input.split(" ");
        String [] tokens = new String[7];
        int index = 0;
        for (int i = 0; i < preProcessedTokens.length; i++) {
            if (!preProcessedTokens[i].isEmpty()) {
                tokens[index++] = preProcessedTokens[i];
            }
        }
//        if (tokens.length != 7) {
//            System.out.println("Invalid number of data tokens");
//            return true;
//        }
        String command = tokens[0];
//        System.out.println("Command: " + command);
        switch (command) {
            case "A":
                Date date = new Date(tokens[1]);
                if (!date.isValid()) {
                    System.out.println(tokens[1] + ": Invalid calendar date!");
                    break;
                }
                if (date.isPast()) {
                    System.out.println(tokens[1] + ": Event date must be a future date!");
                    break;
                }
                if (!date.isWithinSixMonths()) {
                    System.out.println(tokens[1] + ": Event date must be within 6 months!");
                    break;
                }
                if (!Timeslot.isValid(tokens[2])) {
                    System.out.println("Invalid time slot!");
                    break;
                }
                Timeslot timeslot = Timeslot.valueOf(tokens[2]);
                if (!Location.isValid(tokens[3])) {
                    System.out.println("Invalid location!");
                    break;
                }
                Location location = Location.valueOf(tokens[3]);
                if (!Department.isValid(tokens[4])) {
                    System.out.println("Invalid contact information!");
                    break;
                }
                Department department = Department.valueOf(tokens[4]);
                String email = tokens[5];
                Contact contact = new Contact(department, email);
                if (!contact.isValid()) {
                    System.out.println("Invalid contact information!");
                    break;
                }
                int duration = Integer.parseInt(tokens[6]);
                if (duration < 30 || duration > 120) {
                    System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
                    break;
                }
                Event event = new Event(date, timeslot, location, contact, duration);

                boolean added = eventCalendar.add(event);
                if (added) {
                    System.out.println("Event added to the calendar.");
                } else {
                    System.out.println("The event is already on the calendar.");
                }
                break;
            case "R":
                Date date1 = new Date(tokens[1]);
                if (!date1.isValid()) {
                    System.out.println(tokens[1] + ": Invalid calendar date!");
                    break;
                }
                if (date1.isPast()) {
                    System.out.println(tokens[1] + ": Event date must be a future date!");
                    break;
                }
                if (!date1.isWithinSixMonths()) {
                    System.out.println(tokens[1] + ": Event date must be within 6 months!");
                    break;
                }
                if (!Timeslot.isValid(tokens[2])) {
                    System.out.println("Invalid time slot!");
                    break;
                }
                Timeslot timeslot1 = Timeslot.valueOf(tokens[2]);
                if (!Location.isValid(tokens[3])) {
                    System.out.println("Invalid location!");
                    break;
                }
                Location location1 = Location.valueOf(tokens[3]);
                Event eventToRemove = new Event(date1, timeslot1, location1, null, 0);
                boolean removed = eventCalendar.remove(eventToRemove);
                if (removed) {
                    System.out.println("Event has been removed from the calendar!");
                } else {
                    System.out.println("Cannot remove; event is not in the calendar!");
                }
                break;
            case "P":
                if (eventCalendar.length() == 0) {
                    System.out.println("Event calendar is empty!");
                }
                else { eventCalendar.print(); }
                break;
            case "PE":
                if (eventCalendar.length() == 0) { System.out.println("Event calendar is empty!");}
                else { eventCalendar.printByDateAndTime(); }
                break;
            case "PC":
                if (eventCalendar.length() == 0) { System.out.println("Event calendar is empty!");}
                else { eventCalendar.printByCampusAndBuilding(); }
                break;
            case "PD":
                if (eventCalendar.length() == 0) { System.out.println("Event calendar is empty!");}
                else { eventCalendar.printByDepartment(); }
                break;
            case "Q":
                return false;
            default:
                System.out.println(command + " is an invalid command!");
        }

        return true;
    }


}
