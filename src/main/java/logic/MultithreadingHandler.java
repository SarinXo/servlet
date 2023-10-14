package logic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MultithreadingHandler {

    private static final BlockingQueue<FutureTask<Void>> QUEUE
            = BlockingQueueWrapper.getInstance();

    private static int numThreads = 10;
    private static ExecutorService executor = Executors.newFixedThreadPool(numThreads);

    public void execute(){


    }
}
