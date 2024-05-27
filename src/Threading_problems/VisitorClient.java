package Threading_problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VisitorClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        VisitorCountTask visitorCountTask=new VisitorCountTask();
        long start=System.currentTimeMillis();
        for (int i = 0; i < 2000000 ; i++) {
            executorService.submit(visitorCountTask);
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println(" total number of visitor are :" + visitorCountTask.getVisitor());
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
