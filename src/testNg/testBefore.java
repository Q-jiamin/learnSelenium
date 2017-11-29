package testNg;
import org.testng.annotations.*;

public class testBefore {
	@BeforeTest
	public void beforeTest(){
		System.out.println("befpreTest");
	}
	//针对类里做初始化，比如初始化ie，数据库；method根据脚本做初始化，，如系统登录
	@BeforeClass//只执行一次。即为该类文件需要预先或后置运行的条件，通常用来初始化一些变量或用在设置后置条件如用户退出（after）
	public void beforeClass(){
		System.out.println("beforeClass");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("beforeMethod");
	}
	@Test
	public void test1(){
		System.out.println("case:test1");
	}
	@Test
	public void test2(){
		System.out.println("case:test2");
	}
	@Test
	public void test3(){
		System.out.println("case:test3");
	}
	@Test
	public void test4(){
		System.out.println("case:test4");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("afterMethod");
	}
	//关浏览器，清系统，测试数据删除，恢复smokeTest
	@AfterClass
	public void afterClass(){
		System.out.println("afterclass");
	}
	//每个测试用例执行之前和后需要执行的预先条件和后置条件
	@AfterTest
	public void afterTest(){
		System.out.println("afterTest");
	}
	
}
