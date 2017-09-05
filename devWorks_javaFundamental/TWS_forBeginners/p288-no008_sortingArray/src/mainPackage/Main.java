package mainPackage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array01 = { 45, 67, 89, 12, 56, 90, 64, 79, 55 };
		int[] array02 = { 35, 97, 56, 85, 65, 77, 88, 90, 51 };
		int[] array03 = { 45, 67, 89, 43, 56 };

		sorter(array01);
		sorter(array02);
		sorter(array03);

	}

	private static void sorter(int[] _array) {
		System.out.println("============================");

		// print before sorting
		System.out.println("before>>");
		for (int d = 0; d < _array.length; d++) {
			System.out.print(_array[d] + " ");
		}
		System.out.println("");

		int temp = 0;

		// sorting
		for (int h = 0; h < _array.length; h++) {
			for (int i = 0; i < _array.length - 1; i++) {
				if (_array[i] > _array[i + 1]) {
					temp = _array[i + 1];
					_array[i + 1] = _array[i];
					_array[i] = temp;
				}
			}

		}

		// print after sorting

		System.out.println("after>>");
		for (int d = 0; d < _array.length; d++) {
			System.out.print(_array[d] + " ");
		}
		System.out.println("");

		System.out.println("============================");
	}

}
