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
 * @ClassName ResponseDemo1
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1....");
        // 重定向
        // 1. 设置响应状态码
        resp.setStatus(302);
        // 2. 设置响应头 Location
        String contextPath = req.getContextPath();  // 获取虚拟目录(项目访问路径): `/request-demo`
        resp.setHeader("Location", contextPath + "/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
