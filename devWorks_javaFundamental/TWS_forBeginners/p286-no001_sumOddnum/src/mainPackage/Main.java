package mainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Your Number : ");
		int askNum = scanner.nextInt();
		int resultNum = function(askNum);
		System.out.println("\nresult : " + resultNum);
	}

	private static int function(int askNum) {
		int calVar = 0;
		for (int i = 1; i <= askNum; i += 2) {
			calVar += i;
			System.out.print(calVar + " <<= +" + i + "\n");
		}
		return calVar;
	}

}
