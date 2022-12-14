import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/")
//@WebServlet(urlPatterns = "/*")
public class ServletDemo10 extends MyHttpServlet{
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("get_demo10...");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {

    }
}
