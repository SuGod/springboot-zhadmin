package cn.zzdee.zhadmin.dao;

import cn.zzdee.zhadmin.entity.User;
import cn.zzdee.zhadmin.common.enums.Sex;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.Java8TypeHandlersRegistrar;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.StringTypeHandler;

import java.util.List;

/**
 * 这里有两种方式注入 dao 1.在每个mapper类上注解 @dao     2.在启动类上注解 @mapperScan("package-path") 启动时会自动扫描 这个包下所有的mapper
 */


public interface UserDao {

    /**
     * 为了演示@resultMap的用法,这里故意把数据库字段命名为 _ 方式,entity 为驼峰命名.
     *
     * 使用@Results 映射entity和数据库表字段 给Id 复用.
     * @return
     */

    @Select("SELECT * FROM user")
    @Results(id = "userMapper",
            value = {
            @Result(property = "username", column = "user_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "password" ,column = "pass_word",jdbcType = JdbcType.VARCHAR),
            @Result(property = "nickname" ,column = "nick_name",jdbcType = JdbcType.VARCHAR)
    })
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @ResultMap("userMapper")
    User findOne(@Param("id") Integer id);  //只有一个参数时 可以不写@param 多个参数时 不写 @param("") sql语句应该按照索引顺序写参数

    @Insert("INSERT INTO user(user_name,pass_word,nick_name,sex,age) VALUES(#{username}, #{password},#{nickname}, #{sex}, #{age})")
    void insert(User user);

    @Update("UPDATE user SET user_name=#{username},nick_name=#{nickname},sex=#{sex},age=#{age}  WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Integer id);


}
