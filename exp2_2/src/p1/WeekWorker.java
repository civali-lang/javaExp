package p1;

public class WeekWorker extends Employee{
    private double weeklySalary;
    public WeekWorker(double weeklySalary){
        this.weeklySalary=weeklySalary;
    }
    @Override
    public double earnings(){
        return weeklySalary*52;
    }
}
