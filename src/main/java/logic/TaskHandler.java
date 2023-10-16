package logic;

import logic.task.FastTask;
import logic.task.HeavyTask;
import logic.task.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskHandler {

    private final static Map<String, Task> TASKS = new HashMap<>();
    private static final int NUM_THREADS = Math.max(Runtime.getRuntime().availableProcessors() - 1, 1);
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    // надо думать как заполнять в динамике
    // xml config - под вопросом
    static {
        TASKS.put("GET/test/myServlet", new HeavyTask());
        TASKS.put("GET/test/myOtherServlet", new FastTask());
    }

    public static void redirect(HttpServletRequest request,
                                HttpServletResponse response) throws InterruptedException, IOException {
        Task task = getCurrentTask(request);
        EXECUTOR.execute(() -> {
            try {
                task.execute(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        response.getWriter().println("Ведется работа по вашему запросу. Ожидайте . . .");
    }

    private static Task getCurrentTask(HttpServletRequest request){
        return TASKS.get(request.getMethod() + request.getRequestURI());
    }

}
