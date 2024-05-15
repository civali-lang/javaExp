package p1;
import java.util.*;
public class Company {
    private List<Employee> employees;
    public Company(){
        this.employees= new ArrayList<>();
    }
    public void add(Employee e){
        employees.add(e);
    }
    public double totalEarningsPerYear(){
        double total=0;
        for(Employee employee : employees){
            total+=employee.earnings();
        }
        return total;
    }
}
