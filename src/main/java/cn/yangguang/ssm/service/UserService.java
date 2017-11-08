package cn.yangguang.ssm.service;

import cn.yangguang.ssm.entity.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by songyangguang on 2017/11/4.
 */
public interface UserService {
    void addUser(User user);

    User getUserByPhone(String phone);

    void updateUserName(User user);

    int updateGoodsNum(Integer id,Integer goodsNum);

    User selectByPrimaryKey(Integer id);

    List<User> getPageUser(int pageNum, int pageSize);

    int getUserNum();

    InputStream getInputStream() throws  Exception;
}
