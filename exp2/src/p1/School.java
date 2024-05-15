package p1;

public class School {
    Student[] s;
    int NumOfStu;
    public School(int capacity){
        s=new Student[capacity];
        NumOfStu=0;
    }
    public void addStudent(Student student){
        if(NumOfStu>=s.length){
            System.out.println("undercapacity!!!");
            return;
        }
        s[NumOfStu++]=student;
    }
    public void displayStudents(){
        for(Student student : s){
            if(student != null){
                System.out.println("ID: "+student.studentID+", Name: "+student.name+", Age: "+student.age);
                student.eat();
                student.study();
                
            }
        }
    }
}
