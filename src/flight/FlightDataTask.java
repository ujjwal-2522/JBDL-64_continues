package flight;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class FlightDataTask implements Callable<List<FlightData>> {

    private FlightServices flightServices;

    private String src;

    private String dest;

    public FlightDataTask(FlightServices flightServices, String src, String dest) {
        this.flightServices = flightServices;
        this.src = src;
        this.dest = dest;
    }

    @Override
    public List<FlightData> call() throws Exception {
        // I am expected to call the getFlight(src,dest)
        return flightServices.getFlights(src,dest);
    }
}
