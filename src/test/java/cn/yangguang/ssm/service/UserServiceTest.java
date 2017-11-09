package cn.yangguang.ssm.service;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Catelog;
import cn.yangguang.ssm.entity.User;
import cn.yangguang.ssm.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songyangguang on 2017/11/9.
 */
public class UserServiceTest extends BaseTest {

   // private UserService userService = new UserServiceImpl();
    @Autowired
   private UserService userService;
    //@Autowired
    //private CatelogService catelogService;
    @Test
    public void addUserTest() {
        User user = new User();
        user.setId(11);
        user.setPhone("18328584127");
        user.setUsername("凤姐");
        user.setPassword("llf41207");
        user.setQq("2287549045");
        user.setCreateAt("2017-10-05");
        user.setGoodsNum(2);
        //user.setPower((byte)10);
        user.setLastLogin(null);
        user.setStatus(null);

        //catelogService.getAllCatelog();

        userService.addUser(user);

    }

    @Test
    public void getUserByPhoneTest() {
        String phone = "15552201622";
        User user = userService.getUserByPhone(phone);

        System.out.println(user.getUsername());
    }

    @Test
    public void updateUserNameTest() {

    }

    @Test
    public void updateGoodsNumTest() {

    }

    @Test
    public void selectByPrimaryKeyTest() {

    }

    @Test
    public void getPageUser() {

    }

    @Test
    public void getUserNum() {

    }

}
