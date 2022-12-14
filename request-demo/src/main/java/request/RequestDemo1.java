package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

// 浏览器中输入：http://localhost:8080/request-demo/req1?username=lushimeng&password=123456
@WebServlet(urlPatterns = "/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 获取请求行方式
//        // 1. 获取请求方式
//        String method = req.getMethod();
//        System.out.println(method);  //  GET
//
//        // 2. 获取虚拟目录(项目访问路径):
//        String contextPath = req.getContextPath();
//        System.out.println(contextPath);  //  /request-demo
//
//        // 3. 获取URL(统一资源定位符)
//        StringBuffer requestURL = req.getRequestURL();
//        System.out.println(requestURL.toString());  //  http://localhost:8080http://localhost:8080/request-demo/req1
//
//        // 4. 获取URI(统一资源标识符)
//        String requestURI = req.getRequestURI();
//        System.out.println(requestURI);  //  /request-demo/req1
//
//        // 5. 获取请求参数(GET方式)
//        String param = req.getQueryString();
//        System.out.println(param);  // username=lushimeng&password=123456
//
////        System.out.println("---------------------------------------------------------");
        // 获取请求头方式: key - value形式, 可以在浏览器中按F12进行查看
        String agent = req.getHeader("User-Agent");
        System.out.println("User-Agent : " + agent);  // User-Agent : Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36
        String connection = req.getHeader("Connection");
        System.out.println("Connection : " + connection);  // Connection : keep-alive
        String host = req.getHeader("Host");
        System.out.println("Host : " + host);  // Host : localhost:8080
        String platform = req.getHeader("sec-ch-ua-platform");
        System.out.println("sec-ch-ua-platform : " + platform);  // sec-ch-ua-platform : "Windows"
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取post请求体参数
        BufferedReader reader = req.getReader();
        // 2. 读取数据
        String param = reader.readLine();
        System.out.println(param);   // username=lushimeng&password=123456
    }
}
