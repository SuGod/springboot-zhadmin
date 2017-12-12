package cn.zzdee.zhadmin.testMapper;


import cn.zzdee.zhadmin.entity.User;
import cn.zzdee.zhadmin.common.enums.Sex;
import cn.zzdee.zhadmin.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {



    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception{
        userMapper.insert(new User("zhangsan","123456","张三",20, Sex.MAN ));
        userMapper.insert(new User("lisi","123456","李四",22, Sex.WOMAN ));
        userMapper.insert(new User("wangwu","123456","王五",21, Sex.MAN ));
        userMapper.insert(new User("zhaoliu","123456","赵六",23, Sex.WOMAN ));
        userMapper.insert(new User("songqi","123456","宋七",21, Sex.MAN ));

        Assert.assertEquals(5,userMapper.findAll().size());
    }

}
