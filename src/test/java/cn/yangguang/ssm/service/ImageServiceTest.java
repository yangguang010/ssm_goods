package cn.yangguang.ssm.service;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Image;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/13.
 */
public class ImageServiceTest extends BaseTest {
    @Autowired
    private ImageService imageService;

    @Test
    public void getImageTest() {
        int goodsId = 2;
        List<Image> images = imageService.getImagesByGoodsPrimaryKey(goodsId);
        for (Image image : images)
            System.out.println(image.getImgUrl());
    }
}
