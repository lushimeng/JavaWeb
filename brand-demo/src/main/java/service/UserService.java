package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import util.SqlSessionFactoryUtils;

/**
 * @Author Mr.Lu
 * @Date 2022/8/3 14:46
 * @ClassName UserService
 * @Version 1.0
 */
public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password){
        // 2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4. 调用方法
        User user = mapper.select(username, password);

        sqlSession.close();  // 释放资源
        return user;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    public boolean register(User user){
        // 2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. 判断用户是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if(u == null) {
            mapper.add(user);
            sqlSession.commit();  // 提交
        }
        sqlSession.close();  // 释放资源
        return u == null;
    }


}



















