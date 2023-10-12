package servlets;

import logic.BlockingQueueWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

@WebServlet(name = "MainServlet", urlPatterns = "/my-servlet")
public class MainServlet extends HttpServlet {

    private static final BlockingQueue<Future<?>> QUEUE
            = BlockingQueueWrapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println("Jojo");
    }

}
