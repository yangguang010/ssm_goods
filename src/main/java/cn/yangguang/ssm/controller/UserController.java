package cn.yangguang.ssm.controller;

import cn.yangguang.ssm.entity.User;
import cn.yangguang.ssm.service.GoodsService;
import cn.yangguang.ssm.service.ImageService;
import cn.yangguang.ssm.service.UserService;
import cn.yangguang.ssm.service.impl.UserServiceImpl;
import cn.yangguang.ssm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by songyangguang on 2017/11/6.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ImageService imageService;

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("cur_user",null);
       // userService.
        return "redirect:/goods/homeGoods";
    }



    /**
     * 用户登录
     * @param request
     * @param response
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView loginValidate(HttpServletRequest request,
                                      HttpServletResponse response, User user, ModelMap modelMap) {
        User cur_user = userService.getUserByPhone(user.getPhone());
        String url = request.getHeader("Referer");

        if(cur_user != null) {
            String pwd = MD5.md5(user.getPassword());
            if(pwd.equals(cur_user.getPassword())) {
                request.getSession().setAttribute("cur_user",cur_user);
                return new ModelAndView("redirect:"+url);
            }
        }
        return new ModelAndView("redirect:"+url);
    }

}
