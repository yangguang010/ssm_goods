package cn.yangguang.ssm.service;

import cn.yangguang.ssm.entity.Goods;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/8.
 */
public interface GoodsService {

    /**
     * 发布商品
     * @param goods
     * @param duration 允许上架时常
     * @return
     */
    public int addGoods(Goods goods, Integer duration);

    /**
     * 通过主键查询商品
     * @param goodsId 商品主键
     * @return
     */
    public Goods getGoodByPrimaryKey(Integer goodsId);

    /**
     * 更新商品信息
     * @param goodsId 商品主键
     * @param goods 商品的新信息
     */
    public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId, Goods goods);

    /**
     * 通过商品主键删除对应商品
     * @param id
     */
    public void deleteGoodsByPrimaryKey(Integer id);

    /**
     * 查询所有商品
     * @return
     */
    public List<Goods> getAllGoods();

    /**
     * 查询相应的商品信息
     * @param name
     * @param describle
     * @return
     */
    public List<Goods> searchGoods(String name,String describle);

    /**
     * 根据商品分类查询商品信息，
     * @param id
     * @param name
     * @param describe
     * @return
     */
    public List<Goods> getGoodsByCatalog(Integer id,String name,String describe);

    /**
     * 根据分类id获取商品，并按照时间进行排序（商品个数是limit个）
     * @param catelogId
     * @param limit
     * @return
     */
    public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId,Integer limit);

    /**
     * 根据用户的id查询出该用户的所有闲置
     * @param user_id
     * @return
     */
    public List<Goods> getGoodsByUserId(Integer user_id);

}
