package com.Scan;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestOrder {
	String baseUrl ="http://test2.diandianwaimai.com/dd_mobile/sitdownrts/showware.action?shop_id=17904&tablecode=A01";
	String baseUrl1 = "http://test2.diandianwaimai.com/dd_mobile/sitdownrts/showware.action?shop_id=17904&tablecode=A02&user_id=57987&open_id=oCtqHjpBZzJDuoivYlwT8Z3pIXCA&error_msg=0";
	
	@Test
	public void testOrderbyzhifubao() throws InterruptedException{
		WebDriver driver =new FirefoxDriver();
		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shop-info_name")));
		//WebElement shopname = driver.findElement(By.className("shop-info_name"));
		//选择菜品
		WebElement ware_name =driver.findElement(By.xpath("//*[@id='menu-area']/div/section[1]/div[1]/div[2]/div[2]/div[2]/div[3]"));
		ware_name.click();
		//下一步
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("next-step")));
		driver.findElement(By.id("next-step")).click();
		//提交订单
		WebDriverWait wait2 = new WebDriverWait(driver,5);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBtnId")));
		driver.findElement(By.id("submitBtnId")).click();
		
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void testOrderbyweixin() throws InterruptedException{
		WebDriver driver =new FirefoxDriver();
		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shop-info_name")));
		//WebElement shopname = driver.findElement(By.className("shop-info_name"));
		//选择菜品
		WebElement ware_name =driver.findElement(By.xpath("//*[@id='menu-area']/div/section[1]/div[1]/div[2]/div[2]/div[2]/div[3]"));
		ware_name.click();
		//下一步
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("next-step")));
		driver.findElement(By.id("next-step")).click();
		//提交订单
		WebDriverWait wait2 = new WebDriverWait(driver,5);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBtnId")));
		driver.findElement(By.id("submitBtnId")).click();
		
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void testOrderbyweixinTest() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get(baseUrl1);
		Cookie c1 = new Cookie("ddtech_userid", "57987");
		Cookie c2 = new Cookie("ddtech_usermobile", "15019498582");
		
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
		//获得 cookie
		Set<Cookie> coo = driver.manage().getCookies();
		//打印 cookie
		System.out.println(coo);
		driver.quit();
	}

	
}
