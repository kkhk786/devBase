package test;

public class TTC02_B_withThreadB extends Thread {
	public void run() {
		while (true) {
			System.out.println("Raise the WHITE Flag!!!");
		}
	}
}
