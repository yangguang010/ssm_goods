package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.entity.Reply;

/**
 * Created by songyangguang on 2017/11/6.
 */

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
}