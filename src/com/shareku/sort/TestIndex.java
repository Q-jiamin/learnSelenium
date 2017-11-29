package com.shareku.sort;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SortedRunner.class)
public class TestIndex {
	@Index(value=1)
	@Test
	public void aTest(){
		System.out.println("atest");
	}
	@Index(value=3)
	@Test
	public void cTest(){
		System.out.println("ctest");
	}
	@Index(value=5)
	@Test
	public void dTest(){
		System.out.println("dtest");
	}
	@Index(value=4)
	@Test
	public void bTest(){
		System.out.println("btest");
	}
	@Index(value=2)
	@Test
	public void eTest(){
		System.out.println("etest");
	}
}