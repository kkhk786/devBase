package mainPackage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array01 = { 35, 97, 56, 85, 65, 77, 88, 90, 51 };
		int[] array02 = { 45, 67, 89, 43, 56 };

		sda(array01, array02);

	}

	private static void sda(int[] _array01, int[] _array02) {
		int[] totalArray = new int[_array01.length + _array02.length];

		// put _array01's elements into totalArray
		for (int i = 0; i < _array01.length; i++) {
			totalArray[i] = _array01[i];
		}
		System.out.println("array01 added >>");
		for (int k = 0; k < totalArray.length; k++) {
			System.out.print(totalArray[k] + " ");
		}
		System.out.println("");

		// put _array02's elements into totalArray after _array01's elements
		int j = totalArray.length - _array02.length;
		int l = 0;
		while (j < totalArray.length) {
			totalArray[j] = _array02[l];
			l++;
			j++;
		}
		// before sorting
		System.out.println("array02 added >>");
		for (int k = 0; k < totalArray.length; k++) {
			System.out.print(totalArray[k] + " ");
		}
		System.out.println("");

		// sorting totlaArray
		for (int a = 0; a < totalArray.length; a++) {
			for (int b = 0; b < totalArray.length - 1; b++) {
				int temp = 0;
				if (totalArray[b + 1] < totalArray[b]) {
					temp = totalArray[b + 1];
					totalArray[b + 1] = totalArray[b];
					totalArray[b] = temp;
				}
			}
		}

		// after sorting
		System.out.println("finally sorted >>");
		for (int k = 0; k < totalArray.length; k++) {
			System.out.print(totalArray[k] + " ");
		}

	}

}
