package flight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FlightClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<FlightServices> list=new ArrayList<>();
        list.add(new AirIndiaImpl());
        list.add(new IndigoImpl());
        list.add(new VistaraImpl());
        long start=System.currentTimeMillis();
        FlightDataTask flightDataTask1=new FlightDataTask(new AirIndiaImpl(),"Delhi","goa");
        FlightDataTask flightDataTask2=new FlightDataTask(new VistaraImpl(),"Delhi","goa");
        FlightDataTask flightDataTask3=new FlightDataTask(new IndigoImpl(),"Delhi","goa");
        ExecutorService executorService= Executors.newFixedThreadPool(list.size());
        List<FlightDataTask> listOfCalable=new ArrayList<>();
        listOfCalable.add(flightDataTask1);
        listOfCalable.add(flightDataTask2);
        listOfCalable.add(flightDataTask3);
        List<Future<List<FlightData>>> fdata1=executorService.invokeAll(listOfCalable);
//        Future<List<FlightData>> Fdata1=executorService.submit(flightDataTask1);
//        Future<List<FlightData>> Fdata2=executorService.submit(flightDataTask2);
//        Future<List<FlightData>> Fdata3=executorService.submit(flightDataTask3);

        List<List<FlightData>> lists=new ArrayList<>();
//        lists.add(Fdata1.get());
//        //Blocking call
//        lists.add(Fdata2.get());
//        lists.add(Fdata3.get());

        for (List<FlightData> l :lists){
            for (FlightData flightData : l){
                System.out.println(flightData);
            }
        }
        long end=System.currentTimeMillis();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        // So that 1 thread will wait for other thread.
        System.out.println("Total time took is :" + (end-start));


    }
}
