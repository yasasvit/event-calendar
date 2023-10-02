package classes;
/**
 Represents the event calendar with the events
 @author Pranav Gummaluri, Yasasvi Tallapaneni
 */
public class EventCalendar {
    private Event [] events;
    private int numEvents;
    private static final int initialSize = 4;
    public int length() {
        return numEvents;
    }
    /**
     * Creates an EventCalendar object
     */
    public EventCalendar() {
        events = new Event[initialSize];
        numEvents = 0;
    }
    /**
     * Finds the event in our events list
     * @param Event we are searching for
     * @return int representing the index of the event, -1 if event not in list
     */
    private int find(Event event) { // search for events in the list
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Grows the event list by four
     */
    private void grow() { // this will increase the capacity of the array by 4
        Event[] newEvent = new Event[events.length + 4];
        System.arraycopy(events, 0, newEvent, 0, numEvents);
        events = newEvent;
    }
    /**
     * Adds the event to our list
     * @param Event we are adding
     * @return true if event is added, false otherwise
     */
    public boolean add(Event event) {
        if (find(event) != -1) {
            return false; // event already exists
        }
        if (numEvents == events.length) {
            grow();
        }
        events[numEvents++] = event;
        return true;
    }
    /**
     * Removes the event to our list
     * @param Event we are removing
     * @return true if event is removed, false otherwise
     */
    public boolean remove(Event event) {
        int index = find(event);
        if (index != -1) {
            for (int i = index; i < numEvents - 1; i++) {
                events[i] = events[i + 1];
            }
            events[numEvents - 1] = null;
            numEvents--;
            return true;
        }
        return false;
    }
    /**
     * Checks if the event is in our list
     * @param Event we are searching for
     * @return true if event is in list, false otherwise
     */
    public boolean contains(Event event) {
        int result = find(event);
        return result != -1;

    }
    /**
     * Prints our event list
     */
    public void print() {
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i]);
        }
    }
    /**
     * Prints our event list sorted by date and time
     */
    public void printByDateAndTime() {
        selectionSortByDateAndTime();
        print();
    }
    /**
     * Prints our event list sorted by campus and building
     */
    public void printByCampusAndBuilding() {
        selectionSortByCampusAndBuilding();
        print();
    }
    /**
     * Prints our event list sorted by department
     */
    public void printByDepartment() {
        selectionSortByDepartment();
        print();
    }
    /**
     * Sorts our event list by date and time
     */
    private void selectionSortByDateAndTime() {
        for (int i = 0; i < numEvents - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numEvents; j++) {
                if (events[j].compareTo(events[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }
    /**
     * Sorts our event list by campus and building
     */
    private void selectionSortByCampusAndBuilding() {
        for (int i = 0; i < numEvents - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numEvents; j++) {
                if (events[j].getLocation().compareTo(events[minIndex].getLocation()) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }
    /**
     * Sorts our event list by department
     */
    private void selectionSortByDepartment() {
        for (int i = 0; i < numEvents - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numEvents; j++) {
                if (events[j].getContact().getDepartmentName().compareTo(events[minIndex].getContact().getDepartmentName()) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }
    /**
     * Swaps indices of i and j of events list
     * @param int representing first index we are swapping
     * @param int representing second index we are swapping
     */
    private void swap(int i, int j) {
        Event temp = events[i];
        events[i] = events[j];
        events[j] = temp;
    }

}
