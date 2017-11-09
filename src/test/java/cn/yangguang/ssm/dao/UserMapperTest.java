package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Goods;
import cn.yangguang.ssm.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/4.
 */
public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void insertUserTest() {
       /* User user = new User();
        user.setId(20170006);
        user.setPhone("18300904571");
        user.setCreateAt("2017-10-9");
        user.setGoodsNum(9);
        user.setLastLogin("2017-11-4");
        user.setPassword("990890");
        user.setUsername("song1");
        user.setQq("2287549045");
        //user.setPower();
        //user.getStatus();*/
        User user = new User();
        user.setId(8);
        user.setPhone("18328584127");
        user.setUsername("凤姐");
        user.setPassword("llf41207");
        user.setQq("2287549045");
        user.setCreateAt("2017-10-05");
        user.setGoodsNum(2);
        user.setPower((byte)10);
        user.setLastLogin(null);
        user.setStatus(null);

        userMapper.insert(user);

    }
    @Test
    public void userTest() {
        List<User> lists = userMapper.getUserList();

        for (User user:lists) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void goodsTest() {
        List<Goods> goods = goodsMapper.selectAllGoods();

        for(Goods good: goods) {
            System.out.println(good);
        }
    }
}
