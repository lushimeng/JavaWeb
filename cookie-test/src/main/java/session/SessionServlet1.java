package session; /**
 * @Author Mr.Lu
 * @Date 2022/7/30 12:25
 * @ClassName SessionServlet1
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo1")
public class SessionServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 存储到Session中
        // 1. 获取Session对象
        HttpSession session = request.getSession();

        // 2. 存储数据
        session.setAttribute("username", "zs");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
