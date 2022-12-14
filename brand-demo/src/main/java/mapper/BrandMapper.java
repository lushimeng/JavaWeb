package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Brand;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/7/21 22:00
 * @ClassName BrandMapper
 * @Version 1.0
 */
public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")  // 使用注解写sql语句
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加商品信息
     * @param brand
     */
    @Insert("insert into tb_brand values(null, #{brandName},  #{companyName},  #{ordered},  #{description},  #{status}) ")
    @ResultMap("brandResultMap")
    void add(Brand brand);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);


    @Update("update tb_brand set brand_name = #{brandName}, company_name = #{companyName}, ordered = #{ordered}, description = #{description}, status = #{status} where id = #{id} ")
    @ResultMap("brandResultMap")
    void update(Brand brand);



    @Delete("delete from tb_brand where id = #{id}")
    void delete(int id);

}
