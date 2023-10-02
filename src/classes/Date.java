package classes;
import java.util.Calendar;

/**
This class contains the date information such as the date and time
It also checks for a real date (Feb 30 isn't real) and checks for leap day (Feb 29)
@author Pranav Gummaluri, Yasasvi Tallapaneni
*/

// DATE WORKS
public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;
    public static final int QUADYEAR = 4;
    public static final int CENTURY = 100;
    public static final int QUADCENTURY = 400;

    // Date constructor takes string in the form "mm/dd/yyyy"
    public Date(String date) {
        String[] tokens = date.split("/");
        this.month = Integer.parseInt(tokens[0]);
        this.day = Integer.parseInt(tokens[1]);
        this.year = Integer.parseInt(tokens[2]);
    }
    // Default constuctor that creates date with today's date
    public Date() {
        Calendar calendar = Calendar.getInstance();
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.year = calendar.get(Calendar.YEAR);
    }
    // A copy constructor that clones another Date object
    public Date(Date d) {
        this.year = d.year;
        this.month = d.month;
        this.day = d.day;
    }
    // Getter methods
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay(){
        return day;
    }
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Date date = (Date) obj;

        if (this.year != date.year) {return false; }
        if (this.month != date.month) {return false; }
        if (this.day != date.day) {return false; }
        return true;
    }
    // return today's date
    public static Date today() {
        return new Date();
    }

    // Check if date object is valid calendar date
    public boolean isValid() {
        if (month <= 0 || month > 12 || day <= 0 || day > 31 || year <= 0 || year > 2023) {
            return false;
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[2] = 29; // When it's a leap year, Feb has 29 days
        }
        return day <= daysInMonth[month];
    }

    private boolean isLeapYear(int year) {
        if (year % QUADYEAR == 0) {
            if (year % CENTURY == 0) {
                return year % QUADCENTURY == 0;
            }
            return true;
        }
        return false;
    }

    // Return textual representation of date object
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public static void main(String[] args) {
        testDaysInFeb_Nonleap();
        testDaysInFeb_Leap();
        testMonth_OutOfRange();
    }
    // testcase 1
    private static void testDaysInFeb_Nonleap() {
        Date date = new Date("2/29/2011");
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        testResult(date, expectedOutput, actualOutput);
    }

    private static void testDaysInFeb_Leap() {
        Date date = new Date("2/29/2020");
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        testResult(date, expectedOutput, actualOutput);
    }

    private static void testMonth_OutOfRange() {
        Date date = new Date("12/32/2022");
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        testResult(date, expectedOutput, actualOutput);
    }

    private static void testResult(Date date, boolean expected, boolean actual) {
        System.out.println("Date: " + date.toString());
//        System.out.println(expected + " " + actual);
        System.out.println("Result: " + (expected == actual ? "Passed" : "Failed"));
    }
}
