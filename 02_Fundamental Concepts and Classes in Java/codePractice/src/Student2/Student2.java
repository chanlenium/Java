package Student2;

public class Student2 {
    // It is good to declare variable(fields) as "private"
    // but it is better to initialize variables using constructor
    private long id = 1;
    private String firstName = "Dongchan";
    private String lastName = "Oh";

    public static void main(String[] args) {
        // Using default constructor "Student2()"
        // note that obj. state is changed this time after its creation using the above values!
        // => default constructor를 통해 초기값이 0, null로 할당되었다가 위에서 정의한 값(1, "Dongchan", "Oh")으로 바뀜
        Student2 student1 = new Student2();

        //OK in the same class to access the private fields!
        System.out.println(student1.id);
        System.out.println(student1.firstName);
        System.out.println(student1.lastName);
    }
}
