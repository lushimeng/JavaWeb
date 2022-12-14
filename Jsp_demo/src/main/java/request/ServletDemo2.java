package request; /**
 * @Author Mr.Lu
 * @Date 2022/7/3 17:53
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 存储数据到request域中
        request.setAttribute("status", 1);

        // 2. 转发到 jstl-if.jsp
        request.getRequestDispatcher("/jstl-if.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
