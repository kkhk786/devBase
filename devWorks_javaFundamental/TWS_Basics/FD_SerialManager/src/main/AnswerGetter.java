package main;

import java.util.Scanner;

public class AnswerGetter {
	
	public String mf001() {
		String result = null;
		System.out.println("Your answer : ");
		Scanner scanner = new Scanner(System.in);
		result = scanner.nextLine();
		System.out.println("");
		
		return result;
	}
	
}
