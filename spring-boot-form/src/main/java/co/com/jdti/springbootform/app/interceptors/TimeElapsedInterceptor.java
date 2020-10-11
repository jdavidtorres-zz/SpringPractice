package co.com.jdti.springbootform.app.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Component
public class TimeElapsedInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TimeElapsedInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("TimeElapsedInterceptor: preHandle() START");
        long time = System.currentTimeMillis();
        request.setAttribute("time", time);
        Random random = new Random();
        Integer waiting = random.nextInt(500);
        Thread.sleep(waiting);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long time = System.currentTimeMillis();
        long initTime = (Long) request.getAttribute("time");
        long timeElapsed = time - initTime;
        if (modelAndView != null && handler instanceof HandlerInterceptor) {
            modelAndView.addObject("timeElapsed", timeElapsed);
        }
        logger.info("Time elapsed: " + timeElapsed + "ms");
        logger.info("TimeElapsedInterceptor: postHandle() END");
    }
}
