package p1;
import java.util.ArrayList;
import java.util.List;

public class Truck {
    private List<ComputeWeight> cws=new ArrayList<ComputeWeight>();
    public void addItem(ComputeWeight cw){
        cws.add(cw);
    }
    public double getTotalWeights(){
        double result=0.0;
        for(ComputeWeight cw:cws){
            result+=cw.computeWeight();
        }
        return result;
    }
}
