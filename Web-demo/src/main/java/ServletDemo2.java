import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2" , loadOnStartup = -1)  //  loadOnstartup取值正整数: 服务器启动时创建Servlet对象，减少了客户端等待
public class ServletDemo2 implements Servlet{
    /**
     * 初始化方法
     * 1. 调用时机：默认情况下，Servlet被用户第一次访问的时候调用，但是可以在注解中加入loadOnStartup = 1表示在启动服务器的时候就进行初始化，这样可以减少客户端第一次请求的时间
     * 2. 调用次数： 1次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 提供服务
     * 1.调用时机:每一次Servlet被访问时，调用
     * 2.调用次数: 多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world2~~~");
    }

    /**
     * 销毁方法
     * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁、调用。
     * 2.调用次数: 1次
     * 注意：服务器关闭的时候不能强制关闭，可以在Terminal中运行mvn tomcat7:run, 然后crtl + 进行关闭
     *       这里要注意目录：D:\Java_Web\Web-demo> 要m在当前Web-demo目录下
     */
    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}

