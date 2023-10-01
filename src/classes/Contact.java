package classes;

public class Contact {
    private Department department;
    private String email;

    // Constructor
    // Constants for valid department names and email regex pattern
    private static final String[] VALID_DEPARTMENTS = {"Computer Science", "Mathematics", "Physics"};
    private static final String EMAIL_REGEX_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

    // Constructor
    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    // Getter methods (assuming you have getters for department and email)

    // Method to check if the department name is valid
    private boolean isDepartmentValid() {
        for (String validDepartment : VALID_DEPARTMENTS) {
            if (validDepartment.equals(department.getName())) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the email is valid
    private boolean isEmailValid() {
        return email.matches(EMAIL_REGEX_PATTERN);
    }

    // isValid method to check if both department and email are valid
    public boolean isValid() {
        return isDepartmentValid() && isEmailValid();
    }
}
