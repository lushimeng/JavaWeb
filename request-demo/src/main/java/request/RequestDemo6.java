package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Mr.Lu
 * @Date 2022/6/18 21:58
 * @ClassName request.RequestDemo6
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/req6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo6...");
        req.setAttribute("msg", "日志信息");

        // 重定向, 特别注意资源路径
        req.getRequestDispatcher("/req7").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
