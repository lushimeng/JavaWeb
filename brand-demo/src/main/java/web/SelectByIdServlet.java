package web; /**
 * @Author Mr.Lu
 * @Date 2022/7/22 20:43
 * @ClassName ${NAME}
 * @Version 1.0
 */

import pojo.Brand;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandService service = new BrandService();
        // 1. 接收id
        String id = request.getParameter("id");
        // 2. 调用service查询
        Brand brand = service.selectById(Integer.parseInt(id));
        // 3. 存储到request中
        request.setAttribute("brand", brand);
        // 4. 转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
