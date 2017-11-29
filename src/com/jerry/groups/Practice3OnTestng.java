package com.jerry.groups;

import org.testng.annotations.Test;

public class Practice3OnTestng {
	@Test(groups = "submodule1")
	public void testSubModule1(){
		System.out.println("----testsubModule1---");
	}
	@Test(groups = "submodule2")
	public void testSubModule2(){
		System.out.println("----testsubModule2--");
	}
	@Test(groups = "submodule3")
	public void testSubModule3(){
		System.out.println("----testsubModule3---");
	}
}
