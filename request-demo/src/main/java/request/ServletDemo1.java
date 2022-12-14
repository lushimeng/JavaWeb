package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Mr.Lu
 * @Date 2022/6/19 16:46
 * @ClassName ServletDemo1
 * @Version 1.0
 */

@WebServlet(urlPatterns = "/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 使用request对象 获取请求数据
        String username = req.getParameter("username");

        // 2. 使用response对象 设置响应数据
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("<h1>" + username +", 欢迎你！</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
    }
}
