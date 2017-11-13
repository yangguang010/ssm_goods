package cn.yangguang.ssm.service.impl;

import cn.yangguang.ssm.dao.ImageMapper;
import cn.yangguang.ssm.entity.Image;
import cn.yangguang.ssm.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/13.
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    public int insert(Image record) {
        int insert = imageMapper.insert(record);
        return insert;
    }

    public List<Image> getImagesByGoodsPrimaryKey(Integer goodsId) {
        List<Image> images = imageMapper.selectByGoodsPrimaryKey(goodsId);
        return images;
    }

    public int deleteImagesByGoodsPrimaryKey(Integer goodsId) {
        int delete = imageMapper.deleteImagesByGoodsPrimaryKey(goodsId);
        return 0;
    }
}
