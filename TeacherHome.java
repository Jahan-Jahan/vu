import java.awt.event.*;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;
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
    private JLabel userButtonLabel = new JLabel();
    private JButton addTextBtn = new JButton("Add Text");
    private JButton addHomeworkBtn = new JButton("Add Homework");
    private JButton addQuizBtn = new JButton("Add Quiz");
    private JButton logOutBtn = new JButton("Log out");
    private Font font3 = new Font("MV Boli", Font.BOLD, 13);

    private JFrame textAreaNewsFrame = new JFrame("Add Text");
    private JTextArea textAreaNews = new JTextArea(10, 30);
    private JButton textAreaSubmitBtnNews = new JButton("Submit");
    private Font font4 = new Font("MV Boli", Font.BOLD, 20);
    
    private JFrame textAreaHomeworkFrame = new JFrame("Add Text");
    private JTextArea textAreaHomework = new JTextArea(10, 30);
    private JButton textAreaSubmitBtnHomework = new JButton("Submit");

    private JButton changeRole = new JButton("Change!");

    private Font font2 = new Font("MV Boli", Font.BOLD, 22);
    private Color foreColor = new Color(80, 80, 80);
    private Color greenBtnColor = new Color(80, 200, 120);
    private Color borderColor = new Color(0, 100, 255);

    private Random random = new Random();

    private JButton addStudentBtn = new JButton("Add Student");
    private JFrame addStudentToLesson = new JFrame("Add student to lesson");
    private JLabel mainLabelAdd = new JLabel();
    private JTextField studentId = new JTextField();
    private JTextField lessonToAdd = new JTextField();
    private JLabel studentLabel = new JLabel("Student:");
    private JLabel lessonLabel = new JLabel("Lesson:");
    private JButton submit = new JButton("Submit");

    private ArrayList<String> studentsWeShowing = new ArrayList<String>();
    private HashMap<String, ArrayList<String>> map = new HashMap<>();
    private int h = 40;

    private JButton showNewsBtn = new JButton("See News");
    private JFrame showNewsFrame = new JFrame("News");
    private JTextArea showNewsTextArea = new JTextArea(10, 30);
    private JButton showNewsExitBtn = new JButton("OK!");
    
    private JTextArea showHomeworkTextArea = new JTextArea(10, 30);

    private JButton newsLimitStudentBtn = new JButton("See all student!");
    
    public TeacherHome(Teacher t) {

        teacher = new Teacher(t.getUsername(), t.getFirstName(), t.getLastName(), t.getEmail(), t.getTeachId(), t.getPhoneNumber(), t.getPassword());

        newsLimitStudentBtn.setBounds(35, 560, 230, 30);
        newsLimitStudentBtn.setFont(font2);
        newsLimitStudentBtn.setFocusable(false);
        newsLimitStudentBtn.setBackground(greenBtnColor);
        newsLimitStudentBtn.setForeground(foreColor);
        newsLimitStudentBtn.addActionListener(this);

        addTextBtn.setBounds(10, 0, 130, 30);
        addTextBtn.setBackground(greenBtnColor);
        addTextBtn.setForeground(foreColor);
        addTextBtn.setFont(font3);
        addTextBtn.addActionListener(this);
        textAreaNewsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textAreaNewsFrame.setSize(400, 300);
        textAreaNewsFrame.setLocationRelativeTo(null);
        textAreaNews.setLineWrap(true);
        textAreaNews.setWrapStyleWord(true);
        textAreaNews.setFont(font4);
        textAreaSubmitBtnNews.setBackground(greenBtnColor);
        textAreaSubmitBtnNews.setForeground(foreColor);
        textAreaSubmitBtnNews.setFont(font4);
        textAreaSubmitBtnNews.addActionListener(this);
        textAreaNewsFrame.getContentPane().add(new JScrollPane(textAreaNews), BorderLayout.CENTER);
        textAreaNewsFrame.getContentPane().add(textAreaSubmitBtnNews, BorderLayout.SOUTH);

        showNewsBtn.setBounds(35, 10, 230, 30);
        showNewsBtn.setFont(font2);
        showNewsBtn.setFocusable(false);
        showNewsBtn.setBackground(greenBtnColor);
        showNewsBtn.setForeground(foreColor);
        showNewsBtn.addActionListener(this);
        showNewsExitBtn.setFont(font2);
        showNewsExitBtn.setFocusable(false);
        showNewsExitBtn.setBackground(greenBtnColor);
        showNewsExitBtn.setForeground(foreColor);
        showNewsExitBtn.addActionListener(this);
        showNewsTextArea.setFont(font3);
        showNewsTextArea.setEditable(false);
        showNewsTextArea.setForeground(foreColor);
        showNewsTextArea.setLineWrap(true);
        showNewsTextArea.setWrapStyleWord(true);
        showNewsFrame.setSize(500, 500);
        showNewsFrame.setLocationRelativeTo(null);
        showNewsFrame.getContentPane().add(new JScrollPane(showNewsTextArea), BorderLayout.CENTER);
        showNewsFrame.getContentPane().add(showNewsExitBtn, BorderLayout.SOUTH);
        
        addHomeworkBtn.setBounds(140, 0, 130, 30);
        addHomeworkBtn.setBackground(greenBtnColor);
        addHomeworkBtn.setForeground(foreColor);
        addHomeworkBtn.setFont(font3);
        addHomeworkBtn.addActionListener(this);
        textAreaHomeworkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textAreaHomeworkFrame.setSize(400, 300);
        textAreaHomeworkFrame.setLocationRelativeTo(null);
        textAreaHomework.setLineWrap(true);
        textAreaHomework.setWrapStyleWord(true);
        textAreaHomework.setFont(font4);
        textAreaSubmitBtnHomework.setBackground(greenBtnColor);
        textAreaSubmitBtnHomework.setForeground(foreColor);
        textAreaSubmitBtnHomework.setFont(font4);
        textAreaSubmitBtnHomework.addActionListener(this);
        textAreaHomeworkFrame.getContentPane().add(new JScrollPane(textAreaHomework), BorderLayout.CENTER);
        textAreaHomeworkFrame.getContentPane().add(textAreaSubmitBtnHomework, BorderLayout.SOUTH);
        showHomeworkTextArea.setLineWrap(true);
        showHomeworkTextArea.setWrapStyleWord(true);    
        showHomeworkTextArea.setFont(font4);
        showHomeworkTextArea.setEditable(false);
        
        addQuizBtn.setBounds(10, 30, 130, 30);
        addQuizBtn.setBackground(greenBtnColor);
        addQuizBtn.setForeground(foreColor);
        addQuizBtn.setFont(font3);
        addQuizBtn.addActionListener(this);
        
        logOutBtn.setBounds(140, 30, 130, 30);
        logOutBtn.setBackground(greenBtnColor);
        logOutBtn.setForeground(foreColor);
        logOutBtn.setFont(font3);
        logOutBtn.addActionListener(this);

        userButtonLabel.setBounds(1225, 25, 280, 80);
        userButtonLabel.addMouseListener(this);
        userButtonLabel.add(addTextBtn);
        userButtonLabel.add(addHomeworkBtn);
        userButtonLabel.add(addQuizBtn);
        userButtonLabel.add(logOutBtn);
        userButtonLabel.setVisible(false);

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
        newsLabel.add(newsLimitStudentBtn);

        homeworkTextLabel.setBounds(580, 40, 400, 40);
        homeworkTextLabel.setFont(font2);
        homeworkTextLabel.setForeground(foreColor);
        homeworkTextLabel.addMouseListener(this);
        
        homeWorkLabel.setBounds(375, 100, 800, 680);
        homeWorkLabel.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        homeWorkLabel.setLayout(new BorderLayout());
        // homeWorkLabel.setBackground(Color.pink);
        // homeWorkLabel.setOpaque(true);
        homeWorkLabel.addMouseListener(this);
        homeWorkLabel.add(new JScrollPane(showHomeworkTextArea), BorderLayout.CENTER);

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
        usernameLabel.setBounds(1225, 25, 280, 80);
        usernameLabel.setOpaque(true);
        usernameLabel.addMouseListener(this);
        
        changeRole.setBounds(25, 25, 150, 80);
        changeRole.setFont(font2);
        changeRole.setBackground(greenBtnColor);
        changeRole.setFocusable(false);
        changeRole.addActionListener(this);

        addStudentBtn.setBounds(180, 25, 150, 80);
        addStudentBtn.setFont(new Font("MV Boli", Font.BOLD, 16));
        addStudentBtn.setBackground(greenBtnColor);
        addStudentBtn.setFocusable(false);
        addStudentBtn.addActionListener(this);

        studentId.setBounds(130, 50, 200, 40);
        studentId.setFont(font2);
        studentLabel.setBounds(30, 50, 100, 40);
        studentLabel.setFont(font2);
        lessonToAdd.setBounds(130, 100, 200, 40);
        lessonToAdd.setFont(font2);
        lessonLabel.setBounds(30, 100, 100, 40);
        lessonLabel.setFont(font2);
        submit.setBounds(140, 150, 120, 40);
        submit.setFont(font2);
        submit.setBackground(greenBtnColor);
        submit.setFocusable(false);
        submit.addActionListener(this);
        
        updateNews();
        updateHomework();
        showStudent();
        revalidate();

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
        mainLabel.add(userButtonLabel);
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
            addStudentAndTeacher();
            showStudent();
            newsLabel.validate();
            studentId.setText("");
            lessonToAdd.setText("");
            addStudentToLesson.dispose();
        }

        if (e.getSource() == addTextBtn) {
            textAreaNewsFrame.setVisible(true);
        }

        if (e.getSource() == textAreaSubmitBtnNews) {
            String text = textAreaNews.getText();

            text.replace('\n', ' ');

            String fileName = "news.csv";

            try (FileWriter fw = new FileWriter(fileName, true);
             PrintWriter pw = new PrintWriter(fw)) {
                
                String stringTime = getTime();
                
                pw.println(teacher.getUsername() + "," + text + "," + stringTime);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            showNewsTextArea.setText("");
            updateNews();

            textAreaNews.setText("");

            textAreaNewsFrame.dispose();
        }

        if (e.getSource() == showNewsBtn) {
            // updateNews();
            showNewsFrame.setVisible(true);
        }

        if (e.getSource() == showNewsExitBtn) {
            showNewsFrame.dispose();
        }

        if (e.getSource() == textAreaSubmitBtnHomework) {
            String text = textAreaHomework.getText();

            text.replace('\n', ' ');

            String fileName = "homework.csv";

            try (FileWriter fw = new FileWriter(fileName, true);
             PrintWriter pw = new PrintWriter(fw)) {

                String stringTime = getTime();
                
                pw.println(teacher.getUsername() + "," + text + "," + stringTime);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            showHomeworkTextArea.setText("");
            updateHomework();

            textAreaHomework.setText("");

            textAreaHomeworkFrame.dispose();
        }

        if (e.getSource() == addHomeworkBtn) {
            // updateHomework();
            textAreaHomeworkFrame.setVisible(true);
        }

        // add a textarea to see the HOMEWORK...

        if (e.getSource() == logOutBtn) {
            dispose();

            int response = JOptionPane.showConfirmDialog(this, "Are you done?", "Exit?", JOptionPane.YES_NO_OPTION);
            
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else if (response == JOptionPane.NO_OPTION) {
                new Login();
            }
        }

        if (e.getSource() == newsLimitStudentBtn) {
            JFrame frame = new JFrame("All Students");
            JLabel mainLabel = new JLabel();
            JTextArea textArea = new JTextArea(10, 20);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JButton okBtn = new JButton("OK!");

            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setFont(font2);
            textArea.setEditable(false);
            textArea.setForeground(foreColor);

            okBtn.setForeground(foreColor);
            okBtn.setBackground(greenBtnColor);
            okBtn.setFocusable(false);
            okBtn.setFont(font2);
            okBtn.addActionListener((ActionEvent ev) -> {
                frame.dispose();
            });

            String fileName = "studentsOf" + teacher.getUsername() + ".csv";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                
                String line;

                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");

                    String username = findUsernameById(details[0]);
                    String less = details[1];

                    textArea.setText(textArea.getText() + username + "," + less + "\n");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            mainLabel.setBounds(0, 0, 400, 400);
            mainLabel.setLayout(new BorderLayout());

            mainLabel.add(scrollPane, BorderLayout.CENTER);
            mainLabel.add(okBtn, BorderLayout.SOUTH);

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.add(mainLabel);

            frame.setVisible(true);
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
        if (e.getSource() == usernameLabel) {
            usernameLabel.setVisible(false);
            userButtonLabel.setVisible(true);
        }
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
        if (e.getSource() == userButtonLabel) {
            usernameLabel.setVisible(true);
            userButtonLabel.setVisible(false);
        }
    }

    public String getTime() {

        ZonedDateTime time = ZonedDateTime.now();

        String year = String.valueOf(time.getYear());
        String month = String.valueOf(time.getMonthValue());
        String day = String.valueOf(time.getDayOfMonth());
        String hour = String.valueOf(time.getHour());
        String min = String.valueOf(time.getMinute());
        String sec = String.valueOf(time.getSecond());

        if (month.length() == 1) month = "0" + month;
        if (day.length() == 1) day = "0" + day;
        if (hour.length() == 1) hour = "0" + hour;
        if (min.length() == 1) min = "0" + min;
        if (sec.length() == 1) sec = "0" + sec;

        String stringTime = year + "-" + month + "-" + day + " / " + hour + ":" + min + ":" + sec;

        return stringTime;
    }

    public void updateNews() {
        try (BufferedReader br = new BufferedReader(new FileReader("news.csv"))) {
            
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] details = line.split(",");

                String username = details[0];
                String text = details[1];
                String stringTime = details[2];

                showNewsTextArea.setText(showNewsTextArea.getText() + username + " at " + stringTime + " said: " + text + "\n---------------\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateHomework() {
        try (BufferedReader br = new BufferedReader(new FileReader("homework.csv"))) {
            
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] details = line.split(",");

                String username = details[0];
                String text = details[1];
                String stringTime = details[2];

                showHomeworkTextArea.setText(showHomeworkTextArea.getText() + username + " at " + stringTime + "\n" + text + "\n---------------\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addStudentAndTeacher() {
        String id = studentId.getText();

        if (findUsernameById(id).equals("Unknown")) {
            JOptionPane.showMessageDialog(this, "This students doesn't exist!");
            return;
        }
        
        String lesson = lessonToAdd.getText();

        String stringToWrite = id + "," + lesson;

        String fileName = "studentsOf" + teacher.getUsername() + ".csv";

        File file = new File(fileName);

        ArrayList<String> teacherInfoWeHave = new ArrayList<String>();

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

                String line;

                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");
                    teacherInfoWeHave.add(details[0] + "," + details[1]);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (!teacherInfoWeHave.contains(id + "," + lesson)) {
            try (FileWriter fw = new FileWriter("studentsOf" + teacher.getUsername() + ".csv", true);
                PrintWriter pw = new PrintWriter(fw)) {

                pw.println(stringToWrite);
                JOptionPane.showMessageDialog(this, "Student has added successfully!");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving user details.");
            }
        }

        for (String st : map.keySet()) {

            // System.out.println(st);

            // String[] studentAndLesson = st.split(",");

            // ArrayList<String> allTeacherAndLesson = new ArrayList<String>();

            String readerFileName = "teachersOf" + findUsernameById(st) + ".csv";

            file = new File(readerFileName);
            
            boolean s = true;

            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(readerFileName))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        
                        String[] details = line.split(",");
                        // System.out.println(findUsernameById(st.split(",")[0]));
                        // System.out.println(details[0] + "  " + details[1]);

                        if ((teacher.getUsername() + "," + lesson).equals(details[0] + "," + details[1])) {
                            s = false;
                            break;
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (s) {
                try (FileWriter fw = new FileWriter(readerFileName);
                    PrintWriter pw = new PrintWriter(fw)) {

                    for (String lessonOfMap : map.get(st)) {
                        pw.println(teacher.getUsername() + "," + lessonOfMap);
                    }
                    // JOptionPane.showMessageDialog(this, "Teacher has added successfully!");

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving user details.");
                }
            }
        }
        
    }

    public void showStudent() {

        String fileName = "studentsOf" + teacher.getUsername() + ".csv";

        File file = new File(fileName);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

                String line;

                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");
                    String id = details[0];
                    String less = details[1];
                    String username = findUsernameById(id);
                    String stringToShow = username + "," + less;
                    
                    if (studentsWeShowing.contains(id + "," + less) == false) {
                        studentsWeShowing.add(id + "," + less);
                        if (map.containsKey(id)) {
                            map.get(id).add(less);
                        } else {
                            ArrayList<String> arrayListLesson = new ArrayList<String>();
                            arrayListLesson.add(less);
                            map.put(id, arrayListLesson);
                        }
                        if (h < 560) {
                            JLabel studentToShow = new JLabel(stringToShow);
                            studentToShow.setBounds(10, h + 10, 250, 25);
                            studentToShow.setForeground(foreColor);
                            studentToShow.setFont(new Font("MV Boli", Font.BOLD, 18));
                            newsLabel.add(studentToShow);
                            h += 35;
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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

        // if (username.equals("Unknown")) username += unknownCount++;

        return username;
    }

}
