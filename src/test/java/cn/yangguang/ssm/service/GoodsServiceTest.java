package cn.yangguang.ssm.service;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Goods;
import cn.yangguang.ssm.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Test
    public void addGoodsTest() {
        Goods goods = new Goods();
        int duration = 5;
        goods.setId(35);
        goods.setCatelogId(3);
        goods.setUserId(1);
        goods.setName("苹果6s");
        goods.setPrice((float)2000);
        goods.setRealPrice((float)3499);
        goods.setStartTime(DateUtil.getNowDay());
        goods.setEndTime(DateUtil.getLastTime(DateUtil.getNowDay(),duration));
        goods.setDescrible("今年刚买的手机，8成新，现在便宜处理");

        int add = goodsService.addGoods(goods,duration);
        System.out.println("添加商品："+add);
    }

    @Test
    public void deleteGoodsByPrimaryKeyTest() {
        int goodsId = 35;

        goodsService.deleteGoodsByPrimaryKey(goodsId);

    }

    @Test
    public void getGoodsByUserIdTest() {
        List<Goods> goods = goodsService.getGoodsByUserId(6);

    }



}
