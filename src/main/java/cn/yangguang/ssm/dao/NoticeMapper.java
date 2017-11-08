package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.entity.Notice;

/**
 * Created by songyangguang on 2017/11/7.
 */

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
}