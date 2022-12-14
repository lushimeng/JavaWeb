package web.filter; /**
 * @Author Mr.Lu
 * @Date 2022/8/27 16:27
 * @ClassName ${NAME}
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 强制转换，
        HttpServletRequest req = (HttpServletRequest) request;

        // 判断访问资源路径是否和登录注册相关
        String[] urls = {"login.jsp", "loginServlet", "checkCodeServlet", "register.jsp", "registerServlet", "/imgs/", "/css/"};

        String url = req.getRequestURL().toString();

        for (String u : urls) {
            if(url.contains(u)){  // 如果访问的路径包含所需的资源，则需要进行放行
                chain.doFilter(request,response);  // 放行
                return;
            }
        }

        // 1. 判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        // 2. 判断user 是否为 null
        if(user != null){
            // 登录成功
            // 放行
            chain.doFilter(request, response);
        }else {
            // 没有登录
            req.setAttribute("login_msg", "你尚未登录~");
            req.getRequestDispatcher("/login.jsp").forward(req, response);
        }
    }
}
