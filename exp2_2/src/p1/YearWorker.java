package p1;

public class YearWorker extends Employee{
    private double annualSalary;
    public YearWorker(double annualSalary){
        this.annualSalary=annualSalary;
    }
    @Override
    public double earnings(){
        return annualSalary;
    }
}
