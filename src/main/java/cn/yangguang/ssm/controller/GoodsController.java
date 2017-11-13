package cn.yangguang.ssm.controller;

import cn.yangguang.ssm.entity.Goods;
import cn.yangguang.ssm.entity.GoodsExtend;
import cn.yangguang.ssm.entity.Image;
import cn.yangguang.ssm.service.CatelogService;
import cn.yangguang.ssm.service.GoodsService;
import cn.yangguang.ssm.service.ImageService;
import cn.yangguang.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyangguang on 2017/11/13.
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CatelogService catelogService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/homeGoods")
    public ModelAndView homeGoods() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //商品种类
        int catalogSize = 7;
        //每个种类显示商品的数量
        int goodsSize = 6;

        //根据每个种类查询商品信息
        for(int i = 0; i < catalogSize; i++) {
            List<Goods> goods = goodsService.getGoodsByCatelogOrderByDate(i,goodsSize);
            List<GoodsExtend> goodsAndImage = new ArrayList<GoodsExtend>();

            //将每个商品的信息和图片进行封装，然后传递给前台
            for (int j = 0; j < goods.size(); j++) {
                GoodsExtend goodsExtend = new GoodsExtend();
                Goods good = goods.get(j);
                List<Image> images = imageService.getImagesByGoodsPrimaryKey(good.getId());
                goodsExtend.setGoods(good);
                goodsExtend.setImages(images);
                goodsAndImage.add(j,goodsExtend);
            }

            String key = "catelog" + "Goods" + i;
            modelAndView.addObject(key,goodsAndImage);
        }
        modelAndView.setViewName("goods/homeGoods");
        return modelAndView;
    }
}
