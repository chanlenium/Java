package Student2;

public class Student2_Tester {
    public static void main(String[] args) {
        //This class has access to class Student2 and could create an obj. (i.e., new Student2())
        Student2 student1 = new Student2();

        // but this time it doesn't have direct access to its fields/properties which is almost always desirable!
        // Student1 Class의 field "id"가 private로 선언되었기 때문
        //student1.id = 10;
        //System.out.println(student1.id);

    }
}
