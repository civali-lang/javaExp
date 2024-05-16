package p1;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students=new ArrayList<Student>();
    public void addStudent(Student student){
        students.add(student);
    }
    public void displayStudents(){
        for(Student student : students){
            if(student != null){
                System.out.println("ID: "+student.studentID+", Name: "+student.name+", Age: "+student.age);
                student.eat();
                student.study();
                
            }
        }
    }
}
