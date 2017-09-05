package subject;

public class EX_b implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run start");
		one();
	}
	
	public void one() {
		System.out.println("one!");
		two();
	}
	
	public void two() {
		System.out.println("two!");
		three();
	}
	
	public void three() {
		System.out.println("three!");
	}

}
