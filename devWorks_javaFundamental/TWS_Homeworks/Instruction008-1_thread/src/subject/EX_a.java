package subject;

public class EX_a {
	public void main() {
		// ==================================================
		// System.out.println("main() starts!");
		// Runnable r = new EX_b();
		// Thread ex_b = new Thread(r);
		// ex_b.start();
		// System.out.println("main() ends!");

		// ««««««««««««««««««« print result «««««««««««««««««««
		// main() starts!
		// main() ends!
		// run start
		// one!
		// two!
		// three!
		// ªªªªªªªªªªªªªªªªªªª print result ªªªªªªªªªªªªªªªªªªª

		// ==================================================

		System.out.println(Thread.currentThread().getName() + " start");
		Runnable runnable = new EX_b();
		Thread ex_b = new Thread(runnable);
		
		ex_b.start();
		try {
			ex_b.join();
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
