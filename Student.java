import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends User {

    String stdId = "";

    public Student(String username, String firstName, String lastName, String email, String id, String phoneNumber, String password) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setId(id);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public Student() {

    }
    
    public boolean isValidId() {
        if (stdId == "") return false;
        return true;
    }

    @Override
    public void setId(String id) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(id);
        if (matcher.find()) { // matcher.matches()
            this.stdId = id;
        }
    }

    public String getStdId() {
        return stdId;
    }
}
