import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher extends User {

    String teachId = "";

    public Teacher(String username, String firstName, String lastName, String email, String id, String phoneNumber, String password) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setId(id);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public Teacher() {

    }

    public boolean isValidId() {
        if (teachId.equals("")) return false;
        return true;
    }

    @Override
    public void setId(String id) {
        Pattern pattern = Pattern.compile("[0-9]{6}");
        Matcher matcher = pattern.matcher(id);
        if (matcher.find()) {
            this.teachId = id;
        }
    }

    public String getTeachId() {
        return teachId;
    }


}
