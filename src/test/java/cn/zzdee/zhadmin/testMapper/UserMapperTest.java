package cn.zzdee.zhadmin.testMapper;


import cn.zzdee.zhadmin.dao.UserDao;
import cn.zzdee.zhadmin.entity.User;
import cn.zzdee.zhadmin.common.enums.Sex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {


    @Resource
    private UserDao userDao;

    @Test
    public void testInsert() throws Exception {
        userDao.insert(new User("zhangsan", "123456", "张三", 20, Sex.MAN));
        userDao.insert(new User("lisi", "123456", "李四", 22, Sex.WOMAN));
        userDao.insert(new User("wangwu", "123456", "王五", 21, Sex.MAN));
        userDao.insert(new User("zhaoliu", "123456", "赵六", 23, Sex.WOMAN));
        userDao.insert(new User("songqi", "123456", "宋七", 21, Sex.MAN));

        Assert.assertEquals(5, userDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception{
        List<User> users = userDao.findAll();

        for(User user : users){

            userDao.delete(user.getId());
        }


    }

    @Test
    public void testSelect() throws Exception {
        List<User> users = userDao.findAll();

        for(User user : users){
            System.out.println(user);
        }
    }

}
