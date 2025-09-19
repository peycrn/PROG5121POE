import java.util.Scanner;

public class Login {

    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        boolean longEnough = password.length() >= 8;
        return hasUpper && hasDigit && hasSpecial && longEnough;
    }

    // Method to check SA cell phone number format (with international code)
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Regex: +<country code><7–12 digits>
        String regex = "^\\+[0-9]{1,3}[0-9]{7,12}$";
        return cellNumber.matches(regex);
    }

    // Register user
    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        } else {
            this.userna

//REFERENCES

//JUnit 5, 2025. JUnit 5 User Guide. Available at: https://junit.org/junit5/docs/current/user-guide/
// (Accessed: 16 September 2025).

//Oracle, 2025. Java Platform, Standard Edition 21 API Specification. Available at: https://docs.oracle.com/en/java/javase/21/docs/api/
// (Accessed: 16 September 2025).

//OWASP Foundation, 2023. Authentication Cheat Sheet. Available at: https://cheatsheetseries.owasp.org/cheatsheets/Authentication_Cheat_Sheet.html
// (Accessed: 16 September 2025).

//Regular-Expressions.info, 2025. Regular Expressions Tutorial. Available at: https://www.regular-expressions.info/
// (Accessed: 16 September 2025).