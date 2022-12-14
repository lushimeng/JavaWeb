package web; /**
 * @Author Mr.Lu
 * @Date 2022/8/4 11:52
 * @ClassName ${NAME}
 * @Version 1.0
 */

import pojo.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service  = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. 封装成一个User对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        // 程序生成的验证码， 从Session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String)session.getAttribute("checkCodeGen");

        // 比对不一致，不允许比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        // 3. 调用UserService类中的方法
        boolean register = service.register(user);

        if(register){
            // 注册成功
            request.setAttribute("register_msg", "注册成功， 请登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            // 注册失败
            request.setAttribute("register_msg", "用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
