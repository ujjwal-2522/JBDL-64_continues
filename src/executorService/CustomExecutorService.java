package executorService;



import java.util.concurrent.*;

public class CustomExecutorService {
    public static void main(String[] args) throws InterruptedException {
        int corePoolSize=4;
        int maxPoolSize=8;
        //custom Thread Pool
        //predefined method is best for your case-> you can use any predefined
        //custom thread pool

        // Total min Task=corePoolSize(4) + Blockingqueuecapacity(5)=9
        //Total max Task=maxPoolSize(8) + Blockingqueuecapacity(5)=13
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(corePoolSize,maxPoolSize,60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>()); //Now task will not be rejected since Linked
         //list does not have Size depend on memory to get full// ArrayBlockingQueue<>(5));
        Task task=new Task();
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(task);
        }
        threadPoolExecutor.shutdown();
        //main thread waiting for going to the next line
        threadPoolExecutor.awaitTermination(10,TimeUnit.MINUTES);
        // await termination says,it will wait at max for 60 sec, and then only it will go to next line
        //executor service is not able to do all task in 60 sec ,it will just move to next line
        //executor service is able to do all task before 30 sec ,after 30 sec it will just move to next line
        System.out.println("i am at the last line ");

        ScheduledExecutorService service=Executors.newScheduledThreadPool(2);
        service.schedule(task,60,TimeUnit.SECONDS);
        service.shutdown();

    }
}
