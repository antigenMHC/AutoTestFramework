package cn.antigenmhc.test.suite;

import org.testng.annotations.Test;

/**
 * @Author: antigenMHC
 * @Date: 2021/5/16 8:47
 * @Version: 1.0
 **/
public class IgnoreTest {
    @Test
    public void ingore1() {
        System.out.println("1执行");
    }

    @Test
    public void ingore2() {
        System.out.println("2执行");
    }
}
