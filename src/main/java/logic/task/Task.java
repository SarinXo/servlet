package logic.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Task {

    void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
