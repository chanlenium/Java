# Workshop 06 : Event Driven Programming using Swing

## Objectives
* Design a `Swing` (or `Java FX`) GUI-based Java application
* Using `JFrame` with some `JTextFields`, `JButtons`, and `JTextAreas` to data serialize/deserialize
* Implementing event driven program using `Event Listener`

## Outline
### Design GUI
* Add GUI Form in intellij
    * src (right click) > New > Swing UI Designer > GUI Form 
    * Create GUI form (GUIuserInfo.form) as well as GUI manager class (GUIuserInfo.class)

image

* Frame definition
```
public class Start {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIuserInfo frame = new GUIuserInfo();
                frame.setVisible(true);
                //frame.setResizable(false);   // fix frame size
                frame.setSize(800, 600);  // set Frame size
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}
```

### Utilize GUI components to data serialize/deserialize
* Define reference variables for each component in GUI Form
```
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
```

* Initialize the reference variables when constructing 
```
public GUIuserInfo(){
    add(panel1);
    initData(); // data initialization
}

private void initData() {
    // Label initialization
    studentNumberLabel.setText("");
    firstNameLabel.setText("");
    lastNameLabel.setText("");
    courseNameLabel.setText("");
    courses = new ArrayList<String>();
}
```

### Implement `Event Listener`
* Implement 'Serialize' button
```
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
```

* Implement 'Deserialize' button
```
// When clicking 'Deserialize' button
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
```

## Screenshot
* Link : https://github.com/chanlenium/Java/blob/main/03_Encapsulation%2C%20Inheritance%2C%20and%20Polymorphism/screenshot.pdf
