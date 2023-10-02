package classes;
/**
  Represents a contact with a department and an email
  @author Pranav Gummaluri, Yasasvi Tallapaneni
 */
public class Contact {
    private Department department;
    private String email;

    private static final String[] validDepartments = {"CS", "MATH", "ITI", "EE", "BAIT", "cs", "math", "iti", "ee", "bait"};


    /**
     * Creates a contact with the respective department and email
     * @param department the department of the contact
     * @param email the email of the contact
     */
    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }
    /**
     * Checks if the department is valid
     * @return true if department is valid, false otherwise
     */
    private boolean isDepartmentValid() {
        for (String validDepartment : validDepartments) {
            if (validDepartment.equals(department.getName())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if the email is valid
     * @return true if email is valid, false otherwise
     */
    private boolean isEmailValid() {
        String emailPattern = "^[A-Za-z0-9+_.-]+@rutgers\\.edu$";
        return email.matches(emailPattern);
    }
    /**
     * Checks if the contact is valid
     * @return true if contact is valid, false otherwise
     */
    public boolean isValid() {
        return isDepartmentValid() && isEmailValid();
    }
    /**
     * Returns the full department name
     * @return String of the full department name
     */
    public String getDepartmentName() {

        return department.getFullName();
    }
    /**
     * Returns the email
     * @return String of the email
     */
    public String getEmail() {
        return email;
    }
}