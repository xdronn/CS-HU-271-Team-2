package calculatorUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Utilities;

import calculator.Evaluator;

/**
 * Creates a JFrame window that contains the calculator. To launch, use the line
 * "calculatorUI calc = new calculatorUI();" in the "Main" function
 * 
 * @author Dominick Edmonds
 *
 */
public class calculatorUI {
	public String query = "";

	// UI frame/panel Declarations
	private JFrame frame = new JFrame();// The window itself; contains the calculator
	private JPanel numericButtonPanel = new JPanel();
	private JPanel operatorsButtonPanel = new JPanel();
	private JTextArea inputTextBox = new JTextArea();
	private Evaluator eval = new Evaluator();

	// button definitions

	// numbers
	private JButton button0 = new JButton("0");
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	private JButton button5 = new JButton("5");
	private JButton button6 = new JButton("6");
	private JButton button7 = new JButton("7");
	private JButton button8 = new JButton("8");
	private JButton button9 = new JButton("9");
	private JButton buttonDecimal = new JButton(".");
	private JButton buttonAns = new JButton("Ans");

	// operators
	private JButton buttonAdd = new JButton("+");
	private JButton buttonSub = new JButton("-");
	private JButton buttonMult = new JButton("*");
	private JButton buttonDiv = new JButton("/");
	private JButton buttonEql = new JButton("=");
	private JButton buttonClear = new JButton("C");
	private JButton buttonBack = new JButton("<-");

	/**
	 * Constructor for the calculator UI
	 */
	public calculatorUI() {

		// main frame
		frame.setSize(340, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setResizable(false); // keep this?

		// text screen area
		inputTextBox.setSize(310, 100);
		inputTextBox.setLocation(10, 5);
		inputTextBox.setEditable(false);
		frame.add(inputTextBox, BorderLayout.NORTH);

		// Numeric button panel
		numericButtonPanel.setLayout(new GridLayout(0, 3));

		numericButtonPanel.add(button9);
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("9");
			}
		});

		numericButtonPanel.add(button8);
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("8");
			}
		});

		numericButtonPanel.add(button7);
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("7");
			}
		});

		numericButtonPanel.add(button6);
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("6");
			}
		});

		numericButtonPanel.add(button5);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("5");
			}
		});

		numericButtonPanel.add(button4);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("4");
			}
		});

		numericButtonPanel.add(button3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("3");
			}
		});

		numericButtonPanel.add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("2");
			}
		});

		numericButtonPanel.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("1");
			}
		});

		numericButtonPanel.add(buttonAns);
		buttonAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("ans");
			}
		});

		numericButtonPanel.add(button0);
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append("0");
			}
		});

		numericButtonPanel.add(buttonDecimal);
		buttonDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.append(".");
				// TODO: [Issue #5] Limit only one '.' on either side of an operator
			}
		});

		frame.add(numericButtonPanel, BorderLayout.CENTER);

		// Operators button panel
		operatorsButtonPanel.setLayout(new GridLayout(0, 1));

		operatorsButtonPanel.add(buttonBack);
		buttonBack.addActionListener(new ActionListener() {
			/**
			 * I am not sure what the exception possibly being thrown is, but it seems to
			 * work. Code retrieved from StackOverflow
			 * 
			 * @author MadProgrammer via StackOverflow
			 */
			public void actionPerformed(ActionEvent arg0) {
				try {
					Document doc = inputTextBox.getDocument();
					if (doc.getLength() > 0) {
						doc.remove(doc.getLength() - 1, 1);
					}
				} catch (BadLocationException ex) {
					ex.printStackTrace();
				}
			}
		});

		operatorsButtonPanel.add(buttonClear);
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextBox.setText("");
			}
		});

		operatorsButtonPanel.add(buttonAdd);
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: [Issue #5] Enforce only "one in a row"
				inputTextBox.append("+");
			}
		});

		operatorsButtonPanel.add(buttonSub);
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: [Issue #5] Enforce only "one in a row"
				inputTextBox.append("-");
			}
		});

		operatorsButtonPanel.add(buttonMult);
		buttonMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: [Issue #5] Enforce only "one in a row"
				inputTextBox.append("*");
			}
		});

		operatorsButtonPanel.add(buttonDiv);
		buttonDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: [Issue #5] Enforce only "one in a row"
				inputTextBox.append("/");
			}
		});

		operatorsButtonPanel.add(buttonEql);
		buttonEql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: [Issue #7] send string, get result- display result
				try {
					int end = inputTextBox.getDocument().getLength();
					int start;
					start = Utilities.getRowStart(inputTextBox, end);
					while (start == end) {
						end--;
						start = Utilities.getRowStart(inputTextBox, end);
					}
					String text = inputTextBox.getText(start, end - start);
					inputTextBox.append("\n" + eval.getResult(text) + "\n");
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		frame.add(operatorsButtonPanel, BorderLayout.EAST);

		// TODO Function Buttons

		// setup complete, show frame
		frame.setVisible(true);
	}
}
