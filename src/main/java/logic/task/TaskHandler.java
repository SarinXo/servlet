package logic.task;

import logic.BlockingQueueWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TaskHandler {

    private final static Map<String, Task> TASKS = new HashMap<>();

    private final static BlockingQueue<FutureTask<Void>> QUEUE = BlockingQueueWrapper.getInstance();

    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors() - 1;

    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    // надо думать как заполнять в динамике
    // xml config - под вопросом
    static {
        TASKS.put("GET/myServlet", new HeavyTask());
        TASKS.put("GET/myOtherServlet", new FastTask());
    }

    private static Task getCurrentTask(HttpServletRequest request){
        return TASKS.get(request.getMethod() + request.getPathInfo());
    }

    public void execute(HttpServletRequest request, HttpServletResponse response){
        Task task = getCurrentTask(request);

    }


}
