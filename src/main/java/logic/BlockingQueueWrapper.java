package logic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public class BlockingQueueWrapper {
    private static final BlockingQueue<Future<?>> QUEUE
            = new ArrayBlockingQueue<>(500);

    private BlockingQueueWrapper(){}

    public static BlockingQueue<Future<?>> getInstance(){
        return QUEUE;
    }
}
