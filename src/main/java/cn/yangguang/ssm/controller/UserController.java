package cn.yangguang.ssm.controller;

import cn.yangguang.ssm.entity.User;
import cn.yangguang.ssm.service.GoodsService;
import cn.yangguang.ssm.service.ImageService;
import cn.yangguang.ssm.service.UserService;
import cn.yangguang.ssm.service.impl.UserServiceImpl;
import cn.yangguang.ssm.util.DateUtil;
import cn.yangguang.ssm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/addUser")
    public String addUser(HttpServletRequest request, HttpServletResponse response,
                          @ModelAttribute("user") User user) {
        String url = request.getHeader("Referer");
        System.out.println("**************userName="+user.getUsername());
        System.out.println("**************Password="+user.getPassword());
        User user1 = userService.getUserByPhone(user.getPhone());
        if(user1 != null) {//检测出用户不存在
            String time = DateUtil.getNowDay();

            String str = MD5.md5(user.getPassword());
            user.setCreateAt(time);
            user.setPassword(str);
            user.setGoodsNum(0);

            userService.addUser(user);
        }
        return "redirect:"+url;
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

        System.out.println("**************Password="+url);

        if(cur_user != null) {
            String pwd = MD5.md5(user.getPassword());
            if(pwd.equals(cur_user.getPassword())) {
                request.getSession().setAttribute("cur_user",cur_user);
                return new ModelAndView("redirect:"+url);
            }
        }
        return new ModelAndView("redirect:"+url);
    }

    /**
     * 更改用户名
     * @param request
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/changeName")
    public ModelAndView changeName(HttpServletRequest request,User user,ModelMap modelMap) {
        String url = request.getHeader("Referer");

        //从session中获取当前用户
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        cur_user.setUsername(user.getUsername());//更改当前用户的用户名
        userService.updateUserName(cur_user);//执行修改操作
        request.getSession().setAttribute("cur_user",cur_user);//修改session的值
        return new ModelAndView("redirect:"+url);
    }

    /**
     * 个人中心
     * @return
     */
    @RequestMapping(value = "/home")
    public String home() {
        return "/user/home";
    }

    /**
     * 个人信息设置
     * @return
     */
    @RequestMapping(value = "/basic")
    public String basic() {
        return "/user/basic";
    }

    /**
     * 完善或修改信息
     * @param request
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/updateInfo")
    public ModelAndView updateInfo(HttpServletRequest request,User user,ModelMap modelMap) {
        //从sessio中获取当前用户
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        cur_user.setUsername(user.getUsername());
        cur_user.setQq(user.getQq());
        userService.updateUserName(cur_user);//执行修改操作
        request.getSession().setAttribute("cur_user",cur_user);
        return new ModelAndView("redirect:/user/basic");
    }

}
