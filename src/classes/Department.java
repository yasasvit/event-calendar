package classes;

/**
 Represents the department
 @author Pranav Gummaluri, Yasasvi Tallapaneni
 */
public enum Department {
    CS("CS", "Computer Science"),
    cs("CS", "Computer Science"),
    cS("CS", "Computer Science"),
    Cs("CS", "Computer Science"),


    EE("EE","Electrical Engineering"),
    ee("ee", "Electrical Engineering"),
    eE("EE", "Electrical Engineering"),
    Ee("EE", "Electrical Engineering"),

    ITI("ITI", "Information Technology and Informatics"),
    iti("iti","Information Technology and Informatics"),

    MATH("MATH", "Mathematics"),
    math("math", "Mathematics"),

    BAIT("BAIT", "Business Analytics and Information Technology"),
    bait("bait", "Business Analytics and Information Technology");

    private final String departmentName;
    private final String fullName;

    /**
     * Creates a department object with the department name along with the full name
     * @param departmentName abbreviated department name
     * @param fullName full name of the department
     */
    private Department(String departmentName, String fullName) {
        this.departmentName = departmentName;
        this.fullName = fullName;
    }
    /**
     * Returns the abbreviated department name
     * @return String representing the abbreviated department name
     */
    public String getName() {
        return departmentName;
    }
    /**
     * Returns the full department name
     * @return String representing the full department name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns whether the department is valid
     * @return true if the department is valid, false otherwise
     */
    public static boolean isValid(String departmentString) {
        for (Department department : Department.values()) {
            if (department.toString().equalsIgnoreCase(departmentString)) {
                return true;
            }
        }
        return false;
    }


}