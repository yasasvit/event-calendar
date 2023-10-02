package classes;

/**
This class contains the information for the 5 departments
@author Pranav Gummaluri, Yasasvi Tallapaneni
*/

public enum Department {
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics"),
    BAIT("Business Analytics and Information Technology");

    private final String departmentName;

    private Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getName() {
        return departmentName;
    }

}
