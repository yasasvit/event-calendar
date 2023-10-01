package classes;

public class EventCalendar {
    private Event [] events; // this holds the list of all events
    private int numEvents; // shows the current number of events in the array
    private static final int initialSize = 4;
    private static final int multiplier = 4;
    private static final int notFound = -1;

    public EventCalendar() {
        events = new Event[initialSize];
        numEvents = 0;
    }
    private int find(Event event) { // search for events in the list
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event)) {
                return i;
            }
        }
        return notFound;
    }

    private void grow() { // this will increase the capacity of the array by 4
        Event[] newEvent = new Event[events.length + 4];
        System.arraycopy(events, 0, newEvent, 0, numEvents);
        events = newEvent;
    }

    public boolean add(Event event) {
        if (numEvents == events.length) {
            grow();
        }
        events[numEvents++] = event;
        return true;
    }

    public boolean remove(Event event) {
        int index = find(event);
        if (index != notFound) {
            for (int i = index; i < numEvents - 1; i++) {
                events[i] = events[i + 1];
            }
            events[numEvents - 1] = null;
            numEvents--;
            return true;
        }
        return false;
    }

    public boolean contains(Event event) {
        return find(event) != notFound;
    }

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
