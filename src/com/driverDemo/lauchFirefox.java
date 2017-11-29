package com.driverDemo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class lauchFirefox {
	private static WebDriver ffwb =null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	
	@BeforeClass
	public void startFirefox(){
		//如果浏览器
		//System.setProperty("webdriver.firedox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//将firebug及firepath也装进来，方便调试。需要插件支持
		File firebug = new File(projectpath+"/tool/firebug.xpi");
		File firepath = new File(projectpath+"/tool/FireXPath.xpi");
		firefoxprofile = new FirefoxProfile();
		try{
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", true);
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.19");
			//代理
			//firefoxprofile.setPreference("network.proxy.type", 0);
			//firefoxprofile.setPreference("network.proxy.http", "10.1.1.0");
			//firefoxprofile.setPreference("network.proxy.http_port", 3128);
		}catch(IOException e){
			e.printStackTrace();
		}
	
		//ffwb=new FirefoxDriver();
		//ffwb = new FirefoxDriver(firefoxprofile);
	}

	
	@Test
	public void serchOnBaidu(){
		ffwb = new FirefoxDriver(firefoxprofile);
		ffwb.get("http://www.baidu.com");
		//提示证书不合法等问题
		//iewb.get("javascript:document.getElementById('overridelink').click();");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}	
	}
	@AfterClass
	public void releasechromeDriver(){
		
		ffwb.quit();
	}
}
