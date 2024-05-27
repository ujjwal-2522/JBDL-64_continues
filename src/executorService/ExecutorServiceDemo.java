package executorService;


import multiThreading_task.FactorialMT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();//create 1 thread at a time//newFixedThreadPool(4);
        Task task=new Task();
        //you cannot join Main Thread with the other thread.

//        Thread t =new Thread(task); NOT USE OF EXECUTOR SERVICES
//        Thread t1=new Thread(task);
//        t.start();
//        t1.start();
        for (int i = 0; i < 20; i++) {//20 task
            System.out.println("I am in main method with thread name: "+ Thread.currentThread().getName());//This is done by Main Thread
            executorService.submit(task);//This is done by the Thread pool
        }
        System.out.println("I am out of main method with thread name: "+ Thread.currentThread().getName());
        //Thread will be running since 4 threads are active

        FactorialMT factorialMT=new FactorialMT(2);
        executorService.submit(factorialMT);
        executorService.shutdown(); //signal which will go to my executor services, that
        //executor service should not take more task after this.
        Thread.sleep(100);
//        executorService.shutdownNow();//It will shut down the executor service at the same time.
        //when it got this command
        executorService.submit(task);// since shutdown is provided now this task will not executed
    }
}
