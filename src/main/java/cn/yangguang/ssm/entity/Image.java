package cn.yangguang.ssm.entity;

/**
 * Created by songyangguang on 2017/11/7.
 */

public class Image {
    private Integer id;//图片id

    private Integer goodsId;//商品id

    private String imgUrl;//图片链接

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}