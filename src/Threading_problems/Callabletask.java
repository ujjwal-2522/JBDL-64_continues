package Threading_problems;

import java.util.concurrent.Callable;

public class Callabletask implements Callable {
    @Override
    public String call() throws Exception {
        return "I am inside call method with thread name:  " + Thread.currentThread().getName();
    }
}
