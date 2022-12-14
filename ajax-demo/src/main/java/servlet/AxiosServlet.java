package servlet; /**
 * @Author Mr.Lu
 * @Date 2022/8/28 19:50
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/axiosServlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get...");
        // 1. 接收请求参数
        String username = request.getParameter("username");
        System.out.println(username);
        // 2. 响应数据
        PrintWriter writer = response.getWriter();
        writer.write("hello Axios!!!");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post....");
        this.doGet(request, response);
    }
}
