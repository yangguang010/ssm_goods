package cn.yangguang.ssm.service;

import cn.yangguang.ssm.entity.Goods;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/8.
 */
public interface GoodsService {

    public int addGoods(Goods goods, Integer duration);

    public Goods getGoodByPrimaryKey(Integer goodsId);

    public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId, Goods goods);

    public void deleteGoodsByPrimaryKey(Integer id);

    public List<Goods> getAllGoods();

    public List<Goods> searchGoods(String name,String describle);

    public List<Goods> getGoodsByCatalog(Integer id,String name,String describe);

    public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId,Integer limit);

}
