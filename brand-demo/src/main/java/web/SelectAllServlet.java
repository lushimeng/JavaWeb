package web; /**
 * @Author Mr.Lu
 * @Date 2022/7/21 22:15
 * @ClassName ${NAME}
 * @Version 1.0
 */

import pojo.Brand;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建BrandService对象
        BrandService service = new BrandService();
        // 2. 调用BrandService完成查询
        List<Brand> brands = service.selectAll();
        // 3. 存入到request域中
        request.setAttribute("brands", brands);
        // 4. 转发到brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
