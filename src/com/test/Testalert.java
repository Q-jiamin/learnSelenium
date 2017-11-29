package com.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testalert {
@Test
public void testframe(){
	WebDriver driver = new FirefoxDriver();
	driver.get("E:\\BaiduNetdiskDownload\\note\\html\\frameA.html");
	driver.switchTo().frame("f_1");
	driver.findElement(By.id("iframeinput")).sendKeys("hello");
	//需要恢复默认，再切换到新的frame
	driver.switchTo().defaultContent();
	WebDriver wd = driver.switchTo().frame(1);
	wd.findElement(By.id("btn")).click();
}

@Test
public void testWindow(){
	WebDriver driver = new FirefoxDriver();
	driver.get("E:\\BaiduNetdiskDownload\\note\\html\\windows.html");
	String parent = driver.getWindowHandle();
	driver.findElement(By.id("helpbutton1")).click();
	
	java.util.Set<String> all = driver.getWindowHandles();
	Iterator<String> iter = all.iterator();
	String temp;
	while(iter.hasNext()){
		temp = iter.next();
/*		if(temp.equals(parent)){
			iter.remove();
		}*/
		if(!temp.equals(parent)){
			driver.switchTo().window(temp);
		}
	}
	
	
}

@Test
public void testAlert(){
	WebDriver driver = new FirefoxDriver();
	//driver.get("file:///E:/BaiduNetdiskDownload/%E5%AD%A6%E4%B9%A0%E8%AE%B0%E5%BD%95/files/alert.html");//点击到链接
	driver.get("file:///E:/BaiduNetdiskDownload/%E5%AD%A6%E4%B9%A0%E8%AE%B0%E5%BD%95/files/alert2.html");
	WebDriverWait wait = new WebDriverWait(driver,5);
	//confirm写法
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='button']")));
	//WebElement alert =driver.findElement(By.xpath("//input[@type='button']"));//上一个Button,也这样定位
	WebElement alert = driver.findElement(By.xpath("//input[@type='button']"));
	alert.click();
	Alert temp = driver.switchTo().alert();
	temp.accept();
	/*temp.dismiss();
	String content = temp.getText();
	//断言：判断
	assertTrue(content.equals("我是确认提示框！"));
*/
	//driver.quit();
	
}

}
