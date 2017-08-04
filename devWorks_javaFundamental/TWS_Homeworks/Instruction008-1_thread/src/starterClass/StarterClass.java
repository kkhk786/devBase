package starterClass;

import subject.Example;
import test.TTC01;
import test.TTC02_A_withoutThreadA;
import test.TTC02_A_withoutThreadB;
import test.TTC02_B_withThreadA;
import test.TTC02_B_withThreadB;
import test.TTC02_C_implementsRunnableA;
import test.TTC02_C_implementsRunnableB;
import test.TTC03_horseGame.Horse;

public class StarterClass {

	public static void main(String[] args) {

		// Example ex = new Example();
		// ex.exMethod1();
		// ex.exMethod2();

		// TTC01 ttc01 = new TTC01();
		// ttc01.run();

		/* 	without thread
		 	it runs blueFlag only.*/
		// TTC02_A_withoutThreadA ttc02a = new TTC02_A_withoutThreadA();
		// TTC02_A_withoutThreadB ttc02b = new TTC02_A_withoutThreadB();
		// ttc02a.blueFlag();
		// ttc02b.whiteFlag();

		/* 	with thread. (extends Thread)
		 	It runs both.*/
		// TTC02_B_withThreadA ttc02ba = new TTC02_B_withThreadA();
		// TTC02_B_withThreadB ttc02bb = new TTC02_B_withThreadB();
		// ttc02ba.start();
		// ttc02bb.start();

		/* 	with thread. (implements Runnable)
			It runs both too.*/
		// TTC02_C_implementsRunnableA ttc02cA = new TTC02_C_implementsRunnableA();
		// TTC02_C_implementsRunnableB ttc02cB = new TTC02_C_implementsRunnableB();
		// Thread t1 = new Thread(ttc02cA);
		// Thread t2 = new Thread(ttc02cB);
		//
		// t1.start();
		// t2.start();
		
		/*
		 * Horse game test
		*/
		
		Thread t1 = new Thread(new Horse(1));
		Thread t2 = new Thread(new Horse(2));
		Thread t3 = new Thread(new Horse(3));
		Thread t4 = new Thread(new Horse(4));
		Thread t5 = new Thread(new Horse(5));
		Thread t6 = new Thread(new Horse(6));
		Thread t7 = new Thread(new Horse(7));
		Thread t8 = new Thread(new Horse(8));
		Thread t9 = new Thread(new Horse(9));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
		System.out.println("Terminates main() method...");

	}

}
