package classes;

public class Contact {
    private Department department;
    private String email;

    // Constructor
    // Constants for valid department names and email regex pattern
    private static final String[] validDepartments = {"Computer Science", "Mathematics" +
            "Information Technology and Informatics", "Electrical Engineering", "Business Analytics and Information Technology"};
    private static final String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";

    // Constructor
    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    // Getter methods (assuming you have getters for department and email)

    // Method to check if the department name is valid
    private boolean isDepartmentValid() {
        for (String validDepartment : validDepartments) {
            if (validDepartment.equals(department.getName())) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the email is valid
    private boolean isEmailValid() {
        return email.matches(emailPattern);
    }

    // isValid method to check if both department and email are valid
    public boolean isValid() {
        return isDepartmentValid() && isEmailValid();
    }
}
