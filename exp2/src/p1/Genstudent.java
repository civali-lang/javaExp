package p1;

public class Genstudent extends Student{
    public Genstudent(String studentID,String name,int age){
        super(studentID, name, age);
    }

    @Override
    public void study(){
        System.out.println(name+" is studying");
    }
}
