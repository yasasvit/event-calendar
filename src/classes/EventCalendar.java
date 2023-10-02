package classes;

/**
This class contains the user interface for adding/removing events
It can also be used to see if a certain event is in the calender
@author Pranav Gummaluri, Yasasvi Tallapaneni
*/

public class EventCalendar {
    private Event [] events; // this holds the list of all events
    private int numEvents; // shows the current number of events in the array
    private static final int initialSize = 4;

    //constructor
    public EventCalendar() {
        events = new Event[initialSize];
        numEvents = 0;
    }

    //a method to find a certain event and displays the index of the event
    private int find(Event event) { // search for events in the list
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event)) {
                return i;
            }
        }
        return -1;
    }

    // this method will increase the capacity of the array by 4
    private void grow() { 
        Event[] newEvent = new Event[events.length + 4];
        System.arraycopy(events, 0, newEvent, 0, numEvents);
        events = newEvent;
    }

    //a method to add an event into the array
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
    
    //method to remove an event from the array if necessary
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

    //a boolean to check if a certain event exists in the array
    public boolean contains(Event event) {
        int result = find(event);
        return result != -1;

    }

    // ABOVE ALL LOOKS GOOD
    //Insertion sort method to sort through the events array
    private void insertionSort() {
        for (int i = 1; i < numEvents; i++) {
            Event keyNum = events[i];
            int j = i - 1;
            while (j >= 0 && events[j].compareTo(keyNum) > 0) {
                events[j + 1] = events[j];
                j--;
            }
            events[j + 1] = keyNum;
        }
    }

    //Print statements
    public void print() {
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i]);
        }
    }

    public void printByDate() {
        insertionSort();
        print();
    }

    public void printByCampus() {
        insertionSort();
        print();
    }

    public void printByDepartment() {
        insertionSort();
        print();
    }


}
