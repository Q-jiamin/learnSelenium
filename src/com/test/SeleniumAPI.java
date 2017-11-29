package com.test;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.seleniumemulation.SelectFrame;
import org.openqa.selenium.internal.seleniumemulation.Windows;
import org.openqa.selenium.*;
import org.w3c.css.sac.Selector;

import com.thoughtworks.selenium.webdriven.commands.SelectOption;

public class SeleniumAPI {
	@Test
	public void testCrome(){
		System.setProperty("webdriver.chrome.driver","D:\\eclipseworkplace\\learnSelenium1\\resources\\chromedriver1.exe");	
		WebDriver driver =new ChromeDriver();
	    driver.get("http://localhost:8006/jenkins");
		//System.out.println("start firefox browser succeed...");
	  //WebElement element = driver.findElement(By.className("task"));
	  driver.findElement(By.id("search-box")).clear();
	  driver.findElement(By.xpath("//b[text()='登录']")).click();
	  String str = driver.findElement(By.cssSelector("#tasks div a:nth-child(2)")).getText();
	  assertEquals("新建",str);
	  //验证操作是否成功,前面可以加一下反馈信息，当前操作有问题
	  
	    //element.sendKeys("test");
	 // element.click();
	    /*java.util.List<WebElement> list = driver.findElements(By.className("task"));
	    Iterator<WebElement> iter =list.iterator();
	    while(iter.hasNext()){
	    	iter.next().click();
	    }*/
	}
	@Test
	public void testJs(){
		WebDriver driver =new FirefoxDriver();
		//driver.get("http://localhost:8006/jenkins");
		//driver.findElement(By.className("login")).click();
		
		//js处理，当前有点问题，报空指针异常。
/*		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement username = (WebElement) js.executeScript("document.getElementsByName(\"j_username\")");
		username.clear();
		username.sendKeys("jamie");//空指针异常？
		
*/		//截屏操作
		/*OutputStream out =null;
		TakesScreenshot take =(TakesScreenshot)driver;
		File file = take.getScreenshotAs(OutputType.FILE);
		try {
			out = new FileOutputStream("D:/test.jpg");
			try {
				FileUtils.copyFile(file, out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//actions:执行双击
		Actions act =new Actions(driver);
		/*WebElement mess =driver.findElement(By.linkText("新建"));
		act.doubleClick(mess).build().perform();*/
		
		//actions：拖拽操作
/*		WebElement src =driver.findElement(By.linkText("任务历史"));
		WebElement target =driver.findElement(By.id("page-body"));
		act.dragAndDrop(src, target);*/
		
		//select:选择操作。用于下拉框。这个当前有问题，导入不了类，可能已经过时，或者变为私有了。
		/*driver.get("https://www.jd.com/");
		WebElement menu = driver.findElement(By.id("menuSelector"));
		Select se = new Select(menu);
		//SelectFrame sc = new SelectFrame((Windows) driver.findElement(By.id("menuSelector"))); 
		List<WebElement> opts = se.getOptions();
		Iterator<WebElement> iter = opts.iterator();
		se.selectByIndex(0);
		se.selectByValue("honda");
		se.selectByVisibleText("Honda");
		se.deselect();
		se.isMultiple();//判断是否多选
*/		
		//处理单选按钮，复选框
		
		driver.get("file:///C:/Users/dda/Desktop/test.html");
		WebElement radio = driver.findElement(By.cssSelector("form input:nth-child(1)"));
		radio.click();
		radio.isSelected();//判断是否选择成功
	}
	@Test
	public void testlogin(){
		System.setProperty("webdriver.chrome.driver", "D:/eclipseworkplace/learnSelenium1/resources/chromedriver1.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8006/jenkins");
		driver.findElement(By.xpath("//b[text()='登录']")).click();
		driver.findElement(By.id("j_username")).sendKeys("jamie");
		driver.findElement(By.name("j_password")).sendKeys("wzgl521qjm");
		//driver.findElement(By.id("yui-gen2-button")).click();
		driver.findElement(By.name("j_password")).submit();	
	}
	@Test
	public void testIE(){
		System.setProperty("webdriver.ie.driver","D:\\eclipseworkplace\\learnSelenium1\\resources\\IEDriverServer_x64_2.53.1.exe");
		WebDriver driver =new InternetExplorerDriver();
		driver.get("http://www.baidu.com/");
		System.out.println("start firefox browser succeed...");  
	}
	@Test
	public void test(){
		WebDriver driver = new FirefoxDriver(); 
		driver.manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);
		driver.get("http://localhost:8006/jenkins");
		//driver.manage().window().maximize();//浏览器放到最大 
		//driver.navigate().to("http://www.baidu.com");
		//driver.findElement(By.linkText("新建")).click();
		//WebElement element =driver.findElement(By.className("task"));
		//element.click();
		//element.sendKeys("hello");
		java.util.List<WebElement> list = driver.findElements(By.className("task"));
		java.util.Iterator<WebElement> iter =list.iterator();
		while(iter.hasNext()){
			iter.next().click();
		}
		
		driver.navigate().back();
		//driver.navigate().forward();
		//driver.close();
	}
	@Test
	public void testBaidu(){
		WebDriver driver = new FirefoxDriver(); 
		driver.manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		//driver.manage().window().maximize();//浏览器放到最大
		//driver.navigate().to("http://www.baidu.com");
		//driver.findElement(By.linkText("新建")).click();
		
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.close();
		//单独找一个元素并操作：
		/*WebElement element = driver.findElement(By.className("mnav"));
		element.click();//链接的话可以点一下*/
		//element.sendKeys("hello");//如果是文本框的话，可以输入一下内容
		//找多个元素，取集合中的每一个元素并进行点击。
		 java.util.List<WebElement> list=driver.findElements(By.className("mnav"));//List集合
		 //Iterator iter =(Iterator) list.iterator();
		 java.util.Iterator<WebElement> iter1=list.iterator();
		 while(iter1.hasNext()){
			 iter1.next().click();
		 }
		// List lista = (List) driver.findElements(By.className("mnav"));
		driver.navigate().back();
	}
}
