package cn.yangguang.ssm.controller;

import cn.yangguang.ssm.service.UserService;
import cn.yangguang.ssm.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by songyangguang on 2017/11/6.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("cur_user",null);
       // userService.
        return "redirect:/goods/homeGoods";
    }

}
