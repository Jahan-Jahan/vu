import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SignUp extends JFrame implements ActionListener {

    private JLabel welcome = new JLabel("Welcome To Virtual System!");
    
    private ImageIcon background = new ImageIcon("back3.png");
    private JLabel mainLabel = new JLabel();
    private JTextField username = new JTextField();
    private JLabel usernameLabel = new JLabel("Username:");
    private JTextField firstName = new JTextField();
    private JLabel firstLabel = new JLabel("First Name:");
    private JTextField lastName = new JTextField();
    private JLabel lastLabel = new JLabel("Last Name:");
    private JTextField email = new JTextField();
    private JLabel emailLabel = new JLabel("Email:");
    private JTextField id = new JTextField();
    private JLabel idLabel = new JLabel("ID:");
    private JTextField phoneNumber = new JTextField();
    private JLabel phoneLabel = new JLabel("Phone:");
    private JPasswordField password = new JPasswordField();
    private JLabel passLabel = new JLabel("Password:");

    private JRadioButton r1 = new JRadioButton("Student");
    private JRadioButton r2 = new JRadioButton("Teacher");
    private JRadioButton r3 = new JRadioButton("Employee");

    private ButtonGroup groupRadioButtons = new ButtonGroup();

    private JButton submit = new JButton("Sign Up");

    private Font font = new Font("MV Boli", Font.BOLD, 22);
    private Font font2 = new Font("MV Boli", Font.BOLD, 35);
    private Color backColor = new Color(80, 80, 80);
    private Color foreColor = new Color(220, 220, 220);

    public SignUp() {
        username.setBounds(400, 150, 350, 60);
        username.setFont(font);
        username.setBackground(backColor);
        username.setForeground(foreColor);
        usernameLabel.setBounds(250, 150, 150, 60);
        usernameLabel.setFont(font);
        usernameLabel.setForeground(Color.white);
        
        firstName.setBounds(400, 230, 350, 60);
        firstName.setFont(font);
        firstName.setBackground(backColor);
        firstName.setForeground(foreColor);
        firstLabel.setBounds(250, 230, 150, 60);
        firstLabel.setFont(font);
        firstLabel.setForeground(Color.white);
        
        lastName.setBounds(400, 310, 350, 60);
        lastName.setFont(font);
        lastName.setBackground(backColor);
        lastName.setForeground(foreColor);
        lastLabel.setBounds(250, 310, 150, 60);
        lastLabel.setFont(font);
        lastLabel.setForeground(Color.white);
        
        email.setBounds(400, 390, 350, 60);
        email.setFont(font);
        email.setBackground(backColor);
        email.setForeground(foreColor);
        emailLabel.setBounds(250, 390, 150, 60);
        emailLabel.setFont(font);
        emailLabel.setForeground(Color.white);
        
        id.setBounds(400, 470, 350, 60);
        id.setFont(font);
        id.setBackground(backColor);
        id.setForeground(foreColor);
        idLabel.setBounds(250, 470, 150, 60);
        idLabel.setFont(font);
        idLabel.setForeground(Color.white);

        phoneNumber.setBounds(400, 550, 350, 60);
        phoneNumber.setFont(font);
        phoneNumber.setBackground(backColor);
        phoneNumber.setForeground(foreColor);
        phoneLabel.setBounds(250, 550, 150, 60);
        phoneLabel.setFont(font);
        phoneLabel.setForeground(Color.white);

        password.setBounds(400, 630, 350, 60);
        password.setFont(font);
        password.setBackground(backColor);
        password.setForeground(foreColor);
        passLabel.setBounds(250, 630, 150, 60);
        passLabel.setFont(font);
        passLabel.setForeground(Color.white);

        welcome.setBounds(850, 130, 550, 100);
        welcome.setFont(font2);
        welcome.setForeground(new Color(230, 230, 230));

        groupRadioButtons.add(r1);
        groupRadioButtons.add(r2);
        groupRadioButtons.add(r3);
        r1.setBounds(1000, 280, 200, 50);
        r1.setBackground(new Color(255, 180, 193));
        r2.setBounds(1000, 330, 200, 50);
        r2.setBackground(new Color(255, 150, 193));
        r3.setBounds(1000, 380, 200, 50);
        r3.setBackground(new Color(255, 120, 193));

        submit.setBounds(975, 500, 250, 100);
        submit.setFont(font2);
        submit.setBackground(new Color(80, 200, 120));
        submit.setForeground(Color.white);
        submit.setFocusable(false);
        submit.addActionListener(this);

        mainLabel.setIcon(background);
        mainLabel.setBounds(0, 0, 1920, 900);
        mainLabel.setOpaque(true);
        mainLabel.setLayout(null);
        mainLabel.add(username);
        mainLabel.add(firstName);
        mainLabel.add(lastName);
        mainLabel.add(email);
        mainLabel.add(id);
        mainLabel.add(phoneNumber);
        mainLabel.add(password);
        mainLabel.add(usernameLabel);
        mainLabel.add(firstLabel);
        mainLabel.add(lastLabel);
        mainLabel.add(emailLabel);
        mainLabel.add(idLabel);
        mainLabel.add(phoneLabel);
        mainLabel.add(passLabel);
        mainLabel.add(r1);
        mainLabel.add(r2);
        mainLabel.add(r3);
        mainLabel.add(welcome);
        mainLabel.add(submit);

        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 900);
        add(mainLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

            String un = username.getText();
            String first = firstName.getText();
            String last = lastName.getText();
            String mail = email.getText();
            String ID = id.getText();
            String phoneNum = phoneNumber.getText();
            String pass = new String(password.getPassword());

            if (r1.isSelected()) {
                Student st = new Student(un, first, last, mail, ID, phoneNum, pass);
                // System.out.println(st.getUsername() + " " + st.getFirstName() + " " + st.getLastName() + " " + st.getEmail() + " " + st.getStdId() + " " + st.getPhoneNumber() + " " + st.getPassword() + " ");
                // Add student to our users

                try (FileWriter fw = new FileWriter("users.csv", true);
                    PrintWriter pw = new PrintWriter(fw)) {

                    pw.println(un + "," + first + "," + last + "," + mail + "," + ID + "," + phoneNum + "," + pass + ",std");
                    JOptionPane.showMessageDialog(this, "Student user signed up successfully!");

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving user details.");
                }

                if (st.isValidUsername() && st.isValidFirstName() && st.isValidLastName() && st.isValidEmail() && st.isValidId() && st.isValidPhone() && st.isValidPassword()) {
                    new StudentHome();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the valid information", "Validation", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (r2.isSelected()) {
                Teacher tc = new Teacher(un, first, last, mail, ID, phoneNum, pass);
                // Add student to our users

                try (FileWriter fw = new FileWriter("users.csv", true);
                    PrintWriter pw = new PrintWriter(fw)) {

                    pw.println(un + "," + first + "," + last + "," + mail + "," + ID + "," + phoneNum + "," + pass + ",tc");
                    JOptionPane.showMessageDialog(this, "Teacher user signed up successfully!");
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving user details.");
                }

                if (tc.isValidUsername() && tc.isValidFirstName() && tc.isValidLastName() && tc.isValidEmail() && tc.isValidId() && tc.isValidPhone() && tc.isValidPassword()) {
                    new TeacherHome();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the valid information", "Validation", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }

            if (r3.isSelected()) {
                Employee em = new Employee(un, first, last, mail, ID, phoneNum, pass);
                // Add student to our users

                try (FileWriter fw = new FileWriter("users.csv", true);
                    PrintWriter pw = new PrintWriter(fw)) {

                    pw.println(un + "," + first + "," + last + "," + mail + "," + ID + "," + phoneNum + "," + pass + ",emp");
                    JOptionPane.showMessageDialog(this, "Employee user signed up successfully!");
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving user details.");
                }

                if (em.isValidUsername() && em.isValidFirstName() && em.isValidLastName() && em.isValidEmail() && em.isValidId() && em.isValidPhone() && em.isValidPassword()) {
                    new EmployeeHome();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the valid information", "Validation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

}
