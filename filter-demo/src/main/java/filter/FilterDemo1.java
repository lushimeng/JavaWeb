package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author Mr.Lu
 * @Date 2022/8/27 15:35
 * @ClassName FilterDemo
 * @Version 1.0
 */

/**
 * Filter可以根据需求，配置不同的拦截资源路径@WebFilter("拦截路径")
 * > 拦截具体的资源: /index.jsp:只有访问index.jsp时才会被拦截。
 * > 目录拦截: /user/*:访问/user下的所有资源，都会被拦截
 * > 后缀名拦截: *.jsp:访问后缀名为jsp的资源，都会被拦截
 * > 拦截所有: /*:访问所有资源，都会被拦截
 */
@WebFilter("/*")  // 配置Filter拦截资源的路径：在类上定义@WebFilter
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1. 放行前， 对 request请求数据进行处理。
        System.out.println("2. FilterDemo...");

        // 放行
        chain.doFilter(request, response);

        // 2. 放行后， 对 response响应数据进行处理
        System.out.println("6. FilterDemo...");
    }

    @Override
    public void destroy() {

    }
}
