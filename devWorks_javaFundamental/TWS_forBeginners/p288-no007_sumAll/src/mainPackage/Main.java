package mainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Your Number : ");
		String scanned = scanner.nextLine();
		System.out.println("result : " + sumAll(scanned));
	}

	private static int sumAll(String _scanned) {
		int result = 0;
		int[] tempList = new int[_scanned.length()];
		for (int i = 0; i < _scanned.length(); i++) {
			tempList[i] = Integer.parseInt(_scanned.substring(i, i + 1));
		}
		for (int j = 0; j < tempList.length; j++) {
			System.out.print("result(" + result + ")" + " + " + "sum(" + tempList[j] + ") = ");
			result += tempList[j];
			System.out.println(result);
		}
		System.out.println("");
		return result;
	}
}
