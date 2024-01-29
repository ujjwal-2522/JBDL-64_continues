package multiThreading_task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class ClientFactorial {
    public static void main(String[] args) {
        Integer[] num={1,2,3,4,5,6,7,8,9,10};
        Integer[] num2={10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,110000,120000};
        List<Thread> list=new ArrayList<>();
        long start=System.currentTimeMillis();
//        Thread thread1=new Thread();
//        Thread thread2=new Thread();
        Arrays.stream(num2).forEach(i ->{
        FactorialMT factorialMT=new FactorialMT(i);
        Thread thread=new Thread(factorialMT);
        thread.start();
           list.add(thread);
        });
        list.stream().forEach(th->{
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long end=System.currentTimeMillis();
        System.out.println("time diff "+ (end-start));

    }
}
