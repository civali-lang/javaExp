package p1;

public class MonthWorker extends Employee{
    private double monthlySalary;
    public MonthWorker(double monthlySalary){
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double earnings(){
        return monthlySalary*12;
    }
}
