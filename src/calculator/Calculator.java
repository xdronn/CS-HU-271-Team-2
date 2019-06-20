package calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		  
			System.out.println("Please type your arithmethic expression:");
			Scanner s = new Scanner(System.in);
			Evaluator eval = new Evaluator();
			while(true) {
				String input = s.nextLine();
				String output = eval.getResult(input);
				System.out.println(output);
			}
			
		
	}

}
