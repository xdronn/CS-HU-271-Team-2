package calculator;

/**
 * The purpose of this class is to evaluate a string of input and to return an
 * output string.
 */
public class Evaluator {

	/**
	 * Create a new Evaluator
	 */
	public Evaluator() {
	}

	/**
	 * @param input the input string
	 * @return and output string of the result
	 */
	public String getResult(String input) {
		// parse the input
		Parser p = new Parser(input);
		try {
			p.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return the result
		return p.result;
	}

}
