package logic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueWrapper {
    private static final BlockingQueue<Runnable> QUEUE
            = new ArrayBlockingQueue<>(500);

    private BlockingQueueWrapper(){}

    public static BlockingQueue<Runnable> getInstance(){
        return QUEUE;
    }
}
