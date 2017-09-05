package mainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Your Num : ");
		int askNum = scanner.nextInt();
		int resultNum = shiftyCal(askNum);
		System.out.println("\nresult = " + resultNum);
	}

	private static int shiftyCal(int askNum) {
		int result = 0;

		for (int i = 1; i <= askNum; i++) {
			if (i % 2 == 0) {
				result -= i;
				System.out.println(result + " <<= -" + i);
			} else {
				result += i;
				System.out.println(result + " <<= +" + i);
			}
		}

		return result;
	}

}
