package com.ray.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;
@Category({Slow.class,Fast.class})//如果传一个则不要加大括号
//可在类上或者方法上，传的参数也是class类型的一个数组，只是作为一个表示，可以是类或者接口
public class ATest {
	@Test
	public void a1(){
		System.out.println("Hi,a");
	}
}
