package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author Mr.Lu
 * @Date 2022/8/27 16:56
 * @ClassName ContextLoaderListener
 * @Version 1.0
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
