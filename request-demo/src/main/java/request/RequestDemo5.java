package request;
/**
 * @Author Mr.Lu
 * @Date 2022/6/18 21:35
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/req5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get请求方式获得请求参数信息
        String userNameBefore = request.getParameter("username");
        System.out.println("编码前：" + userNameBefore);
//        // 2. 编码
//        byte[] bytes = userNameBefore.getBytes(StandardCharsets.ISO_8859_1);  // 使用ISO-8859-1编码方式，因为Tomcat内置字符集为ISO-8859-1
//        // 3. 解码
//        String userNameAfter = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println("编码后：" + userNameAfter);

        // 该种方式对于Get 和 Post请求方式都适用
        String userNameAfter = new String(userNameBefore.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("编码后：" + userNameAfter);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
