package servlet; /**
 * @Author Mr.Lu
 * @Date 2022/8/28 16:21
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收用户名
        String username = request.getParameter("username");

        // 2. 调用service方法查询User对象，模拟
        boolean flag = true;

        // 3. 响应标记
        PrintWriter writer = response.getWriter();
        writer.write("" + flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
