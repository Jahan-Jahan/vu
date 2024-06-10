import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee extends User {

    String empId = "";

    public Employee(String username, String firstName, String lastName, String email, String id, String phoneNumber, String password) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setId(id);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public Employee(){

    }

    public boolean isValidId() {
        if (empId.equals("")) return false;
        return true;
    }

    @Override
    public void setId(String id) {
        Pattern pattern = Pattern.compile("[0-9]{4}");
        Matcher matcher = pattern.matcher(id);
        if (matcher.find()) {
            this.empId = id;
        }
    }

    public String getEmpId() {
        return empId;
    }
}
