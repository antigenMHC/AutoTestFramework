package cn.antigenmhc.test.suite;

import java.io.FileNotFoundException;
import java.io.IOException;

import cn.antigenmhc.test.tasks.baiduSearch;
import cn.antigenmhc.test.util.Browser;
import cn.antigenmhc.test.util.RangeDataByPoi;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;



public class BrowserTest {
	private static Logger logger= Logger.getLogger(Test.class);
	WebDriver dr;
	
	@DataProvider(name="test")
	public Object[][] getData() throws IOException{
		String filepath = "d:/test.xlsx";
		return RangeDataByPoi.poiRangeData(filepath);
	}
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browser, String url){
		logger.info("browser is "+browser+"&url is "+url);
		dr = Browser.openBrowser(dr, browser, url);
	}

	@Test(dataProvider ="test")
	public void browser(String s1, String s2) throws InterruptedException,IOException{
		baiduSearch.search(dr, s1);
		baiduSearch.search(dr, s2);
	}
	
	@AfterTest
	public void quit(){
		Browser.closeBrowser(dr);
	}
}
