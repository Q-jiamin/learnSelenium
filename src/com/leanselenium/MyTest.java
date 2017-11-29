package com.leanselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyTest {
	public static void main(String[] args){
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com/");
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input [value='百度一下']")).click();
		driver.quit();
	}
}
