package com.shareku.sort;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.MethodSorters;
//@FixMethodOrder(value=MethodSorters.NAME_ASCENDING)//通过测试方法名，升序
//@FixMethodOrder(value=MethodSorters.DEFAULT)//默认的，随机不可预知的
//@FixMethodOrder(value=MethodSorters.JVM)//定义的//按测试方法排序，jvm的顺序
@RunWith(value=BlockJUnit4ClassRunner.class)
//默认有个这样的参数，当
public class TestFixMethodOrder {
	@Test
	public void aTest(){
		System.out.println("atest");
	}
	@Test
	public void cTest(){
		System.out.println("ctest");
	}
	@Test
	public void dTest(){
		System.out.println("dtest");
	}
	@Test
	public void bTest(){
		System.out.println("btest");
	}
}

