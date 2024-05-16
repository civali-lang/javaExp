package p2;
import java.util.Scanner;

import p1.*;

public class Test {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Company company=new Company();
        Scanner sc=new Scanner(System.in);
        System.out.println("员工数量：");
        int n=sc.nextInt();
        while (n-->0) {
            System.out.println("薪水方式 薪水");
            String type = sc.next();
            int salary=sc.nextInt();
            if(type.equals("year")){
                company.add(new YearWorker(salary));
            }else if(type.equals("month")){
                company.add(new MonthWorker(salary));
            }else if(type.equals("week")){
                company.add(new WeekWorker(salary));
            }
        }
        
        System.out.println("Total earning per year is: "+company.totalEarningsPerYear());//公司一年需要支付的薪水
        sc.close();
    }
}
