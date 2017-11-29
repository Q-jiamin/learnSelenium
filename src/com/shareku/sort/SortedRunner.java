package com.shareku.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class SortedRunner extends BlockJUnit4ClassRunner {

	public SortedRunner(Class<?> klass) throws InitializationError {
		super(klass);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected List<FrameworkMethod> computeTestMethods(){
		List<FrameworkMethod> list = super.computeTestMethods();//扥到所有测试方法
		//不直接返回list，进行一下排序
		Collections.sort(list,new Comparator<FrameworkMethod>(){
			public int compare(FrameworkMethod f1,FrameworkMethod f2){
				Index o1 =f1.getAnnotation(Index.class);
				Index o2=f2.getAnnotation(Index.class);
				if(o1==null ||o2==null)
					return -1;
				return  o1.value() - o2.value();
			}
		});
		return list;
	}
	//复写权限要变大

}
