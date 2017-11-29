package com.test;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
    /** * 设置火狐路径时，必须在创建驱动之前 * @author zx * */
public class TestWaitA {
    /** * 隐式等待，针对全局，默认时间为3000 */
    @Ignore//忽略
    public void  implicitWait(){
        //设置火狐路径
        System.setProperty("webdriver.firefox.bin", "C:\\software\\Tool\\firefox\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        String url;
        url="http://www.baidu.com";
        //设置访问路径、
        driver.get(url+"/");
        //隐式等待针对全局
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.MILLISECONDS);

        driver.findElement(By.id("kw")).sendKeys("selenium学习");
        driver.findElement(By.id("su")).click();

    }
    /** * 显示等待===webdriverWait 方法一 * 针对将要执行的代码处， */
    @Ignore
    public void showWait(){
        //设置火狐路径
        System.setProperty("webdriver.firefox.bin", "C:\\software\\Tool\\firefox\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        String url;
        url="http://www.baidu.com";
        //设置访问路径、
        driver.get(url+"/");
        //设置显示等待,创建主类、
        WebDriverWait wait=new WebDriverWait(driver, 3000);

        //判断页面上该元素是否存在
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("su")));
            boolean displayed = webElement.isDisplayed();
            //判断该元素是否可见
            System.out.println(displayed+"=============");
            driver.findElement(By.id("kw")).sendKeys("hello");

    }
    /** * 显示等待 ==通过匿名内部类 ===方法二 */
    @Ignore
    public void newShowWait(){
        //设置火狐路径
        System.setProperty("webdriver.firefox.bin", "C:\\software\\Tool\\firefox\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        String url;
        url="http://www.baidu.com";
        //设置访问路径、
        driver.get(url+"/");
        //设置显示等待,创建主类、
        WebDriverWait wait=new WebDriverWait(driver, 3000);

        try {
            //创建匿名内部类 找到元素返回，未找到元素抛出异常 需要抛异常
            WebElement webElementSU = wait.until(new ExpectedCondition<WebElement>() {
                //重写方法
                public WebElement apply(WebDriver driver) {

                    return driver.findElement(By.id("su"));
                }
            });

            //判断该元素是否可见
// webElementSU.isDisplayed();
            System.out.println("su元素的状态为"+webElementSU.isDisplayed());

            driver.findElement(By.id("kw")).sendKeys("hello");
            driver.quit();//退出浏览器
        } catch (Exception e) {
            System.out.println("未找到元素");
        }


    }
    //===============================================================
    /** * ===============显示等待封装============================== */

    public boolean wait(WebDriver driver,long timeout){
        boolean result=true;
        try {
            WebDriverWait wait=new WebDriverWait(driver,timeout);
            wait.until(new ExpectedCondition<WebElement>() {

                public WebElement apply(WebDriver driver) {
                    WebElement findElement = driver.findElement(By.id("su"));
                    return findElement;
                }
            });

        } catch (Exception e) {
            result=false;
        }
        return result;

    }
    /** * 调用封装实现显式等待 */
    @Ignore
    public void interior(){
        //设置火狐路径
        System.setProperty("webdriver.firefox.bin", "C:\\software\\Tool\\firefox\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        String url;
        url="http://www.baidu.com";
        //设置访问路径、
        driver.get(url+"/");

        //调用封装
        boolean findEle = this.wait(driver, 3000);
        if(findEle==true){
            driver.findElement(By.id("kw")).sendKeys("hello");
            System.out.println("代码执行结束");
        }else{
            System.out.println("su元素未找到");
        }
    }


    /** * 自定义实现显示等待 */
    @Test
    public void  nameWait() {
        //设置火狐路径
        System.setProperty("webdriver.firefox.bin", "C:\\software\\Tool\\firefox\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        String url;
        url="http://www.baidu.com";
        //设置访问路径、
        driver.get(url+"/");
        //WebDriverWait实现了fluenWait类 所以我们可以创建该fluentwait类 ，重写里面的unit方法
        FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver);
            //设置多少时间查询一次
            fwait.pollingEvery(10, TimeUnit.MICROSECONDS);
            //设置超时时间
            fwait.withTimeout(5, TimeUnit.SECONDS);
            //重写
            WebElement webElement = fwait.until(new Function<WebDriver,WebElement>(){

                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id("kw"));
                }
            });
            System.out.println(webElement.isDisplayed());
            webElement.sendKeys("一剪梅");
            driver.findElement(By.id("su")).click();


    }

}