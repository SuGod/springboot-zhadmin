package cn.zzdee.zhadmin.controller.swaggerDemo;


import cn.zzdee.zhadmin.dao.UserDao;
import cn.zzdee.zhadmin.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/demo")
public class SwaggerDemoController {


    @Resource
    private UserDao userDao;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {


        return userDao.findAll();
    }

}
