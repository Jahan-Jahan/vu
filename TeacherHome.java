import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class TeacherHome extends JFrame implements ActionListener, MouseListener {

    private ImageIcon background = new ImageIcon("background.jpg");

    private JLabel mainLabel = new JLabel();
    private JLabel newsLabel = new JLabel();
    private JLabel homeWorkLabel = new JLabel();
    private JLabel quizLabel = new JLabel();
    private JLabel usernameLabel;

    private JButton changeRole = new JButton("Change!");

    private Font font2 = new Font("MV Boli", Font.BOLD, 20);
    private Color foreColor = new Color(80, 80, 80);
    private Color greenBtnColor = new Color(80, 200, 120);

    private Random random = new Random();

    private JTextArea news = new JTextArea(10, 10);

    private JButton addStudentBtn = new JButton("Add STD");
    private JFrame addStudentToLesson = new JFrame("Add student to lesson");
    private JLabel mainLabelAdd = new JLabel();
    private JTextField studentId = new JTextField();
    private JTextField lessonToAdd = new JTextField();
    private JLabel studentLabel = new JLabel("Student:");
    private JLabel lessonLabel = new JLabel("Lesson:");
    private JButton submit = new JButton("Submit");
    
    public TeacherHome(Teacher t) {

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

        usernameLabel = new JLabel(t.getUsername(), SwingConstants.CENTER);
        usernameLabel.setFont(font2);
        usernameLabel.setForeground(foreColor);
        usernameLabel.setBounds(1225, 25, 300, 75);
        usernameLabel.setOpaque(false);
        usernameLabel.addMouseListener(this);
        
        changeRole.setBounds(25, 25, 150, 75);
        changeRole.setFont(font2);
        changeRole.setBackground(greenBtnColor);
        changeRole.setFocusable(false);
        changeRole.addActionListener(this);

        addStudentBtn.setBounds(180, 25, 150, 75);
        addStudentBtn.setFont(font2);
        addStudentBtn.setBackground(greenBtnColor);
        addStudentBtn.setFocusable(false);
        addStudentBtn.addActionListener(this);

        studentId.setBounds(150, 50, 200, 40);
        studentId.setFont(font2);
        studentLabel.setBounds(50, 50, 100, 40);
        studentLabel.setFont(font2);
        lessonToAdd.setBounds(150, 100, 200, 40);
        lessonToAdd.setFont(font2);
        lessonLabel.setBounds(50, 100, 100, 40);
        lessonLabel.setFont(font2);
        submit.setBounds(150, 150, 120, 40);
        submit.setFont(font2);
        submit.setBackground(greenBtnColor);
        submit.setFocusable(false);
        submit.addActionListener(this);

        mainLabelAdd.setBounds(0, 0, 400, 250);
        mainLabelAdd.setBackground(new Color(0, 50, 200));
        mainLabelAdd.add(studentId);
        mainLabelAdd.add(lessonToAdd);
        mainLabelAdd.add(studentLabel);
        mainLabelAdd.add(lessonLabel);
        mainLabelAdd.add(submit);

        addStudentToLesson.setSize(400, 250);
        addStudentToLesson.setLocationRelativeTo(null);
        addStudentToLesson.add(mainLabelAdd);

        mainLabel.setBounds(0, 0, 1980, 900);
        mainLabel.setIcon(background);
        mainLabel.add(newsLabel);
        mainLabel.add(homeWorkLabel);
        mainLabel.add(quizLabel);
        mainLabel.add(usernameLabel);
        mainLabel.add(changeRole);
        mainLabel.add(addStudentBtn);

        setTitle("Teacher");
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

        if (e.getSource() == addStudentBtn) {
            addStudentToLesson.setVisible(true);
        }

        if (e.getSource() == submit) {
            // Read text fields
            addStudent();
            addStudentToLesson.dispose();
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

    public void addStudent() {
        String id = studentId.getText();
        String lesson = lessonToAdd.getText();

        try (FileWriter fw = new FileWriter("students.csv", true);
            PrintWriter pw = new PrintWriter(fw)) {

            pw.println(id + "," + lesson);
            JOptionPane.showMessageDialog(this, "Student has added successfully!");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving user details.");
        }
    }

}
