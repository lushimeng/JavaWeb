import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * 目录匹配
 * 1. 如果路径配置的不是扩展名，那么在路径的前面就必须要加`/`, 否则会报错
 * 2. 如果路径配置的是`*.do`,那么在*.do的前面不能加`/`, 否则会报错
 */
@WebServlet(urlPatterns = "*.do")
public class ServletDemo9 extends MyHttpServlet{
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("get_demo9...");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {

    }
}
