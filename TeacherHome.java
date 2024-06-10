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
    
    private JFrame textAreaHomeworkFrame = new JFrame("Add Homework");
    private JTextArea textAreaHomework = new JTextArea(10, 30);
    private JButton textAreaSubmitBtnHomework = new JButton("Submit");

    private JButton changeRole = new JButton("Change!");

    private Font font2 = new Font("MV Boli", Font.BOLD, 22);
    private Color foreColor = new Color(80, 80, 80);
    private Color backColor = new Color(144, 238, 144);
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
    private JButton quizLimitStudentBtn = new JButton("See all quiz!");

    private JFrame selectAddQuizFrame = new JFrame("Add Quiz");
    private JLabel selectAddQuizLabel = new JLabel();
    private JRadioButton q1 = new JRadioButton("Descriptive");
    private JRadioButton q2 = new JRadioButton("Choice-Question");
    private JRadioButton q3 = new JRadioButton("True/False");
    private ButtonGroup selectAddQuizGroup = new ButtonGroup();
    private JButton selectAddQuizBtn = new JButton("Select!");

    private JFrame qFrame1 = new JFrame("Descriptive");
    private JButton qSubmitBtn1 = new JButton("Submit!");
    private JTextArea qTextArea1 = new JTextArea(10, 20);
    
    private JFrame qFrame2 = new JFrame("Choice-Question");
    private JLabel qLabel2 = new JLabel();
    private JButton qSubmitBtn2 = new JButton("Submit!");
    private JTextArea qTextArea2 = new JTextArea(10, 20);
    private JScrollPane qScrollPane2 = new JScrollPane(qTextArea2);
    private JTextField qTextFieldOpt1 = new JTextField();
    private JTextField qTextFieldOpt2 = new JTextField();
    private JTextField qTextFieldOpt3 = new JTextField();
    private JTextField qTextFieldOpt4 = new JTextField();
    private JLabel qTextFieldLabelOpt1 = new JLabel("Opt1:");
    private JLabel qTextFieldLabelOpt2 = new JLabel("Opt2:");
    private JLabel qTextFieldLabelOpt3 = new JLabel("Opt3:");
    private JLabel qTextFieldLabelOpt4 = new JLabel("Opt4:");
    private Font font5 = new Font("MV Boli", Font.BOLD, 16);
    
    private JFrame qFrame3 = new JFrame("True/False");
    private JLabel qLabel3 = new JLabel();
    private JButton qSubmitBtn3 = new JButton("Submit!");
    private JTextArea qTextArea3 = new JTextArea(10, 20);
    private JScrollPane qScrollPane3 = new JScrollPane(qTextArea3);
    private JRadioButton qTrueRadioBtn = new JRadioButton("True");
    private JRadioButton qFalseRadioBtn = new JRadioButton("False");
    private ButtonGroup qRadioGroup = new ButtonGroup();

    private int quizCount1 = 0;
    private int quizCount2 = 0;
    private int quizCount3 = 0;

    private JLabel addQuizLabel1;
    private JLabel addQuizLabel2;
    private JLabel addQuizLabel3;
    private int hQuiz = 0;

    private String quizFileName;

    private ArrayList<JLabel> quizLabels = new ArrayList<JLabel>();
            
    public TeacherHome(Teacher t) {

        teacher = new Teacher(t.getUsername(), t.getFirstName(), t.getLastName(), t.getEmail(), t.getTeachId(), t.getPhoneNumber(), t.getPassword());

        quizFileName = "quizOf" + teacher.getUsername() + ".csv";

        File quizFile = new File(quizFileName);
        if (quizFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(quizFileName))) {

                String line;
                int countLine = 0;

                while ((line = br.readLine()) != null) {
                    if (countLine == 0) {
                        String[] details = line.split(",");
                        quizCount1 = Integer.parseInt(details[0]);
                        quizCount2 = Integer.parseInt(details[1]);
                        quizCount3 = Integer.parseInt(details[2]);
                    } else {
                        break;
                    }
                    countLine++;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try (FileWriter fw = new FileWriter(quizFileName);
            PrintWriter pw = new PrintWriter(fw)) {

                pw.println(quizCount1 + "," + quizCount2 + "," + quizCount3);
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        qSubmitBtn1.setFont(font2);
        qSubmitBtn1.setForeground(foreColor);
        qSubmitBtn1.setFocusable(false);
        qSubmitBtn1.setBackground(greenBtnColor);
        qSubmitBtn1.addActionListener(this);
        qTextArea1.setFont(font4);
        qTextArea1.setForeground(foreColor);
        qTextArea1.setWrapStyleWord(true);
        qTextArea1.setLineWrap(true);
        qFrame1.setSize(400, 400);
        qFrame1.setLayout(new BorderLayout());
        qFrame1.setLocationRelativeTo(null);
        qFrame1.getContentPane().add(new JScrollPane(qTextArea1), BorderLayout.CENTER);
        qFrame1.getContentPane().add(qSubmitBtn1, BorderLayout.SOUTH);
        
        qSubmitBtn2.setBounds(150, 350, 100, 25);
        qSubmitBtn2.setFont(font5);
        qSubmitBtn2.setFocusable(false);
        qSubmitBtn2.setForeground(foreColor);
        qSubmitBtn2.setBackground(greenBtnColor);
        qSubmitBtn2.addActionListener(this);
        qTextArea2.setFont(font4);
        qTextArea2.setForeground(foreColor);
        qTextArea2.setWrapStyleWord(true);
        qTextArea2.setLineWrap(true);
        qScrollPane2.setBounds(0, 0, 385, 150);
        qTextFieldLabelOpt1.setBounds(20, 175, 50, 40);
        qTextFieldLabelOpt1.setFont(font5);
        qTextFieldLabelOpt1.setForeground(foreColor);
        qTextFieldOpt1.setBounds(70, 175, 260, 40);
        qTextFieldOpt1.setFont(font3);
        qTextFieldOpt1.setForeground(foreColor);
        qTextFieldLabelOpt2.setBounds(20, 215, 50, 40);
        qTextFieldLabelOpt2.setFont(font5);
        qTextFieldLabelOpt2.setForeground(foreColor);
        qTextFieldOpt2.setBounds(70, 215, 260, 40);
        qTextFieldOpt2.setFont(font3);
        qTextFieldOpt2.setForeground(foreColor);
        qTextFieldLabelOpt3.setBounds(20, 255, 50, 40);
        qTextFieldLabelOpt3.setFont(font5);
        qTextFieldLabelOpt3.setForeground(foreColor);
        qTextFieldOpt3.setBounds(70, 255, 260, 40);
        qTextFieldOpt3.setFont(font3);
        qTextFieldOpt3.setForeground(foreColor);
        qTextFieldLabelOpt4.setBounds(20, 295, 50, 40);
        qTextFieldLabelOpt4.setFont(font5);
        qTextFieldLabelOpt4.setForeground(foreColor);
        qTextFieldOpt4.setBounds(70, 295, 260, 40);
        qTextFieldOpt4.setFont(font3);
        qTextFieldOpt4.setForeground(foreColor);
        qLabel2.setBounds(0, 0, 400, 430);
        qLabel2.setBackground(backColor);
        qLabel2.setOpaque(true);
        qLabel2.add(qScrollPane2);
        qLabel2.add(qTextFieldOpt1);
        qLabel2.add(qTextFieldOpt2);
        qLabel2.add(qTextFieldOpt3);
        qLabel2.add(qTextFieldOpt4);
        qLabel2.add(qTextFieldLabelOpt1);
        qLabel2.add(qTextFieldLabelOpt2);
        qLabel2.add(qTextFieldLabelOpt3);
        qLabel2.add(qTextFieldLabelOpt4);
        qLabel2.add(qSubmitBtn2);
        qFrame2.setSize(400, 430);
        qFrame2.setLocationRelativeTo(null);
        qFrame2.add(qLabel2);
        
        qRadioGroup.add(qTrueRadioBtn);
        qRadioGroup.add(qFalseRadioBtn);
        qTrueRadioBtn.setFont(font2);
        qTrueRadioBtn.setForeground(foreColor);
        qTrueRadioBtn.setBackground(backColor);
        qTrueRadioBtn.setBounds(150, 225, 100, 40);
        qFalseRadioBtn.setFont(font2);
        qFalseRadioBtn.setForeground(foreColor);
        qFalseRadioBtn.setBackground(backColor);
        qFalseRadioBtn.setBounds(150, 275, 100, 40);
        qSubmitBtn3.setFont(font2);
        qSubmitBtn3.setFocusable(false);
        qSubmitBtn3.setForeground(foreColor);
        qSubmitBtn3.setBackground(greenBtnColor);
        qSubmitBtn3.addActionListener(this);
        qSubmitBtn3.setBounds(125, 350, 150, 30);
        qTextArea3.setFont(font4);
        qTextArea3.setForeground(foreColor);
        qTextArea3.setWrapStyleWord(true);
        qTextArea3.setLineWrap(true);
        qScrollPane3.setBounds(0, 0, 385, 200);
        qLabel3.setBounds(0, 0, 400, 430);
        qLabel3.setBackground(backColor);
        qLabel3.setOpaque(true);
        qLabel3.add(qScrollPane3);
        qLabel3.add(qSubmitBtn3);
        qLabel3.add(qTrueRadioBtn);
        qLabel3.add(qFalseRadioBtn);
        qFrame3.setSize(400, 430);
        qFrame3.setLocationRelativeTo(null);
        qFrame3.add(qLabel3);

        q1.setBounds(25, 0, 250, 60);
        q1.setFont(font2);
        q1.setForeground(foreColor);
        q1.setBackground(backColor);
        q1.setFocusable(false);
        // q1.setBackground(new Color(255, 180, 193));
        q2.setBounds(25, 60, 250, 60);
        q2.setFont(font2);
        q2.setForeground(foreColor);
        q2.setBackground(backColor);
        q2.setFocusable(false);
        // q2.setBackground(new Color(255, 125, 193));
        q3.setBounds(25, 120, 250, 60);
        q3.setFont(font2);
        q3.setForeground(foreColor);
        q3.setBackground(backColor);
        q3.setFocusable(false);
        // q3.setBackground(new Color(255, 120, 193));

        selectAddQuizBtn.setBounds(90, 225, 120, 25);
        selectAddQuizBtn.setForeground(foreColor);
        selectAddQuizBtn.setBackground(greenBtnColor);
        selectAddQuizBtn.setFont(font2);
        selectAddQuizBtn.addActionListener(this);

        selectAddQuizGroup.add(q1);
        selectAddQuizGroup.add(q2);
        selectAddQuizGroup.add(q3);

        selectAddQuizLabel.setBounds(0, 0, 300, 300);
        selectAddQuizLabel.setBackground(backColor);
        selectAddQuizLabel.setOpaque(true);
        selectAddQuizLabel.add(q1);
        selectAddQuizLabel.add(q2);
        selectAddQuizLabel.add(q3);
        selectAddQuizLabel.add(selectAddQuizBtn);

        selectAddQuizFrame.setSize(300, 300);
        selectAddQuizFrame.setLocationRelativeTo(null);
        selectAddQuizFrame.add(selectAddQuizLabel);

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

        quizLimitStudentBtn.setBounds(35, 560, 230, 30);
        quizLimitStudentBtn.setFont(font2);
        quizLimitStudentBtn.setFocusable(false);
        quizLimitStudentBtn.setBackground(greenBtnColor);
        quizLimitStudentBtn.setForeground(foreColor);
        quizLimitStudentBtn.addActionListener(this);
        
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
        quizLabel.add(quizLimitStudentBtn);

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
        mainLabelAdd.setBackground(backColor);
        mainLabelAdd.setOpaque(true);
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

        if (e.getSource() == addQuizBtn) {
            selectAddQuizFrame.setVisible(true);
        }

        if (e.getSource() == selectAddQuizBtn) {

            selectAddQuizFrame.dispose();

            if (q1.isSelected()) {

                qFrame1.setVisible(true);
                

            } else if (q2.isSelected()) {
                
                qFrame2.setVisible(true);

            } else if (q3.isSelected()) {
                
                qFrame3.setVisible(true);

            }
        }

        if (e.getSource() == qSubmitBtn1) {
            qFrame1.dispose();
            
            String text = qTextArea1.getText();
            String fileName = "DescriptiveQuiz" + quizCount1 + "Of" + teacher.getUsername() + ".csv";

            text.replace('\n', ' ');

            try (FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw)) {

                pw.println(teacher.getUsername() + "," + text + ",D"); // D -> Descriptive
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            qTextArea1.setText("");

            int response = JOptionPane.showConfirmDialog(this, "Do you want to add more question?", "More Question", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {

                qFrame1.setVisible(true);

            } else {

                if (hQuiz < 560) {
                    addQuizLabel1 = new JLabel("Descriptive Quiz " + quizCount1);
                    addQuizLabel1.setBounds(10, hQuiz + 10, 270, 40);
                    addQuizLabel1.setForeground(foreColor);
                    addQuizLabel1.setFont(font2);
                    addQuizLabel1.addMouseListener(this);
                    quizLabel.add(addQuizLabel1);
                    hQuiz += 40;
                    quizLabels.add(addQuizLabel1);
                }

                ArrayList<String> savedQuiz = new ArrayList<String>();

                try (BufferedReader br = new BufferedReader(new FileReader(quizFileName))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        savedQuiz.add(line);
                    }
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                savedQuiz.add("DescriptiveQuiz" + quizCount1 + "Of" + teacher.getUsername() + ".csv");
                
                try (FileWriter fw = new FileWriter(quizFileName);
                PrintWriter pw = new PrintWriter(fw)) {

                    for (String line : savedQuiz) {
                        pw.println(line);
                    }
                
                } catch (IOException quizException) {
                    quizException.printStackTrace();
                }

                quizCount1++;
            }
        }

        if (e.getSource() == qSubmitBtn2) {
            qFrame2.dispose();
            
            String text = qTextArea2.getText();
            String o1 = qTextFieldOpt1.getText();
            String o2 = qTextFieldOpt2.getText();
            String o3 = qTextFieldOpt3.getText();
            String o4 = qTextFieldOpt4.getText();
            String fileName = "ChoiceQuiz" + quizCount2 + "Of" + teacher.getUsername() + ".csv";

            text.replace('\n', ' ');

            try (FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw)) {

                pw.println(teacher.getUsername() + "," + text + "," + o1 + "," + o2 + "," + o3 + "," + o4 + ",C"); // C --> Choice-Question
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            qTextArea2.setText("");
            qTextFieldOpt1.setText("");
            qTextFieldOpt2.setText("");
            qTextFieldOpt3.setText("");
            qTextFieldOpt4.setText("");

            int response = JOptionPane.showConfirmDialog(this, "Do you want to add more question?", "More Question", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {

                qFrame2.setVisible(true);

            } else {

                if (hQuiz < 560) {
                    addQuizLabel2 = new JLabel("Choice Quiz " + quizCount2);
                    addQuizLabel2.setBounds(10, hQuiz + 10, 270, 40);
                    addQuizLabel2.setForeground(foreColor);
                    addQuizLabel2.setFont(font2);
                    addQuizLabel2.addMouseListener(this);
                    quizLabel.add(addQuizLabel2);
                    hQuiz += 40;
                    quizLabels.add(addQuizLabel2);
                }

                ArrayList<String> savedQuiz = new ArrayList<String>();

                try (BufferedReader br = new BufferedReader(new FileReader(quizFileName))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        savedQuiz.add(line);
                    }
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                savedQuiz.add("ChoiceQuiz" + quizCount2 + "Of" + teacher.getUsername() + ".csv");
                
                try (FileWriter fw = new FileWriter(quizFileName);
                PrintWriter pw = new PrintWriter(fw)) {

                    for (String line : savedQuiz) {
                        pw.println(line);
                    }
                
                } catch (IOException quizException) {
                    quizException.printStackTrace();
                }

                quizCount2++;
            }
        }

        if (e.getSource() == qSubmitBtn3) {
            qFrame3.dispose();
            
            String text = qTextArea3.getText();
            String booleanAnswer = qTrueRadioBtn.isSelected() ? "True" : "False";
            String fileName = "TFQuiz" + quizCount3 + "Of" + teacher.getUsername() + ".csv";

            text.replace('\n', ' ');

            try (FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw)) {

                pw.println(teacher.getUsername() + "," + text + booleanAnswer + ",TF"); // TF -> True/False Question
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            qTextArea3.setText("");

            int response = JOptionPane.showConfirmDialog(this, "Do you want to add more question?", "More Question", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {

                qFrame3.setVisible(true);

            } else {

                if (hQuiz < 560) {
                    addQuizLabel3 = new JLabel("True/False Quiz " + quizCount3);
                    addQuizLabel3.setBounds(10, hQuiz + 10, 270, 40);
                    addQuizLabel3.setForeground(foreColor);
                    addQuizLabel3.setFont(font2);
                    addQuizLabel3.addMouseListener(this);
                    quizLabel.add(addQuizLabel3);
                    hQuiz += 40;
                    quizLabels.add(addQuizLabel3);
                }

                ArrayList<String> savedQuiz = new ArrayList<String>();

                try (BufferedReader br = new BufferedReader(new FileReader(quizFileName))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        savedQuiz.add(line);
                    }
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                savedQuiz.add("TFQuiz" + quizCount3 + "Of" + teacher.getUsername() + ".csv");
                
                try (FileWriter fw = new FileWriter(quizFileName);
                PrintWriter pw = new PrintWriter(fw)) {

                    for (String line : savedQuiz) {
                        pw.println(line);
                    }
                
                } catch (IOException quizException) {
                    quizException.printStackTrace();
                }

                quizCount3++;
            }
        }

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
            String fileName = "studentsOf" + teacher.getUsername() + ".csv";

            File file = new File(fileName);

            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "There is no student!");
                return;
            }

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

        if (e.getSource() == quizLimitStudentBtn) {
            String fileName1 = "quiz1Of" + teacher.getUsername() + ".csv";
            String fileName2 = "quiz2Of" + teacher.getUsername() + ".csv";
            String fileName3 = "quiz3Of" + teacher.getUsername() + ".csv";

            File file1 = new File(fileName1);
            File file2 = new File(fileName2);
            File file3 = new File(fileName3);

            if (!file1.exists() && !file2.exists() && !file3.exists()) {
                JOptionPane.showMessageDialog(this, "There is no quiz!");
                return;
            }
            
            JFrame frame = new JFrame("All Quiz");
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

            try (BufferedReader br = new BufferedReader(new FileReader(fileName1))) {
                
                String line;

                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");

                    String username = details[0];
                    String question = details[1];

                    textArea.setText(textArea.getText() + username + "," + question + "\n");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader(fileName2))) {
                
                String line;

                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");

                    String username = details[0];
                    String question = details[1];
                    String opt1 = details[2];
                    String opt2 = details[3];
                    String opt3 = details[4];
                    String opt4 = details[5];

                    textArea.setText(textArea.getText() + username + "," + question + "," + opt1 + "," + opt2 + "," + opt3 + "," + opt4 + "\n");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader(fileName3))) {
                
                String line;

                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");

                    String username = details[0];
                    String question = details[1];

                    textArea.setText(textArea.getText() + username + "," + question + "\n");
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
    public void mouseClicked(MouseEvent e) {
        // for (int i = 0; i < quizLabels.size(); i++) {
        //     if (e.getSource() == quizLabels[i]) {
                
        //     }
        // }
    }

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

    public void updateQuiz() {

        String fileName = "quizOf" + teacher.getUsername() + ".csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");


                
                // It is not complete!



            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void updateNews() {

        String fileName = "news.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
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

        String fileName = "homework.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] details = line.split(",");

                String username = details[0];
                String text = details[1];
                String stringTime = details[2];

                if (username.equals(teacher.getUsername())) showHomeworkTextArea.setText(showHomeworkTextArea.getText() + username + " at " + stringTime + "\n" + text + "\n---------------\n");
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

        ArrayList<String> studentsOfThisTeacher = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                studentsOfThisTeacher.add(details[0] + "," + details[1]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

        if (!studentsOfThisTeacher.contains(id + "," + lesson)) {
            try (FileWriter fw = new FileWriter("studentsOf" + teacher.getUsername() + ".csv", true);
                PrintWriter pw = new PrintWriter(fw)) {

                pw.println(stringToWrite);
                newsLabel.revalidate();
                JOptionPane.showMessageDialog(this, "Student has added successfully!");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving user details.");
            }

            if (map.containsKey(id)) {
                map.get(id).add(lesson);
            } else {
                ArrayList<String> arrayListLesson = new ArrayList<String>();
                arrayListLesson.add(lesson);
                map.put(id, arrayListLesson);
            }
        }

        for (String st : map.keySet()) {

            // System.out.println(st);

            // String[] studentAndLesson = st.split(",");

            // ArrayList<String> allTeacherAndLesson = new ArrayList<String>();

            String readerFileName = "teachersOf" + findUsernameById(st) + ".csv";
            
            boolean s = true;

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
            

            if (s) {
                ArrayList<String> everyLine = new ArrayList<String>();

                try (BufferedReader br = new BufferedReader(new FileReader(readerFileName))) {
                    
                    String line;

                    while ((line = br.readLine()) != null) {
                        everyLine.add(line);
                    }

                } catch (IOException fileException) {
                    fileException.printStackTrace();
                }

                try (FileWriter fw = new FileWriter(readerFileName);
                    PrintWriter pw = new PrintWriter(fw)) {

                    for (String line : everyLine) {
                        pw.println(line);
                    }

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

    public String findUsernameById(String id) {

        String username = "Unknown";
        String fileName = "users.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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
