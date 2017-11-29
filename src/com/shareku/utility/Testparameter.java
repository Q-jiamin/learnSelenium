package com.shareku.utility;

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
		//return DBUtils.csvDriver("D:\\eclipseworkplace\\learnSelenium1\\src\\com\\shareku\\utility\\userInfo.csv");
//相对路径也可以
		return DBUtils.jdbcDriver("jdbc:mysql://localhost:3306/ray_shop", "ray", "123456");
	}
	@Test
	public void testParameter(){
		System.out.println(username+"-->"+password);
		//每次用迭代的方式将三个运行到。完成参数化
	}
}
