package classes;
import java.util.Scanner;
public class EventOrganizer {
    private boolean isRunning;

    public EventOrganizer() {
        System.out.println("Event Organizer running....");
        this.isRunning = true;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();

            processCommand(input);
        }

        System.out.println("Event Organizer terminated");
        scanner.close();
    }

    private void processCommand(String command) {
        if (command.equalsIgnoreCase("Q")) {
            isRunning = false;
        } else if (command.equalsIgnoreCase("Add Event:")) {
            // Handle adding an event
        } else if (command.equalsIgnoreCase("Remove Event")) {
            // Handle removing an event
        } else {
            System.out.println("Unknown command: " + command);
        }
    }
}
