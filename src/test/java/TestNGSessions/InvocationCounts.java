package TestNGSessions;

import org.testng.annotations.Test;

public class InvocationCounts {
	@Test(invocationCount=10)
	public void creatUser() {
		System.out.println("creating uses test ...");
		// used to hit your API
	}
}

