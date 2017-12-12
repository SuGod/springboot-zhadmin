package cn.zzdee.zhadmin.mapper;

import cn.zzdee.zhadmin.entity.User;
import cn.zzdee.zhadmin.common.enums.Sex;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 这里有两种方式注入 mapper 1.在每个mapper类上注解 @mapper     2.在启动类上注解 @mapperScan("package-path") 启动时会自动扫描 这个包下所有的mapper
 */


public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "sex", column = "sex", javaType = Sex.class)
    })
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "sex", column = "sex", javaType = Sex.class)
    })
    User findOne(@Param("id") Integer id);  //只有一个参数时 可以不写@param 多个参数时 不写 @param("") sql语句应该按照索引顺序写参数

    @Insert("INSERT INTO user(username,password,sex,age) VALUES(#{username}, #{password}, #{sex}, #{age})")
    void insert(User user);

    @Update("UPDATE user SET username=#{username},nickname=#{nickname} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Integer id);


}
