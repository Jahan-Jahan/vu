import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame implements ActionListener, MouseListener {
    
    private ImageIcon background = new ImageIcon("back3.png");
    private JLabel welcome = new JLabel("Welcome dear user!");
    private JLabel mainLabel = new JLabel();
    private JTextField username = new JTextField();
    private JLabel usernameLabel = new JLabel("Username:");
    private JPasswordField password = new JPasswordField();
    private JLabel passLabel = new JLabel("Password:");
    private JLabel haveAcc = new JLabel("I don't have account!");
    
    private JRadioButton r1 = new JRadioButton("Student");
    private JRadioButton r2 = new JRadioButton("Teacher");
    private JRadioButton r3 = new JRadioButton("Employee");

    private ButtonGroup groupRadioButtons = new ButtonGroup();

    private JButton submit = new JButton("Login");

    private Color backColor = new Color(80, 80, 80);
    private Color foreColor = new Color(220, 220, 220);

    private Font font = new Font("MV Boli", Font.BOLD, 30);
    private Font font2 = new Font("MV Boli", Font.BOLD, 40);

    public Login() {

        welcome.setBounds(580, 130, 450, 100);
        welcome.setFont(new Font("MV Boli", Font.BOLD, 40));
        welcome.setForeground(foreColor);

        username.setBounds(480, 300, 350, 60);
        username.setFont(font);
        username.setBackground(backColor);
        username.setForeground(foreColor);
        usernameLabel.setBounds(300, 300, 180, 60);
        usernameLabel.setFont(font);
        usernameLabel.setForeground(foreColor);

        password.setBounds(480, 400, 350, 60);
        password.setFont(font);
        password.setBackground(backColor);
        password.setForeground(foreColor);
        passLabel.setBounds(300, 400, 180, 60);
        passLabel.setFont(font);
        passLabel.setForeground(foreColor);

        groupRadioButtons.add(r1);
        groupRadioButtons.add(r2);
        groupRadioButtons.add(r3);
        r1.setBounds(870, 305, 200, 50);
        r1.setBackground(new Color(255, 180, 193));
        r2.setBounds(870, 355, 200, 50);
        r2.setBackground(new Color(255, 150, 193));
        r3.setBounds(870, 405, 200, 50);
        r3.setBackground(new Color(255, 120, 193));

        haveAcc.setBounds(660, 500, 220, 50);
        haveAcc.setFont(new Font("MV Boli", Font.BOLD, 20));
        haveAcc.setForeground(foreColor);
        haveAcc.addMouseListener(this);

        submit.setBounds(670, 560, 200, 80);
        submit.setFont(font2);
        submit.setBackground(new Color(80, 200, 120));
        submit.setForeground(Color.white);
        submit.setFocusable(false);
        submit.addActionListener(this);
        
        mainLabel.setIcon(background);
        mainLabel.setBounds(0, 0, 1920, 900);
        mainLabel.setOpaque(true);
        mainLabel.setLayout(null);
        mainLabel.add(welcome);
        mainLabel.add(username);
        mainLabel.add(usernameLabel);
        mainLabel.add(password);
        mainLabel.add(passLabel);
        mainLabel.add(haveAcc);
        mainLabel.add(r1);
        mainLabel.add(r2);
        mainLabel.add(r3);
        mainLabel.add(submit);

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 900);
        add(mainLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

            String un = username.getText();
            String pass = new String(password.getPassword());
            String role = "std";

            if (r2.isSelected()) role = "tc";

            if (r3.isSelected()) role = "emp";

            if (checkUser(un, pass, role)) {
                // int response = JOptionPane.showMessageDialog(null, "It's good to see you, " + un, "Welcome!", JOptionPane.INFORMATION_MESSAGE);
                
                String[] options = {"Home", "Exit!"};
                int response = JOptionPane.showOptionDialog(null,
                    "It's good to see you, " + un,
                    "Welcome!",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
                
                if (response == 0) {
                    if (role == "std") new StudentHome();
                    else if (role == "tc") new TeacherHome();
                    else new EmployeeHome();
                } else {
                    JOptionPane.showMessageDialog(null,
                    "Good luck!",
                    "By By",
                    JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Username or Password is not valid!", "Validation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == haveAcc) {
            dispose();
            new SignUp();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == haveAcc) {
            haveAcc.setForeground(new Color(200, 80, 10));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == haveAcc) {
            haveAcc.setForeground(foreColor);
        }
    }

    private boolean checkUser(String user, String pass, String r) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                String storedUser = details[0];
                String storedPass = details[6];
                String storedRole = details[7];

                if (storedUser.equals(user) && storedPass.equals(pass) && storedRole.equals(r)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading user data.");
        }
        return false;
    }

}

