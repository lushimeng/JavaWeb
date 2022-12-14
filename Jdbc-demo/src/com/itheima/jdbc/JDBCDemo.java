package com.itheima.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author Mr.Lu
 * @Date 2022/6/25 12:25
 * @ClassName JDBCDemo
 * @Version 1.0
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception{
        // 1. 注册驱动, 现在可有可无
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "select * from tb_user";
        // 4. 获取执行sql的对象 Statement
        Statement stmt = connection.createStatement();
        // 5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 6. 处理结果
        while (rs.next()){
            System.out.println(rs);
        }
        // 7. 释放资源
        stmt.close();
        connection.close();

    }

}
