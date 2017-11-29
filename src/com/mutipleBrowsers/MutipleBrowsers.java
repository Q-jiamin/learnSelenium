package com.mutipleBrowsers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.driverDemo.lanch.Browsers;
import com.driverDemo.lanch.BrowsersType;

public class MutipleBrowsers {
	private WebDriver driver = null;
	private Browsers browser =null;
	
	@BeforeMethod (groups = "browsers")
	public void intal(){
		 browser = new Browsers(BrowsersType.firefox);
		 driver = browser.driver;
	}
	@Test(groups = "submodule1")
	public void testSubModule1(){
		driver.get("http://www.baidu.com");
	}
	@Test(groups = "submodule2")
	public void testSubModule2(){
		driver.get("http://www.bing.com");
	}
	@Test(groups = "submodule3")
	public void testSubModule3(){
		driver.get("http://www.so.com");
	}
	@Test(groups = "submodule4")
	public void testSubModule4(){
		driver.get("http://www.oracle.com");
	}
	@AfterMethod(groups="browsers")
	public void release(){
		driver.quit();
	}
}
