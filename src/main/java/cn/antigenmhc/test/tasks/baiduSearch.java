package cn.antigenmhc.test.tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import cn.antigenmhc.test.util.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class baiduSearch {

	public static void search(WebDriver dr,String s1) throws InterruptedException, IOException{
		dr.findElement(By.xpath(ReadProperties.getProp("element", "elements", "baiducontent"))).clear();
		Thread.sleep(2000);
		dr.findElement(By.xpath(ReadProperties.getProp("element", "elements", "baiducontent"))).sendKeys(s1);
		dr.findElement(By.xpath(ReadProperties.getProp("element", "elements", "baidusearch"))).click();
		Thread.sleep(2000);
	}
}
