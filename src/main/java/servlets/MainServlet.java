package servlets;

import logic.BlockingQueueWrapper;
import logic.SimpleTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "MainServlet", urlPatterns = "/my-servlet")
public class MainServlet extends HttpServlet {

    private static final BlockingQueue<FutureTask<String>> QUEUE
            = BlockingQueueWrapper.getInstance();

    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors() - 1;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    @Override
    public void init() throws ServletException {
        Thread t = new Thread(() ->
        {
            try {
                doTask();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        FutureTask<String> future =
                new FutureTask<>(new SimpleTask());
        QUEUE.add(future);

        response.getWriter().println("Ваш запрос был передан. Ведется работа, ожидайте . . .");
    }

    private String doTask() throws InterruptedException {
        while(true){
            if(QUEUE.isEmpty())
                TimeUnit.SECONDS.sleep(1);
            else{
                FutureTask<String> future = QUEUE.take();
                EXECUTOR.execute(future);
            }
        }
    }

}
