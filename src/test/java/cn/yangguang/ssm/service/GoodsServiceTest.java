package cn.yangguang.ssm.service;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songyangguang on 2017/11/10.
 */
public class GoodsServiceTest extends BaseTest{

    @Autowired
    private GoodsService goodsService;

    @Test
    public void getGoodsByPrimaryKeyTest() {
        int goodId = 3;

        Goods good = goodsService.getGoodByPrimaryKey(goodId);

        System.out.println(good.toString());
    }



}
