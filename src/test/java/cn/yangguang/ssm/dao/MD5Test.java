package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.util.MD5;
import org.junit.Test;

/**
 * Created by songyangguang on 2017/11/13.
 */
public class MD5Test extends BaseTest{

    MD5 md = new MD5();

    @Test
    public void MD_Test() {
        String password = "123456";
        String result = md.md5(password);
        System.out.println(result);

    }

}
