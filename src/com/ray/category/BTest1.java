package com.ray.category;



import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BTest1 {
//断言
	@Test
	public void test(){
		String name = "ray";
		//assertTrue("ray not contains 4",name.contains("4"));
		assertEquals("登录失败","ray","ry");
		//比如点击登录后，跳转到一个页面，看看是否成功，可以检查登录界面是不是有张三。期望值，取到的实际值放后面。
		
	}

}
