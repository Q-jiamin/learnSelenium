package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



public class TestWait {

@Test
	public void testWait(){
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.baidu.com/");
	//隐式等待
	//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);//其他的查找也会等待生效，所以这种方法不太用。
	//WebDriverWait wait = new WebDriverWait(driver,10);//10s之内，默认500ms检查一次。要是没找到会有返回
	//两个方法，until 第二个根据参数返回值不同
	//List<WebElement> list = (List<WebElement>) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("doLogin")));
	//wait.until(ExpectedConditions.titleContains("百度"));
	//如果找到就返回元素，如果没有就返回超时。
/*	WebElement er = wait.until(new ExpectedCondition<WebElement>(){
		@Override
		public WebElement apply (WebDriver driver){
			return driver.findElement(By.id("doLodin"));
		}
	});*/
	//调用等待
	this.isPresence(driver,10);
	//如何自定义一些条件完成等待？
	
	FluentWait<WebDriver> wait = new FluentWait<WebDriver> ( driver);
	wait.pollingEvery(100,TimeUnit.MICROSECONDS).withTimeout(10, TimeUnit.SECONDS);
	//Function<WebDriver,WebElement> f = new Function<WebDriver,WebElement>();

	WebElement e = wait.until(new Function<WebDriver,WebElement>(){

		@Override
		public WebElement apply(WebDriver arg0) {
			// TODO Auto-generated method stub
			return driver.findElement(By.id("doLogin"));
		}
		//与webdriverwait一样的效果，类似操作都一样，修改泛型就行了。
	});
	driver.findElement(By.id("doLogin")).click();
	driver.findElement(By.id("register"));
	//显示等待 webdriver方法 until
	
		
}
/*private Object presenceOfElementLocated(By id) {
	// TODO Auto-generated method stub
	return null;
}
*/
//自定义一个
public boolean isPresence(WebDriver driver,long timeout){
	boolean flag = true;
	WebDriverWait wait = new WebDriverWait(driver,timeout);
	try{
		WebElement er = wait.until(new ExpectedCondition<WebElement>(){
			@Override
			public WebElement apply (WebDriver driver){
				return driver.findElement(By.id("doLodin"));
			}
	});
	}catch(Exception e){
		flag = false;
	}
	return flag;
}
public boolean isDisabled(WebDriver driver,long timeout){
	boolean flag = true;
	WebDriverWait wait = new WebDriverWait(driver,timeout);
	try{
		flag = wait.until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply (WebDriver driver){
				return driver.findElement(By.id("doLodin")).isDisplayed();
			}
	});
	}catch(Exception e){
		flag = false;
	}
	return flag;
}

}
