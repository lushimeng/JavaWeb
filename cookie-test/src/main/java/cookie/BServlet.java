package cookie; /**
 * @Author Mr.Lu
 * @Date 2022/7/29 10:00
 * @ClassName BServlet
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取Cookie
        Cookie[] cookies = request.getCookies();
        // 2. 遍历所有Cookie
        for(Cookie cookie : cookies){
            String key = cookie.getName();
            if("username".equals(key)){
                String value = cookie.getValue();  // 获取的是URL编码后的值 %E5%BC%A0%E4%B8%89
                value = URLDecoder.decode(value, "UTF-8");  // value解码后为 张三
                System.out.println(key + " : " + value);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
