package junit.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.JUnit4;

//@RunWith(BlockJUnit4ClassRunner.class)
@RunWith(value = JUnit4.class)
public class DemoJunit1 {
	@Test
	public void demo(){
		System.out.println("=======");
	}
}
