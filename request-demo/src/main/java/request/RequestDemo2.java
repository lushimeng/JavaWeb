package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/req2")
public class RequestDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取username
        String username = req.getParameter("username");
        System.out.println("解决乱码前 : " + username);


        // 乱码原因：tomcat进行URL解码，默认的字符集ISO-8859-1
        // 2. 先对乱码数据进行编码：转为字节数组
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        // 字节数组解码
        String targetUserName = new String(bytes, "UTF-8");
//        String targetUserName = new String(username.getBytes(StandardCharsets.ISO_8859_1), "UTF-8");   // 上面两句可以合成一句
        System.out.println("解决乱码后 : " + targetUserName);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
