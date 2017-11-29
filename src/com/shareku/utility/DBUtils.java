package com.shareku.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DBUtils {
	public static List<String[]> jdbcDriver(String url,String user,String pwd){
		List<String[]> list = new ArrayList<String[]>();
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql ="select username,nickname from t_user;";
		//1、加载驱动
		try {
			Class.forName("org.git.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//url，数据库连接地址，不同的不一样
		//jdbc:mysql://localhost:3306/ray_shop ray 123456
		try {
			//得到一个数据库连接对象
			con = DriverManager.getConnection(url, user, pwd);
			//得到一个执行sql语句的对象
			ps =con.prepareStatement(sql);
			//定义一个存放数据结果的对象
			rs = ps.executeQuery();
			//传回来的数据，数组类型
			while(rs.next()){
				String[] users = new String[2];
				users[0] = rs.getString("username");
				users[2] = rs.getString("nickname");
				list.add(users);
				//循环读取
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	//读取csv文件的方法
	public static List<String[]> csvDriver(String filePath){
		List<String[]> list = new ArrayList<String[]>();
		
		InputStream in = null;
		BufferedReader buf = null;
		try {
			in = new FileInputStream(filePath);
			buf = new BufferedReader(new InputStreamReader(in));
			String tmp=null;
			
			while(!(tmp=StringUtils.trimToEmpty(buf.readLine())).equals("")){
				//如果读取为空，跳出这个循环.中间要有空行，直接中断了
				String user[]=tmp.split(",");
				//通过，拆分成数组,数组必须声明在里面
				list.add(user);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			buf.close();//后打开的先关闭
			in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
//用定义的工具来返回方法，写读取数据