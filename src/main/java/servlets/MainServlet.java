package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static logic.TaskHandler.redirect;


@WebServlet(name = "MainServlet", urlPatterns = "/my-servlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        try {
            redirect(request, response);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}