package mainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Your Number : ");
		int askNum = scanner.nextInt();
		
		plessSum(askNum);
	}
	
	private static void plessSum(int _askNum) {
		int result = 0;
		for(int i=1 ; i<=_askNum;i++) {
			if(i%5 !=0) {
				result+=i;
				System.out.println(result + " <<= + " + i);
			} else {
				System.out.println("Skip " + i);
			}
		}
		
		System.out.println("\nresult : " + result);
	}

}
