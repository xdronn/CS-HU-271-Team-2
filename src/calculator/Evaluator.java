package calculator;

public class Evaluator {
	public Evaluator() {}
	public String getResult(String input) {
		Parser p = new Parser(input);
		try {
			p.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.result;
	}
	
}
