package calculator;

/**
 * The purpose of this class is to evaluate a string of input and to return an
 * output string.
 */
public class Evaluator {

	/**
	 * The context for the parser
	 */
	private Context ctx;

	/**
	 * Create a new Evaluator
	 */
	public Evaluator() {
		ctx = new Context();
	}

	/**
	 * @param input the input string
	 * @return and output string of the result
	 */
	public String getResult(String input) {
		// parse the input
		Parser p = new Parser(input, ctx);
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
