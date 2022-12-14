package service;

import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import util.SqlSessionFactoryUtils;
import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/7/21 22:10
 * @ClassName BrandService
 * @Version 1.0
 */

public class BrandService {
    // 1. 获取数据库连接池
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll(){
        // 2. 获取selSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close(); // 关系sqlSession

        return brands;
    }


    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){
        // 2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        mapper.add(brand);
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    public Brand selectById(int id){
        // 2. h获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    /**
     * 根据id对内容进行修改
     * @param brand
     */
    public void update(Brand brand){
        // 1. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3. 调用方法
        mapper.update(brand);
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

    }

    /**
     * 根据id对内容进行删除
     * @param id
     */
    public void delete(int id){
        // 2. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 调用delete方法
        mapper.delete(id);

        // 提交事务
        sqlSession.commit();
        // 关闭sqlSession
        sqlSession.close();
    }
}
