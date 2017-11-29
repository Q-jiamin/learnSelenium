package com.driverDemo;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class lauchChrome {
	private static WebDriver chromewb =null;
	private static DesiredCapabilities caps =null;
	private String projectpath = System.getProperty("user.dir");
	
	@BeforeClass
	public void startChrome(){
		System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver1.exe");
		caps = DesiredCapabilities.chrome();
		caps.setCapability( "chrome.switches",Arrays.asList("--start-maximized"));	
		chromewb = new ChromeDriver(caps);
	}
	@Test
	public void serchOnBaidu(){
		chromewb.get("http://www.baidu.com");	
	}
	@AfterClass
	public void releaseIEDriver(){
		chromewb.quit();
	}
}
