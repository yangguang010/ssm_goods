package cn.yangguang.ssm.service.impl;

import cn.yangguang.ssm.dao.UserMapper;
import cn.yangguang.ssm.entity.User;
import cn.yangguang.ssm.service.UserService;
import cn.yangguang.ssm.util.WriteExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyangguang on 2017/11/4.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insert(user);
    }


    public User getUserByPhone(String phone) {
        User user = userMapper.getUserByPhone(phone);
        return user;
    }


    public void updateUserName(User user) {
        userMapper.updateByPrimaryKey(user);
    }


    public int updateGoodsNum(Integer id, Integer goodsNum) {
        int update = userMapper.updateGoodsNum(id,goodsNum);
        return update;
    }


    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }


    public List<User> getPageUser(int pageNum, int pageSize) {

        List<User> users = userMapper.getUserList();

        return users;
    }

    //获取用户的数量
    public int getUserNum() {
        List<User> users = userMapper.getUserList();
        return users.size();
    }


    public InputStream getInputStream() throws Exception {
        String[] title = new String[]{"序号","手机号","姓名","QQ","开通时间","商品数量","用户权限"};

        List<User> users = userMapper.getUserList();

        List<Object[]> dataList = new ArrayList<Object[]>();
        for (User user:users) {
            Object[] object = new Object[7];
            object[0] = user.getId();
            object[1] = user.getPhone();
            object[2] = user.getUsername();
            object[3] = user.getQq();
            object[4] = user.getCreateAt();
            object[5] = user.getGoodsNum();
            object[6] = user.getPower();

            dataList.add(object);
        }

        WriteExcel ex = new WriteExcel(title,dataList);
        InputStream in = ex.export();

        return in;
    }

    public static HttpSession getSession() {
        HttpSession session = null;

        session = getRequest().getSession();

        return session;
    }

    public static HttpServletRequest getRequest() {
      ServletRequestAttributes attrs =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      return attrs.getRequest();
    }
}
