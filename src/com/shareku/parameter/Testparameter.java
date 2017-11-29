package com.shareku.parameter;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class Testparameter {
	private String username;
	private String password;
	public Testparameter(String username,String password){
		this.username=username;
		this.password=password;
		//有几个加几个属性
	}
	@Parameters
	public static Collection<String[]> getData(){
	return Arrays.asList(new String[][]{{"ray","RAY"},{"venus","VENUS"},{"saturn","SATURN"}});
	//二维数组，list转换后返回为list李集，一维数组，参数与构造方法定义的一一对应
	}
	@Test
	public void testParameter(){
		System.out.println(username+"-->"+password);
		//每次用迭代的方式将三个运行到。完成参数化
	}
}
