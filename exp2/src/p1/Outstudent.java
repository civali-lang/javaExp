package p1;

public class Outstudent extends Student{
    public Outstudent(String studentID,String name,int age){
        super(studentID, name, age);
    }

    @Override
    public void study(){
        System.out.println(name+" is studying hard.");
    }
}
