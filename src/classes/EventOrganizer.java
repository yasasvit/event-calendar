package classes;
import java.util.Objects;
import java.util.Scanner;

/**
This class contains the proper user interface to enter an event into the system
It displays the information in proper syntax after entered
@author Pranav Gummaluri, Yasasvi Tallapaneni
*/

public class EventOrganizer {
    private EventCalendar eventCalendar;
    public static void main(String[] args) {
        EventOrganizer organizer = new EventOrganizer();
        organizer.run();
    }

    public EventOrganizer() {
        this.eventCalendar = new EventCalendar();
        System.out.println("Event Organizer running....");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (!processCommand(input)) {
                System.out.println("Event Organizer terminated");
                break;
            }
        }
        scanner.close();
    }

    private boolean processCommand(String input) {
        String[] tokens = input.split(" ");
//        if (tokens.length != 7) {
//            System.out.println("Invalid number of data tokens");
//            return true;
//        }
        String command = tokens[0];
        switch (command) {
            case "A":
                // Parse the command line and create an Event object
                // Call the addEvent() method to add the event to the calendar
                break;
            case "R":
                // Parse the command line and create an Event object
                // Call the removeEvent() method to remove the event from the calendar
                break;
            case "P":
            case "PE":
            case "PC":
            case "PD":
                // Call the displayEvents() method with the appropriate command
                break;
            case "Q":
                return false;
            default:
                System.out.println("Invalid command: " + command);
        }
        return true;
    }
}
