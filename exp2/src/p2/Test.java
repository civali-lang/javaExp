package p2;
import java.util.Scanner;

import p1.*;
public class Test {
    public void run(){
        School school = new School();
        Scanner sc=new Scanner(System.in);
        System.out.println("你要输入几个学生信息：");
        int n = sc.nextInt();
        while (n-- > 0) {
            System.out.println("输入 学号 姓名 年龄 是不是好学生");
            String studentID,name;
            int age;
            boolean isGood;
            studentID=sc.next();
            name=sc.next();
            age=sc.nextInt();
            isGood=sc.nextBoolean();
            school.addStudent(isGood ? new Outstudent(studentID, name, age):new Genstudent(studentID, name, age));
        }
        school.displayStudents();
        sc.close();
    }
}
