package cn.yangguang.ssm.service;

import cn.yangguang.ssm.entity.Image;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/9.
 */
public interface ImageService {

    /**
     * 添加图片信息
     * @param record
     * @return
     */
    public int insert(Image record);

    /**
     * 通过商品id获取该商品的图片
     * @param goodsId
     * @return
     */
    public List<Image> getImagesByGoodsPrimaryKey(Integer goodsId);

    /**
     * 通过商品id删除商品
     * @param goodsId
     * @return
     */
    public int deleteImagesByGoodsPrimaryKey(Integer goodsId);
}
