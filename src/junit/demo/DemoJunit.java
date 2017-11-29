package junit.demo;

import org.junit.Test;

public class DemoJunit {
	@Test(expected=ArithmeticException.class)//需要抛出异常就这样写
	public void demo(){
		int i =1;
		int j = 0;
		double res = i/j;
		//assertTrue(true);
	}
	//测试一些socket程序，模拟一个server发送一个请求，等待请求返回，测试性能，返回时间.做性能比较麻烦。需要自己来写
	//testNg会好一些，能有线程。
	@Test(timeout=5000)
	public void testTimeout() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
