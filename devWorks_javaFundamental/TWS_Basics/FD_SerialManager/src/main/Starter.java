package main;

import mfa_generator.G_A_FlowClass;
import mfb_verifier.V_A_FlowClass;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ACCESS INFO >> " + Starter.class.getName());
		Prompter class_Prompter = new Prompter();
		AnswerGetter class_AnswerGetter = new AnswerGetter();

		mainMenuPrompt();
		String mainAnswer = (String) class_AnswerGetter.mf001();

		switch (mainAnswer) {
		case "1":
			G_A_FlowClass class_G_A_FlowClass = new G_A_FlowClass();
			class_G_A_FlowClass.mainFlow();
			break;

		case "2":
			V_A_FlowClass class_V_A_FlowClass = new V_A_FlowClass();
			class_V_A_FlowClass.mainFlow();
			break;

		case "q":
			System.out.println("Goodbye              -Made by HK.Kim");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	public final String accessInfo = "ACCESS INFO >> ";

	public void promptBringer(int promptNumber) {
		System.out.println("ACCESS INFO >> " + this.getClass().getName());

		switch (promptNumber) {
		case 1:
			mainMenuPrompt();
			break;

		default:
			System.out.println("WARNING INFO >> Cannot Find Prompt!");
			break;
		}
	}

	private static void mainMenuPrompt() {
		System.out.println("====================================");
		System.out.println("========== Serial Manager ==========");
		System.out.println("====================================");
		System.out.println("");
		System.out.println("1. Generate Serial");
		System.out.println("2. Verify Serial");
		System.out.println("");
		System.out.println("q. Terminate Program");
		System.out.println("");
		System.out.println("====================================");
	}

}
