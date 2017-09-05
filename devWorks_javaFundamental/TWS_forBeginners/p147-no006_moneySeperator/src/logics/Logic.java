package logics;

public class Logic {
	int aom;

	final int[] bills = { 100000, 10000, 5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1 };

	public Logic(int aom) {
		super();
		this.aom = aom;
	}

	public void doLogic() {
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] <= aom) {
				System.out.println(bills[i] + "bill : x" + aom / bills[i]);
				aom = aom % bills[i];
			}
		}
	}

	public int getAom() {
		return aom;
	}

	public void setAom(int aom) {
		this.aom = aom;
	}

	@Override
	public String toString() {
		return "Logic [aom=" + aom + "]";
	}

}
