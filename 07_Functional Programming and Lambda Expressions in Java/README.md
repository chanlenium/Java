# Workshop 05 : Serialize and Deserialize

## Objectives
* Familiar with Serialization/Deserialization
* Set fields of object from console input
* Save the object in a file through serialization
* Read object from the file, and show the information in the console through deserialization

## Outline
### Construct an object using console input
* To receive input from the console, use `Scanner` class
    * after receving input, valiate it 
```
Scanner keyboard;
keyboard = new Scanner(System.in);
```
* When the input does not meet input requirement, the program throws exception
```
public Student(int stdId, String firstName, String lastName, ArrayList<String> courses) throws InputException{
    if(stdId > 0 && firstName != null && lastName != null && courses.size() > 0){
        this.stdId = stdId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }else{
        // If an input is invalid, throw the exception!
        throw new InputException("Invalid user input!");
    }
}
```
    * Customize exception handler
```
public class InputException extends Exception{
    public InputException(String message) {
        super(message);
    }
}
```

### Serialization : save the object in a file 
* Implement `Serializable` in a model
```
public class Student implements Serializable {
    // To-do
}
```
* Use `FileOutputStream` and `ObjectOutputStream`
    * OjbectOutputStream acts as a bridge to link an object and a file
```
FileOutputStream fos = new FileOutputStream("output.txt");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(student);
oos.flush();
fos.close();
```

### Deserialization : Read object from the file
```
FileInputStream fis = new FileInputStream("output.txt");
ObjectInputStream ois = new ObjectInputStream(fis);
student = (Student) ois.readObject();   // to access inside that one
fis.close();
```

## Screenshot
* Link : https://github.com/chanlenium/Java/blob/main/03_Encapsulation%2C%20Inheritance%2C%20and%20Polymorphism/screenshot.pdf