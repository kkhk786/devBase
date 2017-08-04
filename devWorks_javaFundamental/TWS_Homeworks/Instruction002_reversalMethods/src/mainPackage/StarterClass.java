package mainPackage;

//import week01.DaysFinder;
//import week01.DaysFinder2;
import week02.ReflexiveMethodSimulator;

public class StarterClass {
	public static void main(String [] args){
		System.out.println("access info >>> class : /testProject/src/mainPackage/StarterClass.java");
		
		// Week02 : 재귀함수의 활용
		ReflexiveMethodSimulator rms = new ReflexiveMethodSimulator();
		rms.coreFlow();
	}
}
