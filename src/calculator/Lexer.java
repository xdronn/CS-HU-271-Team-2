package calculator;

import java_cup.runtime.*;

public class Lexer {
	/* single lookahead character */
	protected int next_char;

	private String input;
	private int curr_pos = 0;

	/* we use a SymbolFactory to generate Symbols */
	private SymbolFactory sf = new DefaultSymbolFactory();

	/* advance input by one character */
	protected void advance() {
		if (curr_pos >= input.length()) {
			next_char = -1;
		} else {
			next_char = input.charAt(curr_pos);
			curr_pos++;
		}
	}

	/* initialize the scanner */
	public void init() {
		advance();
	}

	public Lexer(String input) {
		this.input = input;
	}

	/* recognize and return the next complete token */
	public Symbol next_token() throws java.io.IOException {
		for (;;)
			switch (next_char) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				/* parse a decimal integer */
				int i_val = 0;
				do {
					i_val = i_val * 10 + (next_char - '0');
					advance();
				} while (next_char >= '0' && next_char <= '9');
				return sf.newSymbol("NUMBER", sym.NUMBER, new Double(i_val));

			case ';':
				advance();
				return sf.newSymbol("SEMI", sym.SEMI);
			case '+':
				advance();
				return sf.newSymbol("PLUS", sym.PLUS);
			case '-':
				advance();
				return sf.newSymbol("MINUS", sym.MINUS);
			case '*':
				advance();
				return sf.newSymbol("TIMES", sym.TIMES);
			case '(':
				advance();
				return sf.newSymbol("LPAREN", sym.LPAREN);
			case ')':
				advance();
				return sf.newSymbol("RPAREN", sym.RPAREN);
			case 's':
				if (input.substring(curr_pos, curr_pos + 4).contentEquals("sqrt")) {
					curr_pos += 3;
					advance();
					return sf.newSymbol("SQRT", sym.SQRT);
				}else {
					advance();
					break;
				}

			case -1:
				return sf.newSymbol("EOF", sym.EOF);

			default:
				/* in this simple scanner we just ignore everything else */
				advance();
				break;
			}
	}
};
