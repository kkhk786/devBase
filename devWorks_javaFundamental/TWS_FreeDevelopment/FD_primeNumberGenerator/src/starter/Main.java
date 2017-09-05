package starter;

class Main {
	public static void main(String[] args) {
		int var = 11;
		System.out.println(conA(var));
	}

	private static boolean conA(int param) {
		if (param % 2 == 0) {
			return false;
		} else {
			if(conB(param)==true) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private static boolean conB(int param) {
		int [] tempList = new int[param];
		for(int i=0;i<tempList.length;i++) {
			tempList[i]=0;
		}
		return false;
	}
}