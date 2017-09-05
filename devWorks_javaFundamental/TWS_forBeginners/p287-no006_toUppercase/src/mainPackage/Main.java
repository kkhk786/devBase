package mainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Your char : ");
		char testChar = scanner.findInLine(".").charAt(0);
		System.out.println("Converted to : " + toUppercase(testChar));

	}

	private static char toUppercase(char _testChar) {

		char result;
		result = Character.toUpperCase(_testChar);
		return result;
	}

}
