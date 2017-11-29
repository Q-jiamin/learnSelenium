package com.ray.category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
@IncludeCategory(Fast.class)
@RunWith(Categories.class)
@SuiteClasses({ATest.class,BTest.class})
public class CategoryDemo {

}
interface Fast{}
interface Slow{}
//如果想用这两个标识，在某个类或方法上，则必须是类或者接口.规范大写
