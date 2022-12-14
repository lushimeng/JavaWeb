import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/Web-demo/demo6
 * http://localhost:8080/Web-demo/demo66
 * http://localhost:8080/Web-demo/demo6_6
 * 都可以访问ServletDemo6
 */
@WebServlet(urlPatterns = {"/demo6", "/demo66", "/demo6_6"})
public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get6....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("");
    }
}
