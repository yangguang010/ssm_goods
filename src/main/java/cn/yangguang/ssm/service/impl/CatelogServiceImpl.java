package cn.yangguang.ssm.service.impl;

import cn.yangguang.ssm.dao.CatelogMapper;
import cn.yangguang.ssm.entity.Catelog;
import cn.yangguang.ssm.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/11.
 */
@Service("catelogService")
public class CatelogServiceImpl implements CatelogService{

    @Autowired
    private CatelogMapper catelogMapper;

    public List<Catelog> getAllCatelog() {
        List<Catelog> calelogs = catelogMapper.getAllCatelog();
        return calelogs;
    }

    public int getCount(Catelog catelog) {
        int count = catelogMapper.getCount(catelog);
        return count;
    }

    public Catelog selectByPrimaryKey(Integer id) {
        Catelog catelog = catelogMapper.selectByPrimaryKey(id);
        return catelog;
    }

    public int updateByPrimaryKey(Catelog record) {
        int update = catelogMapper.updateByPrimaryKey(record);
        return update;
    }

    public int updateCatelogNum(Integer id, Integer number) {
        int update = catelogMapper.updateCatelogNum(id, number);
        return update;
    }
}
