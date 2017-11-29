package com.testScan;

import static org.testng.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrder {
	@Test
	public void testRolemanage(){
		
		WebDriver driver =new FirefoxDriver();
		driver.get("http://test2.diandianwaimai.com/dd_mobile/sitdownrts/showware.action?shop_id=17904&tablecode=A01");
		
		/*WebElement merchantId = driver.findElement((By.cssSelector("input[placeholder='商户号']")));
		merchantId.clear();
		merchantId.sendKeys("10068");
		WebElement loginName = driver.findElement(By.cssSelector("input[placeholder='工号']"));
		loginName.clear();
		loginName.sendKeys("admin");
		driver.findElement(By.cssSelector("input[placeholder='密码']")).sendKeys("admin");
		driver.findElement(By.className("login-buttom")).click();
		//定位到角色管理,断言是否页面正确
		driver.get("http://test2.diandianwaimai.com:6030/systemMaintenance#/roleManage");*/
		/*String roleManageTitle = driver.findElement(By.xpath(".//*[@id='nav']/li[7]/ul/li[1]")).getText();
		assertEquals("角色管理",roleManageTitle);*/
		//新增角色
		//driver.findElement(By.xpath(".//*[@id='contentArea']/section/div[1]/div[1]/span")).click();
		
	}
}
