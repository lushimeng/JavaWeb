package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Mr.Lu
 * @Date 2022/6/19 10:00
 * @ClassName ResponseDemo2
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/resp2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp2...");
//        String contextPath = req.getContextPath();  // 获取虚拟目录(项目访问路径): `/request-demo`
//        resp.sendRedirect(contextPath + "/resp3");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
