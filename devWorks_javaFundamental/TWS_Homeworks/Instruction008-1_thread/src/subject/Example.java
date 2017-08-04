package subject;

public class Example {

	public void exMethod1() {
		for (int i = 0; i < 100000; i++) {
			if (i == 99999) {
				System.out.println(i);
			}
		}
		System.out.println("hello world");
	}

	public void exMethod2() {
		new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				if (i == 99999) {
					System.out.println(i);
				}
			}
		}).start();
		System.out.println("hello world");
	}
}
