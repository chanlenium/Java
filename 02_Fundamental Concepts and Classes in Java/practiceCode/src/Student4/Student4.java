package Student4;

public class Student4 {
    private long id;
    private String firstName;
    private String lastName;

    // This time we use a no-arg constructor to initialize obj. state with our defaults, in case there was a need!
    // Again note that as soon as you define your first constructor, the default constructor is gone!
    // That might be one of the needs to define a no-arg constructor.
    public Student4() {
        id = 1;
        firstName = "Dongchan";
        lastName = "Oh";
    }

    // We also have any other constructor (with arguments) that we might need, as overloads to the above constructor
    // Below example is full constructor where all fields are defined using parameters
    public Student4(long id, String firstName, String lastName) {
        super();//Ignore this line for now, we'll talk more once we get into Inheritance!

        // Note the use of "this" here; one of the cases we have to use it!
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // We could even have a constructor which acts as a copy constructor if you will
    // 동일 Class의 object를 parameter로 받음으로서, C++의 "Copy constructor"처럼 동작
    public Student4(Student4 anotherStudent) {
        id = anotherStudent.id;
        this.firstName = anotherStudent.firstName;  // Optional use of "this" in here, although makes your code more clear!
        setLastName(anotherStudent.getLastName());  // Used to be best practice before, but not recently (at least inside a constructor)
    }

    // We could have a constructor with a special use of "this" (not used that much in practice anyways!)
    public Student4(int id){
        // In here, "this" means current constructor with arguments
        this(id, "Jordan", "Grey"); // Also pay attention to the up-casting!
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // We could also define a setter like below, which uses other setters:
    public void setStudent(long id, String firstName, String lastName){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    // And We could define a getter like below, if you need:
    public Student4 getStudent(){   //Pay attention to the the return type
        return this;
    }
}
