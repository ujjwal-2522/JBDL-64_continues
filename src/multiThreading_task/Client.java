package multiThreading_task;

public class Client {
    //parallelism task 1 and taks 2 since i have core-10.
    public static void main(String[] args) throws InterruptedException {
        Task task=new Task();
        Thread thread =new Thread(task);
        thread.start() ;

        //2nd method to start thread without Runnable
        Task2 task2=new Task2();
        task2.start();
        task2.join();
        thread.join();
        System.out.println("Thread name is " + Thread.currentThread());

    }
}
