package web; /**
 * @Author Mr.Lu
 * @Date 2022/7/22 21:22
 * @ClassName ${NAME}
 * @Version 1.0
 */

import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取id
        String id = request.getParameter("id");
        // 调用delete方法
        service.delete(Integer.parseInt(id));

        // 转发到查询你所有
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
