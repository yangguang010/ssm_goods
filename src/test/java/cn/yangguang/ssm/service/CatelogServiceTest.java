package cn.yangguang.ssm.service;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Catelog;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by songyangguang on 2017/11/11.
 */
public class CatelogServiceTest extends BaseTest {
    @Autowired
    private CatelogService catelogService;

    @Test
    public void getAllCatelogTest() {
        List<Catelog> catelogs = catelogService.getAllCatelog();
        System.out.println("Catelog_num = " + catelogs.size());
    }

    @Test
    public void updateCatelogNumTest() {
        int id = 2;
        int num = 10;

        int update = catelogService.updateCatelogNum(id,num);
        System.out.println(update);
    }

}
