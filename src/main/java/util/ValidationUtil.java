package util;
import org.apache.commons.validator.routines.EmailValidator;
public class ValidationUtil {
    private ValidationUtil(){}
    public static void validateEmail(String email){
        if(email==null||email.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }
        EmailValidator validator=EmailValidator.getInstance();
        if(!validator.isValid(email)){
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!name.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name must contain only letters and spaces");
        }
    }

    public static void validateRollNo(String rollNo) {
        if (rollNo == null || rollNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Roll number cannot be empty");
        }

        if (!rollNo.matches("[0-9]{4}[a-zA-Z][0-9][a-zA-Z][0-9]{3}")) {
            throw new IllegalArgumentException("Invalid roll number format");
        }
    }

    public static void validateMarks(int marks) {
        if (marks <= 0 || marks >= 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
    }

    public static void validatePhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }

        if (!phone.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Phone number must contain exactly 10 digits");
        }
    }

    public static void validateNotEmpty(String fieldName, String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
    }
}