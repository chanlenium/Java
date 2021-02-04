package Student1;

// It is good to make only one Class for each Java file
public class Student1 {
    // if there is no access modifier, the default access modifier is set to be a 'package'
    // 동일 package안에서는 접근이 가능(단, Class가 private인 경우에는 불가)
    long id;
    String firstName;
    String lastName;

    public static void main(String[] args) {
        Student1 student1 = new Student1();
        // step.1) "Student1 student1" : declare reference variable 'student1' (Stack memory)
        // step.2) "new" : memory allocation for object (Heap memory)
        // step.3) "Student1()" : calling default constructor to initialize
        // Step.4) "=" : assigning the address of step2 to reference variable "student1"
        // => Constructor에 의해 heap memory에 할당된 object가 실질적인(actual) object임.
        // => student1은 actual object가 아니라 actual object를 가르키는 pointer임 (Just reference variable!!)

        System.out.println(student1.id);
        System.out.println(student1.firstName);
        System.out.println(student1.lastName);
        // new Student1() <= default constructor
        // Code 어디에도 default constructor에서 초기값을 선언하지 않았다면, 0, null 등의 초기값이 자동으로 할당
    }
}


//Although we could define several classes in the same .java file, it's better to define each class in a new file, not like below:

//class AnotherClass {
//	//...
//}
