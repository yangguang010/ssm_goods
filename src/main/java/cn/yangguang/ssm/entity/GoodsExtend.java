package cn.yangguang.ssm.entity;

/**
 * Created by songyangguang on 2017/11/7.
 */

import java.util.ArrayList;
import java.util.List;

public class GoodsExtend {
    private Goods goods;
    private List<Image> images = new ArrayList<Image>();

	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
}