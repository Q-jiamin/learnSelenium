package testName;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NewTest {
  @Test
  public void testAdd() {
	  	String str="Hello here is TestNg";
	  	assertEquals("Hello here is TestNg",str);
  }
}
