package TestNGSessions;

import org.testng.annotations.Test;
//priority is integer, so can take - and 0 and priority goes to smallest integer
//tests without priority comes first in alphabetic order
public class PriorityTest {
	@Test(priority=1)
	public void test1() {
		System.out.println("Test1");
	}
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	@Test(priority=0)
	public void test3() {
		System.out.println("Test3");
	}
	@Test
	public void test4() {
		System.out.println("Test4");
	}
	@Test(priority=-1)
	public void test5() {
		System.out.println("Test5");
	}
}
