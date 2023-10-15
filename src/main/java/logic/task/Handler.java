package logic.task;

import logic.BlockingQueueWrapper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Handler {

    private static final BlockingQueue<Runnable> QUEUE = BlockingQueueWrapper.getInstance();
    private static final int NUM_THREADS = Math.max(Runtime.getRuntime().availableProcessors() - 1, 1);
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    public static void doTask() throws InterruptedException {

        while(!QUEUE.isEmpty()) {
            EXECUTOR.execute(() -> {
                try {
                    QUEUE.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        Thread.currentThread().wait();
    }
}
