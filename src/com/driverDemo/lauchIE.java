package com.driverDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class lauchIE {
	private static WebDriver iewb =null;
	private static DesiredCapabilities caps =null;
	private String projectpath = System.getProperty("user.dir");//获取当前项目workplace
	
	@BeforeClass
	public void startIE(){
		System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer_x64_2.53.1.exe");
		//启动ie一定需要iedriver。火狐不需要，可以直接找到bin文件
		caps = DesiredCapabilities.internetExplorer();
		//ie会有一个安全问题，sessionnotfound
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//出现中的cookie,cache会使服务器压力大，最好是用户第一次使用的方式，即隐私模式
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		
		caps.setCapability("ignoreZoomSetting", true);
		iewb = new InternetExplorerDriver(caps);
	}
	@Test
	public void serchOnBaidu(){
		iewb.manage().window().maximize();
		iewb.get("http://www.baidu.com");
		//提示证书不合法等问题
		//iewb.get("javascript:document.getElementById('overridelink').click();");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}	
	}
	@AfterClass
	public void releaseIEDriver(){
		iewb.quit();
	}
}
