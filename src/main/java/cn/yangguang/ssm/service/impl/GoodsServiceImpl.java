package cn.yangguang.ssm.service.impl;

import cn.yangguang.ssm.dao.GoodsMapper;
import cn.yangguang.ssm.entity.Goods;
import cn.yangguang.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/9.
 */
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public int addGoods(Goods goods, Integer duration) {

        return 0;
    }


    public Goods getGoodByPrimaryKey(Integer goodsId) {
        return null;
    }


    public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId, Goods goods) {

    }


    public void deleteGoodsByPrimaryKey(Integer id) {

    }


    public List<Goods> getAllGoods() {
        return null;
    }


    public List<Goods> searchGoods(String name, String describle) {
        return null;
    }


    public List<Goods> getGoodsByCatalog(Integer id, String name, String describe) {
        return null;
    }


    public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId, Integer limit) {
        return null;
    }


    public List<Goods> getGoodsByUserId(Integer user_id) {
        return null;
    }
}
