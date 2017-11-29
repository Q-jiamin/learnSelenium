package junit.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)//作用域
public @interface InfoDemo {
	public String name();//定义一个name属性,与其他有点不一样
	public int age();
}
