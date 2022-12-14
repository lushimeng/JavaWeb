import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo11 extends MyHttpServlet{
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("get_demo11...");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("post_demo11...");
    }
}
