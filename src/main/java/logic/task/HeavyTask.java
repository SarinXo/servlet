package logic.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class HeavyTask implements Task{

    @Override
    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        TimeUnit.SECONDS.sleep(3);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        response.getWriter()
                .println(
                        String.format(
                                "HeavyTask with id thread "
                                + Thread.currentThread().getName()
                                + " was successfully done!")
                );
    }

}
