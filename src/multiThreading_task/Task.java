package multiThreading_task;

public class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ujjwal name is " + Thread.currentThread());

    }
}

//1. Create a class and implement Runnable
//2.always has to implement run method(mandatory)
//3. write down your task inside ur run method
//4. you have to create, object of your class which is implementing runnable.
//5. thread with my runnable in it and i will start it
