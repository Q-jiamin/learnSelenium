package junit.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JunitDemo {
	private static String name;
	private static String password;
	@BeforeClass
	public static void before(){
		System.out.println("beforeclass");
		name ="ray";
		password ="123";
      //用这个初始化一些全局的	
	}
	@AfterClass
	//必须是静态的，块,只执行一次。比如使用所有测试方法使用同一变量。
	public static void after(){
		System.out.println("afterclass");
	}
	
	//test执行之前执行
	@Before
	public void setUp(){
		System.out.println("before");
		//如启动浏览器，实例化浏览器 web
	}
	@After
	public void testDown(){
		System.out.println("after");
		//如退出浏览器
	}
	@Test
	public void test01(){                    
		this.name ="ray";
		System.out.println("test01"+":"+this.name+" "+this.password);
		
	}
	@Test
	public void test02(){
		System.out.println("test02"+":"+this.name+" "+this.password);
		
	}
}
