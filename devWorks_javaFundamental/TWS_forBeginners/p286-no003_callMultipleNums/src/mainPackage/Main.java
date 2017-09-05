package mainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Your number : ");
		int askNum = scanner.nextInt();

		printMultiNums(askNum);

	}

	private static void printMultiNums(int _askNum) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(_askNum + " x " + i + " = " + _askNum * i);
		}
	}

}
