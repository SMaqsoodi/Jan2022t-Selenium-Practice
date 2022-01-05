package SeleniumSessions;

import java.util.Arrays;
import java.util.Scanner;

public class TestOnly {

	final static int x = 2;
	public static void main(String[] args) {
		Scanner test = new Scanner(System.in);
		System.out.println("please enter an interger: ");
		int y = test.nextInt();
		
		int z = (int) Math.pow(x, y);
		System.out.println(z);
		String str = String.valueOf(z);
		System.out.println(str);
		int n = Integer.parseInt(str)/2;
		System.out.println("half of str is: " + n);
		//Object Array;
		String st = "what the hell is going on?";
		int arr[] = new int[2];
		System.out.println(st.indexOf("i", st.indexOf("i")+1)); // 2nd index of a char in a string
		st.indexOf("hell");
		System.out.println(st.replace("hell", "heck"));
	}
	
}
