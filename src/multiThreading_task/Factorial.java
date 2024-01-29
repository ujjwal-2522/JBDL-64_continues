package multiThreading_task;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Factorial {
    public static void main(String[] args) {

        Integer[] num={1,2,3,4,5,6,7,8,9,10};
        Integer[] num2={10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,110000,120000};
        long start = System.currentTimeMillis();
        Arrays.stream(num2).parallel().forEach(i->{
            BigInteger res=getFactorial(i);
            System.out.println("For num "+ i + "Factorial is "+ res +" with the Thread name is "+ Thread.currentThread());
        });
        long end = System.currentTimeMillis();
        System.out.println("time diff "+ (end-start));

    }
    public static BigInteger getFactorial(int num){
        BigInteger bigInteger=BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            bigInteger=bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;


    }
}
