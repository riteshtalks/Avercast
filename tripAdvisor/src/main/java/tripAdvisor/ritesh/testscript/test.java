package tripAdvisor.ritesh.testscript;

import org.testng.annotations.Test;

import tripAdvisor.ritesh.testbase.TestBase;

public class test extends TestBase {
	
	@Test
	public void test() {
		driver.get("https://www.tripadvisor.in/");
	}
	
}
