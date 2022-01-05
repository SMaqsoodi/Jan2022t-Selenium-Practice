package TestNGSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	//@Test(expectedExceptions = ArithmeticException.class)
	//@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class}) // or simply
	//@Test(expectedExceptions = Exception.class) // or
	@Test(expectedExceptions = Throwable.class)
	public void loginTest() {
		System.out.println("login test starting ...");
		int i = 9/0;
		System.out.println("login test ending ..."); // this line is not printed. because we can't break java's rules. we can use try and catch to solve it
	}
}

