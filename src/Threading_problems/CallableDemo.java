package Threading_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callabletask callabletask=new Callabletask();
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        Future<String> f=null;
        List<Future<String>> list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(executorService.submit(callabletask));// Blocking code or not??

        }
        list.stream().forEach(str-> {
            try {
                System.out.println(str.get());// this is blocking code
            } catch (InterruptedException e) {

            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
