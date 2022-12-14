package response;
/**
 * @Author Mr.Lu
 * @Date 2022/6/19 10:42
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //   // 可以使用该行统一进行设置content-type, 在其中顺便设置编码为utf-8方式，因为ISO-8859-1字符集不支持中文
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("你好啊！！！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
