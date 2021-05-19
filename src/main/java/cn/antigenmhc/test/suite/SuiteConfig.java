package cn.antigenmhc.test.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @Author: antigenMHC
 * @Date: 2021/5/16 8:16
 * @Version: 1.0
 **/
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("套件运行之前运行");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("套件运行之后运行");
    }
}
