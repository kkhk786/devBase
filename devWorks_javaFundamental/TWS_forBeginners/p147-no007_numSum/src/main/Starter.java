package main;

import java.util.Scanner;

public class Starter {
	public static void main(String[] args) {
		int result = 0;
		System.out.print("Your number : ");
		Scanner scanner = new Scanner(System.in);
		String testStr = scanner.nextLine();
		int[] singleChars = new int[testStr.length()];

		for (int i = 0; i < testStr.length(); i++) {
			singleChars[i] = Integer.parseInt(testStr.substring(i, i + 1));
		}

		for (int j = 0; j <= testStr.length() - 1; j++) {
			result = result + singleChars[j];
		}
		System.out.println("Result : " + result);

	}
}
