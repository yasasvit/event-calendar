package classes;

public class Date {
    private int year;
    private int month;
    private int day;
    public static final int QuadYear = 4;
    public static final int Century = 100;
    public static final int QuadCentury = 400;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isValid() {
        if (year <= 0 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[2] = 29; // When it's a leap year, Feb has 29 days
        }

        return day <= daysInMonth[month];
    }

    private boolean isLeapYear(int year) {
        if (year % QuadYear == 0) {
            if (year % Century == 0) {
                return year % QuadCentury == 0;
            }
            return true;
        }
        return false;
    }

    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }
}

