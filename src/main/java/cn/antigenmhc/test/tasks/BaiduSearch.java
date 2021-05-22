package cn.antigenmhc.test.tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import cn.antigenmhc.test.util.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaiduSearch {

	public static void search(WebDriver dr, String s1) throws InterruptedException, IOException{
		dr.findElement(By.xpath(ReadProperties.getProp("element", "elements", "baiduContent"))).clear();
		Thread.sleep(2000);
		dr.findElement(By.xpath(ReadProperties.getProp("element", "elements", "baiduContent"))).sendKeys(s1);
		dr.findElement(By.xpath(ReadProperties.getProp("element", "elements", "baiduSearch"))).click();
		Thread.sleep(2000);
	}
}
