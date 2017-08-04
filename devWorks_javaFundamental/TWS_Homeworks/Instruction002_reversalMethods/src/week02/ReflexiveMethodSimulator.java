package week02;


public class ReflexiveMethodSimulator {

	public void coreFlow() {
		/*
		 * 등비수열
		*/
		// geometricProgress(10, startNumber);
		
		/*
		 * 피보나치수열
		*/
		// 반복 횟수
		int revivalCount = 10;
		
		// for문을 이용해서 각 횟수의 결과값을 출력한다.
		// 근데 for문을 써도 되는건가..;;;;
		for(int i=0 ; i<=revivalCount ; i++){
			System.out.println(fibonacciProgress(i));
		}
		
		
	}
	// 피보나치수열
	int fibonacciProgress(int count) {
		// 카운트(파라미터) 값 0부터 1까지
		if(count<=1){
			return count;
			
		// 카운트(파라미터) 값 2부터	
		}else{
			// 현재 카운트 횟수 차의 전전차와 전차를 합한다. 피보나치의 공식.
			return fibonacciProgress(count-2) + fibonacciProgress(count-1);
		}
	}

	// 등비수열
	boolean geometricProgress(int count, int startNumber) {
		System.out.println("<<등비수열>>");
		int printNumber = startNumber * 2;
		System.out.println(printNumber);
		if (count >= 0) {
			return geometricProgress(count - 1, printNumber);
		} else {
			System.out.println("");
			return false;
		}
	}

}
