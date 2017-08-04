package test.TTC03_horseGame;

public class Horse implements Runnable {
	private int horse_num;

	public Horse(int horse_num) {
		this.horse_num = horse_num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long sleepTime = (long) (Math.random() * 500);
		System.out.println("No." + horse_num + " horse sleeps for " + sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		for (int i = 1; i <= 10; i++) {
			System.out.println("The horse No." + horse_num + " is now on" + 100 * i + "meters");
		}
		System.out.println("The horse No." + horse_num + " has finished the race!");
	}

}
