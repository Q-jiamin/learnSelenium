package com.ray.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BTest {
	@Category(Fast.class)
	@Test
	public void b1(){
		System.out.println("Hi,b1");
	}
	@Category(Slow.class)
	@Test
	public void b2(){
		System.out.println("Hi,b2");	
	}
}
