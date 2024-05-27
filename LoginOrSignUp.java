import javax.swing.JOptionPane;

public class LoginOrSignUp {

    public LoginOrSignUp() {
        String[] options = {"Sign Up", "Log In"};

        int response = JOptionPane.showOptionDialog(null, 
                "Do you want to sign up or log in?", 
                "Select an Option", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);

        if (response == 0) {
            new SignUp();
        } else if (response == 1) {
            new Login();
        } else {
            JOptionPane.showMessageDialog(null,
                "Good luck!",
                "By By",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
