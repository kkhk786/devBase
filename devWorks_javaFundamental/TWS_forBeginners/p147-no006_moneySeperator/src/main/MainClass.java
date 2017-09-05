package main;

import input.InputReader;
import logics.Logic;
import prompt.PN001_aboutTheAmountOfMoney;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PN001_aboutTheAmountOfMoney pn001 = new PN001_aboutTheAmountOfMoney();
		InputReader ir = new InputReader();

		int aom = 0;

		pn001.putPrompt();
		aom = ir.inputReader();

		Logic logic = new Logic(aom);
		logic.doLogic();

	}

}
