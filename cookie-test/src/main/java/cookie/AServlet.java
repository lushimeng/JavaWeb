package cookie; /**
 * @Author Mr.Lu
 * @Date 2022/7/29 9:48
 * @ClassName AServlet
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送Cookie
        // 1. 创建Cookie对象
        String value = "张三";
        value = URLEncoder.encode(value, "UTF-8"); // 对中文进行URL编码
        System.out.println("存储数据value : " + value);
        Cookie cookie = new Cookie("username", value);
        // 设置存货时间， 1周7天, 以秒为单位
        cookie.setMaxAge(7 * 24 * 60 * 60);  // 易阅读，需程序计算

        // 2. 发送Cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

