import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class TeacherHome extends JFrame implements ActionListener, MouseListener {

    private Teacher teacher;

    private ImageIcon background = new ImageIcon("background.jpg");

    private JLabel mainLabel = new JLabel();
    private JLabel whatIsUp = new JLabel("How is it going?");
    private JLabel newsLabel = new JLabel();
    private JLabel homeworkTextLabel = new JLabel("How much homework give I to?");
    private JLabel homeWorkLabel = new JLabel();
    private JLabel quizTextLabel = new JLabel("All quiz I created:");
    private JLabel quizLabel = new JLabel();
    private JLabel usernameLabel;

    private JButton changeRole = new JButton("Change!");

    private Font font2 = new Font("MV Boli", Font.BOLD, 25);
    private Color foreColor = new Color(80, 80, 80);
    private Color greenBtnColor = new Color(80, 200, 120);
    private Color borderColor = new Color(0, 100, 255);

    private Random random = new Random();

    private JButton addStudentBtn = new JButton("Add STD");
    private JFrame addStudentToLesson = new JFrame("Add student to lesson");
    private JLabel mainLabelAdd = new JLabel();
    private JTextField studentId = new JTextField();
    private JTextField lessonToAdd = new JTextField();
    private JLabel studentLabel = new JLabel("Student:");
    private JLabel lessonLabel = new JLabel("Lesson:");
    private JButton submit = new JButton("Submit");

    private ArrayList<String> studentsWeShowing = new ArrayList<String>();
    private int h = 0;
    
    public TeacherHome(Teacher t) {

        teacher = new Teacher(t.getUsername(), t.getFirstName(), t.getLastName(), t.getEmail(), t.getTeachId(), t.getPhoneNumber(), t.getPassword());

        whatIsUp.setBounds(70, 120, 230, 40);
        whatIsUp.setFont(font2);
        whatIsUp.setForeground(foreColor);
        whatIsUp.addMouseListener(this);

        newsLabel.setBounds(25, 180, 300, 600);
        newsLabel.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        // newsLabel.setBackground(Color.pink);
        // newsLabel.setOpaque(true);
        newsLabel.addMouseListener(this);

        homeworkTextLabel.setBounds(580, 40, 400, 40);
        homeworkTextLabel.setFont(font2);
        homeworkTextLabel.setForeground(foreColor);
        homeworkTextLabel.addMouseListener(this);
        
        homeWorkLabel.setBounds(375, 100, 800, 680);
        homeWorkLabel.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        // homeWorkLabel.setBackground(Color.pink);
        // homeWorkLabel.setOpaque(true);
        homeWorkLabel.addMouseListener(this);

        quizTextLabel.setBounds(1250, 120, 250, 40);
        quizTextLabel.setFont(font2);
        quizTextLabel.setForeground(foreColor);
        quizTextLabel.addMouseListener(this);

        quizLabel.setBounds(1225, 180, 280, 600);
        quizLabel.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        // quizLabel.setBackground(Color.pink);
        // quizLabel.setOpaque(true);
        quizLabel.addMouseListener(this);

        usernameLabel = new JLabel(t.getUsername(), SwingConstants.CENTER);
        usernameLabel.setFont(font2);
        usernameLabel.setForeground(foreColor);
        usernameLabel.setBackground(greenBtnColor);
        usernameLabel.setBounds(1225, 25, 280, 75);
        usernameLabel.setOpaque(true);
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
        
        showStudent();

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
        mainLabel.add(homeworkTextLabel);
        mainLabel.add(whatIsUp);
        mainLabel.add(quizTextLabel);
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
            showStudent();
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
        if (e.getSource() == whatIsUp) {
            whatIsUp.setForeground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        }
        if (e.getSource() == quizTextLabel) {
            quizTextLabel.setForeground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        }
        if (e.getSource() == homeworkTextLabel) {
            homeworkTextLabel.setForeground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        }
        if (e.getSource() == newsLabel) {
            newsLabel.setBorder(BorderFactory.createLineBorder(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 2));

        }
        if (e.getSource() == homeWorkLabel) {
            homeWorkLabel.setBorder(BorderFactory.createLineBorder(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 2));

        }
        if (e.getSource() == quizLabel) {
            quizLabel.setBorder(BorderFactory.createLineBorder(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 2));

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // if (e.getSource() == newsLabel) {
        //     newsLabel.setBorder(null);

        // }
        // if (e.getSource() == homeWorkLabel) {
        //     homeWorkLabel.setBorder(null);

        // }
        // if (e.getSource() == quizLabel) {
        //     quizLabel.setBorder(null);

        // }
    }

    public void addStudent() {
        String id = studentId.getText();
        String lesson = lessonToAdd.getText();

        try (FileWriter fw = new FileWriter("studentsOf" + teacher.getUsername() + ".csv", true);
            PrintWriter pw = new PrintWriter(fw)) {

            pw.println(id + "," + lesson);
            JOptionPane.showMessageDialog(this, "Student has added successfully!");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving user details.");
        }

        for (String st : studentsWeShowing) {

            String[] studentAndLesson = st.split("-");

            try (FileWriter fw = new FileWriter("teachersOf" + findUsernameById(studentAndLesson[0]) + ".csv", true);
            PrintWriter pw = new PrintWriter(fw)) {

                pw.println(teacher.getUsername() + "," + studentAndLesson[1]);
                // JOptionPane.showMessageDialog(this, "Teacher has added successfully!");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving user details.");
            }
        }
        
    }

    public void showStudent() {
        String fileName = "studentsOf" + teacher.getUsername() + ".csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                String id = details[0];
                String less = details[1];
                String username = findUsernameById(id);
                String stringToShow = username + "-" + less;
                if (studentsWeShowing.contains(id + "-" + less) == false) {
                    studentsWeShowing.add(id + "-" + less);
                    JLabel studentToShow = new JLabel(stringToShow);
                    studentToShow.setBounds(10, h + 10, 250, 25);
                    studentToShow.setForeground(foreColor);
                    studentToShow.setFont(new Font("MV Boli", Font.BOLD, 18));
                    newsLabel.add(studentToShow);
                    h += 35;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String findUsernameById(String id) {
        String username = "Unknown";

        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if ((details[4]).equals(id)) {
                    username = details[0];
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return username;
    }

}
