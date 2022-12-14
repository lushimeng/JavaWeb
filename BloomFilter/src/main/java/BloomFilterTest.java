
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @Author Mr.Lu
 * @Date 2022/10/21 20:15
 * @ClassName BloomFilterTest
 * @Version 1.0
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        // 创建布隆过滤器
        BloomFilter<String> filter = BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()),
                1000,  // 数据量
                0.001);  // 误判率

        filter.put("www.baidu.com");
        filter.put("www.souhu.com");
        filter.put("www.google.com");

        System.out.println(filter.mightContain("www.google.com"));  // true
        System.out.println(filter.mightContain("www.zhihu.com"));   // false
    }
}
