package calculator;

/**
 * Context for the parser
 */
public class Context {
	/**
	 * Previous answer from calculator
	 */
	public Double ans;

	/**
	 * Create new context
	 */
	public Context() {
		ans = 0.0;
	}
}
