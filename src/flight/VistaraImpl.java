package flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VistaraImpl implements FlightServices{

    @Override
    public List<FlightData> getFlights(String src, String dest) {

        //they will be calling third party APIs to get all the schedule
        //i am not able to make a third party call
        // list which at the end should be returned
        List<FlightData> list=new ArrayList<>();
        list.add(new FlightData(src,dest,100,new Date(),"Vistara",1));
        list.add(new FlightData(src,dest,200,new Date(),"Vistara",2));
        list.add(new FlightData(src,dest,300,new Date(),"Vistara",3));
        list.add(new FlightData(src,dest,400,new Date(),"Vistara",4));
        list.add(new FlightData(src,dest,500,new Date(),"Vistara",5));
        list.add(new FlightData(src,dest,600,new Date(),"Vistara",6));
        return list;
        //empty list while logging the error
        // retry mechanism in case of some cretain errors
        //null
    }
}
