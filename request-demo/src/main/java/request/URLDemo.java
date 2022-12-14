package request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Author Mr.Lu
 * @Date 2022/6/18 21:09
 * @ClassName request.URLDemo
 * @Version 1.0
 */
public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "张三";

        // 1. URL编码
        String encode = URLEncoder.encode(name, "UTF-8");  // 不可以换成ISO-8859-1编码，因为该编码不支持汉字，所以使用Unicode码表编码（统一码、万国马码）
        System.out.println(encode);  // %E5%BC%A0%E4%B8%89

        // 2. URL解码
        String decode = URLDecoder.decode(encode, "UTF-8");
        System.out.println(decode);  // 张三

        // 3. 转换为字节数据， 编码
        byte[] bytes = decode.getBytes();
        for( byte bt : bytes){
            System.out.print(bt + " ");  // -27 -68 -96 -28 -72 -119
        }

        // 4. 解码
        String s = new String(bytes, "UTF-8");
        System.out.println(s);  // 张三
    }
}





























































