package response; /**
 * @Author Mr.Lu
 * @Date 2022/6/19 11:02
 * @ClassName ${NAME}
 * @Version 1.0
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 读取文件
        FileInputStream fis = new FileInputStream("D:\\javaAPI_picture\\5.jpg");

        // 2. 获取response字节输出流
        ServletOutputStream os = response.getOutputStream();  // 系统自动释放资源

        // 3. 完成流的copy
        IOUtils.copy(fis, os);

        fis.close();  // 关闭流
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
