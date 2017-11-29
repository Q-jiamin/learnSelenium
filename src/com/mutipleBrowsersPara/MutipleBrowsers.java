package com.mutipleBrowsersPara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.driverDemo.lanch.Browsers;
import com.driverDemo.lanch.BrowsersType;

public class MutipleBrowsers {
	private WebDriver driver = null;
	private Browsers browser =null;
	
	@Parameters({"platform"})
	@BeforeMethod(groups="browsers")
	public void intal(String platform) throws InterruptedException{
		if (platform.equals("FF"))
			browser = new Browsers(BrowsersType.firefox);
		else if(platform.equals("chrome"))
			browser = new Browsers(BrowsersType.chrome);
		else
			browser = new Browsers(BrowsersType.ie);
		driver = browser.driver;
		Thread.sleep(2000);
	}
/*	@BeforeMethod (groups = "browsers")
	public void intal(){
		 browser = new Browsers(BrowsersType.firefox);
		 driver = browser.driver;
	}*/
	@Test(groups = "submodule1")
	public void testSubModule1(){
		driver.get("http://www.baidu.com");
		System.out.println("----testsubmodule1---");
	}
	@Test(groups = "submodule2")
	public void testSubModule2(){
		driver.get("http://www.bing.com");
		System.out.println("----testsubmodule2---");
	}
	@Test(groups = "submodule3")
	public void testSubModule3(){
		driver.get("http://www.so.com");
		System.out.println("----testsubmodule3---");
	}
	@Test(groups = "submodule4")
	public void testSubModule4(){
		driver.get("http://www.oracle.com");
		System.out.println("----testsubmodule4---");
	}
	@AfterMethod(groups="browsers")
	public void release(){
		driver.quit();
	}
}
