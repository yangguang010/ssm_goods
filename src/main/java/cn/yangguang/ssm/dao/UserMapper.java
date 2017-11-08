package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/3.
 */
public interface UserMapper {
    /**
     * 根据用户id号删除用户信息
     * @param id 用户
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户的电话号码查询用户
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 更改用户的商品数量
     * @param id
     * @param goodsNum
     * @return
     */
    int updateGoodsNum(@Param("id") Integer id, @Param("goodsNum") Integer goodsNum);

    /**
     * 查询所有用户
     * @return
     */
    List<User> getUserList();
}
