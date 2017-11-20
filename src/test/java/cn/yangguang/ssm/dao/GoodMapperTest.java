package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/14.
 */
public class GoodMapperTest extends BaseTest{
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void getGoodsByUserIdTest() {
       List<Goods> goods = goodsMapper.getGoodsByUserId(6);
    }
}
