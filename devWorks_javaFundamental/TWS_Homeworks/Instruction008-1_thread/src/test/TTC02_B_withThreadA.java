package test;

public class TTC02_B_withThreadA extends Thread {
	public void run() {
		while (true) {
			System.out.println("Raise the BLUE Flag!!!");
		}
	}
}
