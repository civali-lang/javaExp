package p2;

import java.util.Scanner;

import p1.*;

public class CheckCarWeight {
    public static void main(String[] args) {
        CheckCarWeight.test();
    }

    public static void test() {
        Truck truc = new Truck();
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入电视机,计算机,洗衣机的数量及其单件重量:(以空格分开)");
        int televisionCount = sc.nextInt();
        Television.weight = sc.nextDouble();
        while (televisionCount-- > 0) {
            truc.addItem(new Television());
        }

        int computerCount = sc.nextInt();
        Computer.weight = sc.nextDouble();
        while (computerCount-- > 0) {
            truc.addItem(new Computer());
        }

        int washMachineCount = sc.nextInt();
        WashMachine.weight = sc.nextDouble();
        while (washMachineCount-- > 0) {
            truc.addItem(new WashMachine());
        }
        System.out.println("火车装载的货物总重量:" + truc.getTotalWeights());
        sc.close();
    }
}
