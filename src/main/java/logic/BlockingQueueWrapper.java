package logic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

public class BlockingQueueWrapper {
    private static final BlockingQueue<FutureTask<String>> QUEUE
            = new ArrayBlockingQueue<>(500);

    private BlockingQueueWrapper(){}

    public static BlockingQueue<FutureTask<String>> getInstance(){
        return QUEUE;
    }
}
