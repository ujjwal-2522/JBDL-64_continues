package flight;

import java.util.List;

public interface FlightServices {
    List<FlightData> getFlights(String src,String dest);
}
