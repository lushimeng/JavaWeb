package request;
/**
 * @Author Mr.Lu
 * @Date 2022/7/2 15:02
 * @ClassName ${NAME}
 * @Version 1.0
 */

import pojo.Brand;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/demo1")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 准备数据
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));

        // 2.  存储到request域中
        request.setAttribute("brands", brands);

        // 3. 转发到 el-demo.jsp中
        request.getRequestDispatcher("/jstl-forEach2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
