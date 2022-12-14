import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * 目录匹配
 */
@WebServlet(urlPatterns = "/user/*")
public class ServletDemo8 extends MyHttpServlet{
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("get_demo8...");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {

    }
}
