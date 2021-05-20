package cn.antigenmhc.test.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static WebDriver openBrowser(WebDriver dr,String browser,String url){
		if ("chrome".equals(browser)){
			System.setProperty("webdriver.chrome.driver", "f:\\chromedriver.exe");
			dr= new ChromeDriver();
		} else if ("firefox".equals(browser)){
			System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
			dr= new FirefoxDriver();	
		} else if ("edge".equals(browser)){
				
		} else if ("ie".equals(browser)){
				
		} else{

		}
		dr.manage().window().maximize();
		dr.get(url);
		return dr;
	}
	
	public static void closeBrowser(WebDriver dr){
		dr.quit();
	}
}