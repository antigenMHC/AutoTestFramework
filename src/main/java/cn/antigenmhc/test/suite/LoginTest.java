package cn.antigenmhc.test.suite;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author: antigenMHC
 * @Date: 2021/5/16 8:15
 * @Version: 1.0
 **/
public class LoginTest {

    @Test
    public void loginTest() {
        System.out.println("登录测试");
        Assert.assertEquals(1, 2);
    }
}
