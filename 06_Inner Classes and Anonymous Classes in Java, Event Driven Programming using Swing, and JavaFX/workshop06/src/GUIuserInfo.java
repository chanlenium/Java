import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIuserInfo extends JFrame{
    private JPanel panel1;
    private JLabel titleLabel;
    private JTextField studentNumberTf;
    private JLabel studentNumberLabel;
    private JTextField firstNameTf;
    private JLabel firstNameLabel;
    private JTextField lastNameTf;
    private JLabel lastNameLabel;
    private JButton serializeButton;
    private JButton deserializeButton;
    private JTextArea textArea;
    private JLabel courseNameLabel;
    private JTextField courseNameTf;
    private Student student;
    private String deserializedStudentInfo;
    private ArrayList<String> courses;

    // Variable for storing and validating user input
    private String strStdID, strFirstName, strLastName, strCourseName;
    private boolean isValidStdID, isValidFirstName, isValidLastName, isValidCourseName;
    private String[] courseNameTokens;

    public GUIuserInfo(){
        add(panel1);
        initData(); // data initialization

        // When clicking 'Serialize' button
        serializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputValidate();
                // when all inputs are valid, create a student object and save it as a file
                if(isValidStdID && isValidFirstName && isValidLastName && isValidCourseName){
                    for(int i = 0; i < courseNameTokens.length; i++)
                        courses.add(courseNameTokens[i]);
                    try {
                        // construct the student object using 4 parameters
                        student = new Student(Integer.parseInt(strStdID), strFirstName, strLastName, courses);
                        // serialize(save) the object
                        new SerializeStudentInfo().serialize(student);
                        JOptionPane.showMessageDialog(null, "Serialization done");
                    } catch (InputException err) {    // catch and treat exception
                        System.err.println(err.getMessage());
                    }
                }
            }
        });

        deserializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // deserialize a saved object
                deserializedStudentInfo = new DeserializeStudentInfo().deserialize();
                if(deserializedStudentInfo.length() > 0){
                    textArea.append(deserializedStudentInfo);
                }else{
                    textArea.append("No deserialized information");
                }
            }
        });
    }

    private void inputValidate() {
        strStdID = studentNumberTf.getText();
        strFirstName = firstNameTf.getText();
        strLastName = lastNameTf.getText();
        strCourseName = courseNameTf.getText();

        // Check whether student ID is valid or not
        isValidStdID = new SerializeStudentInfo().enterInteger(strStdID.trim(), 0, 99999);
        if(isValidStdID)
            studentNumberLabel.setText("");
        else
            studentNumberLabel.setText("Input is invalid. Enter only numbers");

        // Check whether input value for first name is valid or not
        isValidFirstName = new SerializeStudentInfo().enterName(strFirstName.trim(), "[A-Za-z]*");
        if(!isValidFirstName)
            firstNameLabel.setText("Input is invalid. Enter only alphabet");
        else
            firstNameLabel.setText("");

        // Check whether input value for last name is valid or not
        isValidLastName = new SerializeStudentInfo().enterName(strLastName.trim(), "[A-Za-z]*");
        if(!isValidLastName)
            lastNameLabel.setText("Input is invalid. Enter only alphabet");
        else
            lastNameLabel.setText("");

        // Check whether input values for course names are valid or not
        courseNameTokens = strCourseName.split(";");
        isValidCourseName = new SerializeStudentInfo().enterCourseName(courseNameTokens, "[A-Za-z0-9]*");
        if(!isValidCourseName)
            courseNameLabel.setText("Input is invalid. " +
                    "Course name is composed of String and number with length 6. " +
                    "Multiple inputs should be separated by semicolon(;)");
        else
            courseNameLabel.setText("");
    }

    private void initData() {
        // Label initialization
        studentNumberLabel.setText("");
        firstNameLabel.setText("");
        lastNameLabel.setText("");
        courseNameLabel.setText("");
        courses = new ArrayList<String>();
    }
}
