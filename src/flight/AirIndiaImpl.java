package flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirIndiaImpl implements FlightServices{

    @Override
    public List<FlightData> getFlights(String src, String dest) {

        //they will be calling third party APIs to get all the schedule
        //i am not able to make a third party call
        // list which at the end should be returned
        List<FlightData> list=new ArrayList<>();
        list.add(new FlightData(src,dest,100,new Date(),"AirIndia",1));
        list.add(new FlightData(src,dest,200,new Date(),"AirIndia",2));
        list.add(new FlightData(src,dest,300,new Date(),"AirIndia",3));
        list.add(new FlightData(src,dest,400,new Date(),"AirIndia",4));
        list.add(new FlightData(src,dest,500,new Date(),"AirIndia",5));
        list.add(new FlightData(src,dest,600,new Date(),"AirIndia",6));
        return list;
    }
}
