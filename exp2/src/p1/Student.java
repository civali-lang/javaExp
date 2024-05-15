package p1;

public abstract class Student {
    protected String studentID;
    protected String name;
    protected int age;

    public Student(String studentID,String name,int age){
        this.studentID=studentID;
        this.name=name;
        this.age=age;
    }

    public void eat(){
        System.out.println(name+" is eating.");
    }

    public abstract void study();
}
