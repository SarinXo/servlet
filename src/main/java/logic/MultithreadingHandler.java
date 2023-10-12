package logic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadingHandler {

    private static final BlockingQueue<Future<?>> QUEUE
            = BlockingQueueWrapper.getInstance();

    private static int numThreads = 10;
    private static ExecutorService executor = Executors.newFixedThreadPool(numThreads);

    public void execute(){


    }
}
