package com.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ATest.class,BTest.class})
public class SuiteAB {
//直接在这里面运行类a,及B就行了
}
