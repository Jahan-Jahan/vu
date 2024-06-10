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
    private Font font3 = new Font("MV Boli", Font.BOLD, 20);
    private Color backColor = new Color(80, 80, 80);
    private Color foreColor = new Color(220, 220, 220);

    private JLabel invalidUsername = new JLabel("Invalid!");
    private JLabel invalidFirstName = new JLabel("Invalid!");
    private JLabel invalidLastName = new JLabel("Invalid!");
    private JLabel invalidEmail = new JLabel("Invalid!");
    private JLabel invalidId = new JLabel("Invalid!");
    private JLabel invalidPhone = new JLabel("Invalid!");
    private JLabel invalidPassword = new JLabel("Invalid!");
    private Color invalidColor = new Color(150, 0, 0);

    public SignUp() {

        username.setBounds(400, 150, 350, 60);
        username.setFont(font);
        username.setBackground(backColor);
        username.setForeground(foreColor);
        usernameLabel.setBounds(250, 150, 150, 60);
        usernameLabel.setFont(font);
        usernameLabel.setForeground(Color.white);
        invalidUsername.setBounds(775, 150, 75, 60);
        invalidUsername.setFont(font3);
        invalidUsername.setForeground(invalidColor);
        invalidUsername.setVisible(false);
        
        firstName.setBounds(400, 230, 350, 60);
        firstName.setFont(font);
        firstName.setBackground(backColor);
        firstName.setForeground(foreColor);
        firstLabel.setBounds(250, 230, 150, 60);
        firstLabel.setFont(font);
        firstLabel.setForeground(Color.white);
        invalidFirstName.setBounds(775, 230, 75, 60);
        invalidFirstName.setFont(font3);
        invalidFirstName.setForeground(invalidColor);
        invalidFirstName.setVisible(false);
        
        lastName.setBounds(400, 310, 350, 60);
        lastName.setFont(font);
        lastName.setBackground(backColor);
        lastName.setForeground(foreColor);
        lastLabel.setBounds(250, 310, 150, 60);
        lastLabel.setFont(font);
        lastLabel.setForeground(Color.white);
        invalidLastName.setBounds(775, 310, 75, 60);
        invalidLastName.setFont(font3);
        invalidLastName.setForeground(invalidColor);
        invalidLastName.setVisible(false);
        
        email.setBounds(400, 390, 350, 60);
        email.setFont(font);
        email.setBackground(backColor);
        email.setForeground(foreColor);
        emailLabel.setBounds(250, 390, 150, 60);
        emailLabel.setFont(font);
        emailLabel.setForeground(Color.white);
        invalidEmail.setBounds(775, 390, 75, 60);
        invalidEmail.setFont(font3);
        invalidEmail.setForeground(invalidColor);
        invalidEmail.setVisible(false);
        
        id.setBounds(400, 470, 350, 60);
        id.setFont(font);
        id.setBackground(backColor);
        id.setForeground(foreColor);
        idLabel.setBounds(250, 470, 150, 60);
        idLabel.setFont(font);
        idLabel.setForeground(Color.white);
        invalidId.setBounds(775, 470, 75, 60);
        invalidId.setFont(font3);
        invalidId.setForeground(invalidColor);
        invalidId.setVisible(false);

        phoneNumber.setBounds(400, 550, 350, 60);
        phoneNumber.setFont(font);
        phoneNumber.setBackground(backColor);
        phoneNumber.setForeground(foreColor);
        phoneLabel.setBounds(250, 550, 150, 60);
        phoneLabel.setFont(font);
        phoneLabel.setForeground(Color.white);
        invalidPhone.setBounds(775, 550, 75, 60);
        invalidPhone.setFont(font3);
        invalidPhone.setForeground(invalidColor);
        invalidPhone.setVisible(false);

        password.setBounds(400, 630, 350, 60);
        password.setFont(font);
        password.setBackground(backColor);
        password.setForeground(foreColor);
        passLabel.setBounds(250, 630, 150, 60);
        passLabel.setFont(font);
        passLabel.setForeground(Color.white);
        invalidPassword.setBounds(775, 630, 75, 60);
        invalidPassword.setFont(font3);
        invalidPassword.setForeground(invalidColor);
        invalidPassword.setVisible(false);

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
        mainLabel.add(invalidUsername);
        mainLabel.add(invalidFirstName);
        mainLabel.add(invalidLastName);
        mainLabel.add(invalidEmail);
        mainLabel.add(invalidId);
        mainLabel.add(invalidPhone);
        mainLabel.add(invalidPassword);

        setTitle("Sign Up");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

                if (st.isValidUsername() && st.isValidFirstName() && st.isValidLastName() && st.isValidEmail() && st.isValidId() && st.isValidPhone() && st.isValidPassword()) {
                    try (FileWriter fw = new FileWriter("users.csv", true);
                    PrintWriter pw = new PrintWriter(fw)) {

                        pw.println(un + "," + first + "," + last + "," + mail + "," + ID + "," + phoneNum + "," + pass + ",std");
                        JOptionPane.showMessageDialog(this, "Student user signed up successfully!");

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error saving user details.");
                    }

                    try (FileWriter fw = new FileWriter("teachersOf" + st.getUsername() + ".csv");
                    PrintWriter pw = new PrintWriter(fw)) {

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    dispose();
                    new StudentHome(st);
                } else {
                    if (!st.isValidUsername()) invalidUsername.setVisible(true);
                    if (!st.isValidFirstName()) invalidFirstName.setVisible(true);
                    if (!st.isValidLastName()) invalidLastName.setVisible(true);
                    if (!st.isValidEmail()) invalidEmail.setVisible(true);
                    if (!st.isValidId()) invalidId.setVisible(true);
                    if (!st.isValidPhone()) invalidPhone.setVisible(true);
                    if (!st.isValidPassword()) invalidPassword.setVisible(true);
                    mainLabel.revalidate();
                    revalidate();
                    JOptionPane.showMessageDialog(null, "Please enter the valid information", "Validation", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (r2.isSelected()) {
                Teacher tc = new Teacher(un, first, last, mail, ID, phoneNum, pass);
                // Add student to our users

                if (tc.isValidUsername() && tc.isValidFirstName() && tc.isValidLastName() && tc.isValidEmail() && tc.isValidId() && tc.isValidPhone() && tc.isValidPassword()) {
                    try (FileWriter fw = new FileWriter("users.csv", true);
                    PrintWriter pw = new PrintWriter(fw)) {

                        pw.println(un + "," + first + "," + last + "," + mail + "," + ID + "," + phoneNum + "," + pass + ",tc");
                        JOptionPane.showMessageDialog(this, "Teacher user signed up successfully!");
                    
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error saving user details.");
                    }

                    try (FileWriter fw = new FileWriter("news.csv");
                    PrintWriter pw = new PrintWriter(fw)) {

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    
                    try (FileWriter fw = new FileWriter("homework.csv");
                    PrintWriter pw = new PrintWriter(fw)) {

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try (FileWriter fw = new FileWriter("studentsOf" + tc.getUsername() + ".csv");
                    PrintWriter pw = new PrintWriter(fw)) {

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try (FileWriter fw = new FileWriter("Descriptive" + tc.getUsername() + ".csv");
                    PrintWriter pw = new PrintWriter(fw)) {

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try (FileWriter fw = new FileWriter("Choice" + tc.getUsername() + ".csv");
                    PrintWriter pw = new PrintWriter(fw)) {

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try (FileWriter fw = new FileWriter("TF" + tc.getUsername() + ".csv");
                    PrintWriter pw = new PrintWriter(fw)) {

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    dispose();
                    new TeacherHome(tc);
                } else {
                    // System.out.println("Username: " + tc.isValidUsername() + "\nFirst: " + tc.isValidFirstName() + "\nLast: " + tc.isValidLastName() + "\nEmail: " + tc.isValidEmail() + "\nID: " + tc.isValidId() + "\nPhone: " + tc.isValidPhone() + "\nPassword: " + tc.isValidPassword());
                    if (!tc.isValidUsername()) invalidUsername.setVisible(true);
                    if (!tc.isValidFirstName()) invalidFirstName.setVisible(true);
                    if (!tc.isValidLastName()) invalidLastName.setVisible(true);
                    if (!tc.isValidEmail()) invalidEmail.setVisible(true);
                    if (!tc.isValidId()) invalidId.setVisible(true);
                    if (!tc.isValidPhone()) invalidPhone.setVisible(true);
                    if (!tc.isValidPassword()) invalidPassword.setVisible(true);
                    mainLabel.revalidate();
                    revalidate();
                    JOptionPane.showMessageDialog(null, "Please enter the valid information", "Validation", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }

            if (r3.isSelected()) {
                Employee em = new Employee(un, first, last, mail, ID, phoneNum, pass);
                // Add student to our users

                if (em.isValidUsername() && em.isValidFirstName() && em.isValidLastName() && em.isValidEmail() && em.isValidId() && em.isValidPhone() && em.isValidPassword()) {
                    
                    try (FileWriter fw = new FileWriter("users.csv", true);
                    PrintWriter pw = new PrintWriter(fw)) {

                        pw.println(un + "," + first + "," + last + "," + mail + "," + ID + "," + phoneNum + "," + pass + ",emp");
                        JOptionPane.showMessageDialog(this, "Employee user signed up successfully!");
                    
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error saving user details.");
                    }
                    dispose();
                    new EmployeeHome(em);
                } else {
                    if (!em.isValidUsername()) invalidUsername.setVisible(true);
                    if (!em.isValidFirstName()) invalidFirstName.setVisible(true);
                    if (!em.isValidLastName()) invalidLastName.setVisible(true);
                    if (!em.isValidEmail()) invalidEmail.setVisible(true);
                    if (!em.isValidId()) invalidId.setVisible(true);
                    if (!em.isValidPhone()) invalidPhone.setVisible(true);
                    if (!em.isValidPassword()) invalidPassword.setVisible(true);
                    mainLabel.revalidate();
                    revalidate();
                    JOptionPane.showMessageDialog(null, "Please enter the valid information", "Validation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

}
