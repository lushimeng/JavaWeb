package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * request 通用方式获取请求参数
 */
@WebServlet(urlPatterns = "/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        Set<String> keys = map.keySet();  // 获取键的集合
        for(String key : keys){
            System.out.print(key + " : ");
            String[] stringValues = map.get(key);  // 根据key获取对应的value
            for(String str : stringValues){
                System.out.print(str + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------");
        // 2. 根据名称获取参数值(数组)
        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby : hobbies){
            System.out.println(hobby);  // 1, 2
        }

        System.out.println("--------------------");
        // 3. 根据名称获取参数值
        String username = req.getParameter("username");
        System.out.println("username : " + username);  // username : lushimeng
        String password = req.getParameter("password");
        System.out.println("password : " + password);  // password : 123456

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
