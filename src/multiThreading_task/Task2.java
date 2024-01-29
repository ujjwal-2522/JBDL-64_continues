package multiThreading_task;
// second method
public class Task2 extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ujjwal with thread name "+ Thread.currentThread());
    }
}

//1. Create a class and extend thread class
//2. it will not ask to implement any method becoz thread is a concrete class
//3. override the run method and provide everything u need to excute inside run method
//4. create object of task (class) in which u have defined the run method
//5. start the thread with start method