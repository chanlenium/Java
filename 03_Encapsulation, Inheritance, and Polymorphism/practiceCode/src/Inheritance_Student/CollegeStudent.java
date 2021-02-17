package Inheritance_Student;

public class CollegeStudent extends Student{
    private String collegeName;

    public static void main(String[] args) {
        CollegeStudent collegeStudent1 = new CollegeStudent();
        // subClass의 no-arg constructor가 실행될때
        // super class의 no-arg constructor가 자동으로 시행되는데
        // super class(Student class)에 no-arg constructor가 정의되어 있지 않으면 에러 발생
    }
}
