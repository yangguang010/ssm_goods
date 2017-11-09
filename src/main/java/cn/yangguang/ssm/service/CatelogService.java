package cn.yangguang.ssm.service;

import cn.yangguang.ssm.entity.Catelog;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/9.
 */
public interface CatelogService {

    /**
     * 获得所有目录分类
     * @return
     */
    public List<Catelog> getAllCatelog();

    /**
     * 根据商品信息获得商品分类
     * @param catelog
     * @return
     */
    public int getCount(Catelog catelog);

    /**
     * 根据主键id获得分类信息
     * @param id
     * @return
     */
    public Catelog selectByPrimaryKey(Integer id);

    /**
     * 更新分类信息
     * @param record
     * @return
     */
    public int updateByPrimaryKey(Catelog record);

    /**
     * 修改分类下商品的数量
     * @param id
     * @param number
     * @return
     */
    public int updateCatelogNum(Integer id,Integer number);

}
