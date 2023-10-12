package logic;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class SimpleTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        return  String.format(
                "Task executed successfully: "
                + Thread.currentThread().getName());
    }
}
