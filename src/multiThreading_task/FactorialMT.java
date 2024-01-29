package multiThreading_task;

import java.math.BigInteger;

public class FactorialMT implements Runnable{
    private int num;

    public FactorialMT(int num){
        this.num=num;
    }

    @Override
    public void run() {
        BigInteger out=getFactorial();
        System.out.println("For num "+ this.num + "Factorial is "+ out +" with the Thread name is "+ Thread.currentThread().getName());
    }
    public BigInteger getFactorial(){
        BigInteger bigInteger=BigInteger.ONE;//== 1
        for (int i = 2; i <= this.num; i++) {
            bigInteger=bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;


    }

}
