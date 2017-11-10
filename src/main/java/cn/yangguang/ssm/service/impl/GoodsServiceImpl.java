package cn.yangguang.ssm.service.impl;

import cn.yangguang.ssm.dao.GoodsMapper;
import cn.yangguang.ssm.entity.Goods;
import cn.yangguang.ssm.service.GoodsService;
import cn.yangguang.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/9.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 添加商品
     * @param goods
     * @param duration 允许上架时常
     * @return
     */
    public int addGoods(Goods goods, Integer duration) {
        String startTime = DateUtil.getNowDay();
        String endTime = DateUtil.getLastTime(startTime,duration);

        String polishTime = startTime;

        //给商品添加上架时间，下架时间，擦亮时间
        goods.setStartTime(startTime);
        goods.setEndTime(endTime);
        goods.setPolishTime(polishTime);

        return goodsMapper.insert(goods);
    }

    /**
     * 根据商品主键id查询商品
     * @param goodsId 商品主键
     * @return
     */
    public Goods getGoodByPrimaryKey(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }


    public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId, Goods goods) {
        goods.setId(goodsId);
        this.goodsMapper.updateByPrimaryKeyWithBLOBs(goods);
    }


    public void deleteGoodsByPrimaryKey(Integer id) {
        goodsMapper.deleteByPrimaryKey(id);
    }


    public List<Goods> getAllGoods() {
        List<Goods> goods = goodsMapper.selectAllGoods();
        return goods;
    }


    public List<Goods> searchGoods(String name, String describle) {
        List<Goods> goods = goodsMapper.searchGoods(name,describle);
        return goods;
    }


    public List<Goods> getGoodsByCatalog(Integer id, String name, String describe) {
        List<Goods> goods = goodsMapper.selectByCatelog(id, name, describe);
        return goods;
    }


    public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId, Integer limit) {
        List<Goods> goods = goodsMapper.selectByCatelogOrderByDate(catelogId,limit);
        return goods;
    }

    public List<Goods> getGoodsByUserId(Integer user_id) {

        List<Goods> goods = goodsMapper.getGoodsByUserId(user_id);
        return null;
    }
}
