import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class EmployeeHome extends JFrame implements ActionListener, MouseListener {
    
    private ImageIcon background = new ImageIcon("background.jpg");

    private JLabel mainLabel = new JLabel();
    private JLabel newsLabel = new JLabel();
    private JLabel homeWorkLabel = new JLabel();
    private JLabel quizLabel = new JLabel();
    private JLabel usernameLabel;

    private JButton changeRole = new JButton("Change!");

    private Font font2 = new Font("MV Boli", Font.BOLD, 25);
    private Color foreColor = new Color(80, 80, 80);

    private Random random = new Random();
    
    public EmployeeHome(Employee e) {

        newsLabel.setBounds(25, 150, 300, 600);
        newsLabel.setBackground(Color.pink);
        newsLabel.setOpaque(true);
        newsLabel.addMouseListener(this);
        
        homeWorkLabel.setBounds(375, 50, 800, 700);
        homeWorkLabel.setBackground(Color.pink);
        homeWorkLabel.setOpaque(true);
        homeWorkLabel.addMouseListener(this);

        quizLabel.setBounds(1225, 150, 300, 600);
        quizLabel.setBackground(Color.pink);
        quizLabel.setOpaque(true);
        quizLabel.addMouseListener(this);

        usernameLabel = new JLabel(e.getUsername(), SwingConstants.CENTER);
        usernameLabel.setFont(font2);
        usernameLabel.setForeground(foreColor);
        usernameLabel.setBounds(1225, 25, 300, 75);
        usernameLabel.setOpaque(false);
        usernameLabel.addMouseListener(this);
        
        changeRole.setBounds(25, 25, 300, 75);
        changeRole.setFont(font2);
        changeRole.setBackground(new Color(80, 200, 120));
        changeRole.setFocusable(false);
        changeRole.addActionListener(this);

        mainLabel.setBounds(0, 0, 1980, 900);
        mainLabel.setIcon(background);
        mainLabel.add(newsLabel);
        mainLabel.add(homeWorkLabel);
        mainLabel.add(quizLabel);
        mainLabel.add(usernameLabel);
        mainLabel.add(changeRole);

        setTitle("Employee");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1980, 900);
        add(mainLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeRole) {
            new Login();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == newsLabel) {
            newsLabel.setBorder(BorderFactory.createLineBorder(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 3));

        }
        if (e.getSource() == homeWorkLabel) {
            homeWorkLabel.setBorder(BorderFactory.createLineBorder(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 3));

        }
        if (e.getSource() == quizLabel) {
            quizLabel.setBorder(BorderFactory.createLineBorder(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 3));

        }
        if (e.getSource() == usernameLabel) {
            usernameLabel.setBorder(BorderFactory.createLineBorder(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 2));

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == newsLabel) {
            newsLabel.setBorder(null);

        }
        if (e.getSource() == homeWorkLabel) {
            homeWorkLabel.setBorder(null);

        }
        if (e.getSource() == quizLabel) {
            quizLabel.setBorder(null);

        }
        if (e.getSource() == usernameLabel) {
            usernameLabel.setBorder(null);

        }
    }
}
