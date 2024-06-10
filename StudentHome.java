import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class StudentHome extends JFrame implements ActionListener, MouseListener {

    private Student student;

    private ImageIcon background = new ImageIcon("background.jpg");

    private JLabel mainLabel = new JLabel();
    private JLabel whatIsUp = new JLabel("How is it going?");
    private JLabel newsLabel = new JLabel();
    private JLabel homeworkTextLabel = new JLabel("How much homework should I do?");
    private JLabel homeWorkLabel = new JLabel();
    private JLabel quizTextLabel = new JLabel("Do I have any quiz?");
    private JLabel quizLabel = new JLabel();
    private JLabel usernameLabel;

    private JButton changeRole = new JButton("Change!");

    private Font font2 = new Font("MV Boli", Font.BOLD, 25);
    private Font font3 = new Font("MV Boli", Font.BOLD, 15);
    private Color foreColor = new Color(80, 80, 80);
    private Color greenBtnColor = new Color(80, 200, 120);
    private Color borderColor = new Color(0, 100, 255);

    private Random random = new Random();
    private int h = 60;

    private ArrayList<String> teachersWeShowing = new ArrayList<String>();

    private JFrame newsFrame = new JFrame("News");
    private JButton showNewsBtn = new JButton("See news!");
    private JTextArea showNewsTextArea = new JTextArea();
    private JScrollPane showNewsScrollPane = new JScrollPane(showNewsTextArea);
    private JButton showNewsOkBtn = new JButton("Ok!");

    private JTextArea showHomeworkTextArea = new JTextArea(10, 30);
    private JScrollPane showHomeworkScrollPane = new JScrollPane(showHomeworkTextArea);
    
    public StudentHome(Student s) {

        student = new Student(s.getUsername(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getStdId(), s.getPhoneNumber(), s.getPassword());

        showHomeworkTextArea.setLineWrap(true);
        showHomeworkTextArea.setWrapStyleWord(true);
        showHomeworkTextArea.setFont(font3);
        showHomeworkTextArea.setForeground(foreColor);
        showHomeworkTextArea.setEditable(false);

        showNewsOkBtn.setFont(font2);
        showNewsOkBtn.setBackground(greenBtnColor);
        showNewsOkBtn.setForeground(foreColor);
        showNewsOkBtn.setFocusable(false);
        showNewsOkBtn.addActionListener((ActionEvent ev) -> {
            newsFrame.dispose();
        });

        showNewsTextArea.setFont(new Font("MV Boli", Font.BOLD, 14));
        showNewsTextArea.setLineWrap(true);
        showNewsTextArea.setWrapStyleWord(true);
        showNewsTextArea.setForeground(foreColor);
        showNewsTextArea.setEditable(false);

        newsFrame.setLayout(new BorderLayout());
        newsFrame.setLocation(500, 300);
        newsFrame.setSize(400, 400);
        newsFrame.add(showNewsScrollPane, BorderLayout.CENTER);
        newsFrame.add(showNewsOkBtn, BorderLayout.SOUTH);

        showNewsBtn.setFont(font2);
        showNewsBtn.setBounds(20, 10, 260, 40);
        showNewsBtn.setBackground(greenBtnColor);
        showNewsBtn.setForeground(foreColor);
        showNewsBtn.setFocusable(false);
        showNewsBtn.addActionListener(this);

        whatIsUp.setBounds(70, 120, 230, 40);
        whatIsUp.setFont(font2);
        whatIsUp.setForeground(foreColor);
        whatIsUp.addMouseListener(this);

        newsLabel.setBounds(25, 180, 300, 600);
        newsLabel.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        // newsLabel.setBackground(Color.pink);
        // newsLabel.setOpaque(true);
        newsLabel.addMouseListener(this);
        newsLabel.add(showNewsBtn);

        homeworkTextLabel.setBounds(525, 40, 500, 40);
        homeworkTextLabel.setFont(font2);
        homeworkTextLabel.setForeground(foreColor);
        homeworkTextLabel.addMouseListener(this);
        
        homeWorkLabel.setBounds(375, 100, 800, 680);
        homeWorkLabel.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        homeWorkLabel.setLayout(new BorderLayout());
        // homeWorkLabel.setBackground(Color.pink);
        // homeWorkLabel.setOpaque(true);
        homeWorkLabel.addMouseListener(this);
        homeWorkLabel.add(showHomeworkScrollPane, BorderLayout.CENTER);

        quizTextLabel.setBounds(1250, 120, 250, 40);
        quizTextLabel.setFont(font2);
        quizTextLabel.setForeground(foreColor);
        quizTextLabel.addMouseListener(this);

        quizLabel.setBounds(1225, 180, 280, 600);
        quizLabel.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        // quizLabel.setBackground(Color.pink);
        // quizLabel.setOpaque(true);
        quizLabel.addMouseListener(this);

        usernameLabel = new JLabel(s.getUsername(), SwingConstants.CENTER);
        usernameLabel.setFont(font2);
        usernameLabel.setForeground(foreColor);
        usernameLabel.setBackground(greenBtnColor);
        usernameLabel.setBounds(1225, 25, 280, 75);
        usernameLabel.setOpaque(true);
        usernameLabel.addMouseListener(this);
        
        changeRole.setBounds(25, 25, 300, 75);
        changeRole.setFont(font2);
        changeRole.setBackground(greenBtnColor);
        changeRole.setFocusable(false);
        changeRole.addActionListener(this);

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

        showTeacher();
        updateHomework();
        updateNews();

        setTitle("Student");
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

        if (e.getSource() == showNewsBtn) {
            
            updateNews();

            newsFrame.setVisible(true);
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

    public void updateNews() {

        String fileName = "news.csv";

        File file = new File(fileName);

        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            showNewsTextArea.setText("");
            
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] details = line.split(",");

                String username = details[0];
                String text = details[1];
                String stringTime = details[2];

                boolean status = false;

                for (String teacher : teachersWeShowing) {
                    String[] teacherDetails = teacher.split("-");
                    String teacherUsername = findUsernameById(teacherDetails[0]);
                    if (teacherUsername.equals(username)) {
                        status = true;
                        break;
                    }
                }

                if (status) {
                    showNewsTextArea.setText(showNewsTextArea.getText() + username + " at " + stringTime + " said: " + text + "\n---------------\n");
                    showNewsTextArea.revalidate();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void showTeacher() {
        String fileName = "teachersOf" + student.getUsername() + ".csv";

        File file = new File(fileName);
        
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] details = line.split(",");

                String username = details[0];
                String less = details[1];
                String stringToShow = username + "-" + less;

                if (teachersWeShowing.contains(findIdByUsername(username) + "-" + less) == false) {
                    teachersWeShowing.add(findIdByUsername(username) + "-" + less);

                    JLabel teacherToShow = new JLabel(stringToShow);
                    teacherToShow.setBounds(10, h + 10, 250, 25);
                    teacherToShow.setForeground(foreColor);
                    teacherToShow.setFont(new Font("MV Boli", Font.BOLD, 18));
                    newsLabel.add(teacherToShow);
                    h += 35;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateHomework() {

        String fileName = "homework.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] details = line.split(",");

                String username = details[0];
                String text = details[1];
                String stringTime = details[2];

                boolean status = false;

                for (String teacher : teachersWeShowing) {
                    String[] teacherDetails = teacher.split("-");
                    String teacherUsername = findUsernameById(teacherDetails[0]);
                    if (teacherUsername.equals(username)) {
                        status = true;
                        break;
                    }
                }

                if (status) {
                    showHomeworkTextArea.setText(showHomeworkTextArea.getText() + username + " at " + stringTime + "\n" + text + "\n---------------\n");
                    showHomeworkTextArea.revalidate();
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

    public String findIdByUsername(String username) {
        String id = "";

        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if ((details[0]).equals(username)) {
                    id = details[4];
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return id;
    }
}
