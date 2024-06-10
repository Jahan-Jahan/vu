import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {

    protected String username = "";
    protected String firstName = "";
    protected String lastName = "";
    protected String email = "";
    protected String id = "";
    protected String phoneNumber = "";
    protected String password = "";

    public boolean isValidUsername() {
        if (username.equals("")) return false;
        return true;
    }
    public boolean isValidFirstName() {
        if (firstName.equals("")) return false;
        return true;
    }
    public boolean isValidLastName() {
        if (lastName.equals("")) return false;
        return true;
    }
    public boolean isValidEmail() {
        if (email.equals("")) return false;
        return true;
    }
    public boolean isValidPhone() {
        if (phoneNumber.equals("")) return false;
        return true;
    }
    public boolean isValidPassword() {
        if (password.equals("")) return false;
        return true;
    }

    public void setFirstName(String fn) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{1,18}");
        Matcher matcher = pattern.matcher(fn);
        if (matcher.find()) {
            this.firstName = fn;
        }
    }

    public void setUsername(String un) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{5,12}");
        Matcher matcher = pattern.matcher(un);
        if (matcher.find()) {
            this.username = un;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9.]{1,18}@[a-z.-]{1,8}.[a-z]{1,4}");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            this.email = email;
        }
    }

    public abstract void setId(String id);

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("09[0-9]{9}");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{8,12}");
        Matcher matcher = pattern.matcher(pass);
        if (matcher.find()) {
            this.password = pass;
        }
    }
}
