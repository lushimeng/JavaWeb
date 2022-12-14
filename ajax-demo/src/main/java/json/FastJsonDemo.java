package json;

import com.alibaba.fastjson.JSON;

/**
 * @Author Mr.Lu
 * @Date 2022/8/28 20:55
 * @ClassName FastJsonDemo
 * @Version 1.0
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        // 1. 将Java对象转为JSON字符串
        User user = new User();
        user.setId(100);
        user.setUsername("lushimeng");
        user.setPassword("123456");

        String json = JSON.toJSONString(user);
        System.out.println(json);  //  {"id":100,"password":"123456","username":"lushimeng"}

        // 2. 将JSON对象转化为Java对象
        User user1 = JSON.parseObject("{\"id\":100,\"password\":\"123456\",\"username\":\"lushimeng\"}", User.class);
        System.out.println(user1);


    }
}
