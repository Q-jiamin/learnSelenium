package dddm;

import static org.testng.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testdemo {
	/*@BeforeClass
	public void testLogin(){
		//System.setProperty("webdriver.chrome.driver", "D:/eclipseworkplace/learnSelenium1/resources/chromedriver1.exe");
		//WebDriver driver =new ChromeDriver();
		//登录进销存首页
		WebDriver driver =new FirefoxDriver();
		driver.get("http://test2.diandianwaimai.com:6030");
		WebElement merchantId = driver.findElement((By.cssSelector("input[placeholder='商户号']")));
		merchantId.clear();
		merchantId.sendKeys("10068");
		WebElement loginName = driver.findElement(By.cssSelector("input[placeholder='工号']"));
		loginName.clear();
		loginName.sendKeys("admin");
		driver.findElement(By.cssSelector("input[placeholder='密码']")).sendKeys("admin");
		driver.findElement(By.className("login-buttom")).click();
		
			  driver.findElement(By.id("search-box")).clear();
	  driver.findElement(By.xpath("//b[text()='登录']")).click();
	  String str = driver.findElement(By.cssSelector("#tasks div a:nth-child(2)")).getText();
	  assertEquals("新建",str);
	}*/
	@Test
	public void testRolemanage(){
		//登录进销存界面
		WebDriver driver =new FirefoxDriver();
		driver.get("http://test2.diandianwaimai.com:6030");
		WebElement merchantId = driver.findElement((By.cssSelector("input[placeholder='商户号']")));
		merchantId.clear();
		merchantId.sendKeys("10068");
		WebElement loginName = driver.findElement(By.cssSelector("input[placeholder='工号']"));
		loginName.clear();
		loginName.sendKeys("admin");
		driver.findElement(By.cssSelector("input[placeholder='密码']")).sendKeys("admin");
		driver.findElement(By.className("login-buttom")).click();
		//显示等待页面加载
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.urlContains("archivesManage"));
	/*	WebElement select = driver.findElement(By.xpath("//*[@id='nav']/li[1]/div/span"));
		wait.until(ExpectedConditions.elementToBeSelected(select));*/
		System.out.println("跳转到档案管理界面");
		//定位到角色管理界面,断言是否页面正确
		driver.get("http://test2.diandianwaimai.com:6030/systemMaintenance#/roleManage");
		driver.findElement(By.xpath("//*[@id='nav']/li[7]/div/span")).click();
		
		String roleManageTitle = driver.findElement(By.xpath("//*[@id='nav']/li[7]/ul/li[1]")).getText();
		assertEquals("角色管理",roleManageTitle);
		//新增角色
		driver.findElement(By.xpath("//*[@id='contentArea']/section/div[1]/div[1]/span")).click();
		
	}
}
