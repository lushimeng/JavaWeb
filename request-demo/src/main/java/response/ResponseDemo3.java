package response; /**
 * @Author Mr.Lu
 * @Date 2022/6/19 10:08
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("https://blog.csdn.net/qq_43751200/article/details/123483304");
        response.sendRedirect("/request-demo/req1");  // 可以重定向到任何位置的资源(服务内部，外部均可)
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
