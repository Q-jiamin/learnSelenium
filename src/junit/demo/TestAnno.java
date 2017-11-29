package junit.demo;

import java.lang.reflect.Method;

public class TestAnno {
	public static void main(String[] args) throws Exception{
		//反射机制：正常通过类实例化一个对象；/通过类找到方法或属性。所有的类都是class类型
		Class<?> c =TestAnno.class;//找到这个类
		Method m =c.getMethod("say",String.class);
		InfoDemo info = m.getAnnotation(InfoDemo.class);//参数为class类型,得到annotation
		String name = info.name();
		int age = info.age();
		String sentence = name+age;
		//反射调用
		m.invoke(c.newInstance(),sentence);
		//前面是类的实例，后面是方法参数
	}
	@InfoDemo(name="ray",age=25)
	public void say(String sentence){
		System.out.println(sentence);
	}
}
//如何定义一个annotation,方法的作用域