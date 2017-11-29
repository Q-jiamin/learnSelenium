package dddm.para;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver;
	private int timeout = 10;
	
	public Wait(WebDriver driver){
		this.driver = driver;
	}
	//等待元素可操作
	public void waitForElementPresents(String locator){
		try{(new WebDriverWait(driver,timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}catch(Exception e){
		
	 }
  }
	//等待元素可启用
	public void waitForElementEnable(String locator){
		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	//直接等待几秒
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
