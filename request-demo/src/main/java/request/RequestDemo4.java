package request; /**
 * @Author Mr.Lu
 * @Date 2022/6/15 22:35
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * post请求方式解决乱码问题
 */
@WebServlet(urlPatterns = "/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");  //  post请求方式解决乱码问题
        // 1. 获取所有参数的Map集合
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.print(key + " : ");

            for (String s : map.get(key)) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
        // 2. 根据名称获取参数值(数组)
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        System.out.println("--------------------");
        // 3. 根据名称获取参数值
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
