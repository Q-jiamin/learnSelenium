package com.shareku.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DBUtilsJDBC {
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