package web; /**
 * @Author Mr.Lu
 * @Date 2022/6/19 12:28
 * @ClassName ${NAME}
 * @Version 1.0
 */

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;
import util.SqlSessionFactoryUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. 调用MyBatis
        // 2.1 获取SqlSessionFactory对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();   // 获取SqlSessionFactory对象， 用于产生SqlSession对象
        // 2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3 获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 2.4 调用方法
        User u = userMapper.selectByUsername(username);

        //设置响应的数据格式及数据的编码， 要不然不能正确解析html和解决中文乱码问题
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 3. 判断该用户是否存在数据库中
        if(u == null){  // 用户不存在
            // 封装User对象
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            // 调用add方法添加到数据库中
            userMapper.add(user);
            writer.write("注册成功！！！");
            // 提交事务
            sqlSession.commit();
        }else {
            // 用户名存在，给出提示信息
           writer.write("用户名已经存在，注册失败！！！");
        }

        // 释放资源
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
