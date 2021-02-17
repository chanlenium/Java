package Student1;

public class Student1_Tester {
    // has package access to Student1 because they are in the same folder!
    // and Student1 Class is declared as public

    public static void main(String[] args) {
        // This class not only has access to class Student1 and could make an obj. ...
        Student1 student1 = new Student1();

        // but also has access to its fields/properties and could set the state of the obj.,
        // or get it which is almost always not desirable!
        student1.id = 10;
        // Student1의 field "id"가 package(default)로 선언되어 있기 때문에 접근가능
        // => Studnet1 Class 외부에서 filed에 접근이 가능하다는 것은 security 측면에서 좋지 않음
        System.out.println(student1.id);
    }
}
