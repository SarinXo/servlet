package logic.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FastTask implements Task{
    @Override
    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        response.getWriter()
                .println(
                    String.format("FastTask with id thread "
                            + Thread.currentThread().getName()
                            + " was successfully done!")
                );
    }
}
