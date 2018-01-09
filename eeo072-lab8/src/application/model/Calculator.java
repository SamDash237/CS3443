package application.model;

/**
 * Calculator class handles the model for a basic Java calculator.
 * Modified to include modulus, x^2, 1/x, n factorial, log, ln, square root, e^x, and clear buttons 
 * @author eeo072
 * 
 */
public class Calculator {

	private double displayValue; // the numeric value of the number the user is entering, or the number that was
									// just calculated
	private double internalValue; // the previous value entered or calculated
	private String displayString; // the String corresponding to what the user is entering
	private String operation; // the last operation entered by the user
	private boolean start; // true if the next digit entered starts a new value
	private boolean dot; // true if a decimal dot has been entered for the current value

	public Calculator() {
		displayValue = 0.0;
		displayString = "" + displayValue;
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";
	}

	/**
	 * @return the String value of what was just calculated or what the user is
	 *         entering
	 */
	public String getValue() {
		return displayString;
	}

	/**
	 * @return factorial of the number.
	 */
	public double fact(double n) {
		if (n == 1 || n == 0)
			return 1;
		else {
			return fact(n - 1) * n;
		}
	}

	/**
	 * Clears the calculator screen and starts a new calculation.
	 */
	public void clear() {
		displayValue = 0.0;
		displayString = "" + displayValue;
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";
	}

	/**
	 * Updates the values maintained by the calculator based on the button that the
	 * user has just clicked.
	 * 
	 * @param text
	 *            is the name of the button that the user has just clicked
	 */
	public void update(String text) {
		if (start) {
			internalValue = displayValue;
			displayValue = 0;
			displayString = "";
			start = false;
			dot = false;
		}
		if (text.length() == 1 && "0123456789".indexOf(text) >= 0) {
			displayString += text;
			displayValue = Double.valueOf(displayString);
		} else if (text.equals(".")) {
			if (!dot) {
				dot = true;
				if (displayString.equals("")) {
					displayString = "0";
				}
				displayString += ".";
			}
		} else {
			if (operation.equals("+")) {
				displayValue = internalValue + displayValue;
			} else if (operation.equals("-")) {
				displayValue = internalValue - displayValue;
			} else if (operation.equals("*")) {
				displayValue = internalValue * displayValue;
			} else if (operation.equals("/")) {
				displayValue = internalValue / displayValue;
			} else if (operation.equals("=")) {
				displayValue = internalValue;
			} else if (operation.equals("%")) {
				displayValue = internalValue % displayValue;
			} else if (text.equals("x^2")) {
				if (displayValue == 0)
					displayValue = internalValue * internalValue;
				else
					displayValue = displayValue * displayValue;
			} else if (text.equals("1/x")) {
				if (displayValue == 0)
					displayValue = 1 / internalValue;
				else
					displayValue = 1 / displayValue;

			} else if (text.equals("n!")) {
				if (displayValue == 0)
					displayValue = fact(internalValue);
				else
					displayValue = fact(displayValue);
			} else if (text.equals("log")) {
				if (displayValue == 0)
					displayValue = Math.log10(internalValue);
				else
					displayValue = Math.log10(displayValue);
			} else if (text.equals("ln")) {
				if (displayValue == 0)
					displayValue = Math.log(internalValue);
				else
					displayValue = Math.log(displayValue);
			} else if (text.equals("sqrt")) {
				if (displayValue == 0)
					displayValue = Math.sqrt(internalValue);
				else
					displayValue = Math.sqrt(displayValue);
			} else if (text.equals("e^x")) {
				if (displayValue == 0)
					displayValue = Math.exp(internalValue);
				else
					displayValue = Math.exp(displayValue);
			} else if (text.equals("CLEAR")) {
				clear();
			}

			displayString = "" + displayValue;
			internalValue = displayValue;
			operation = text;
			start = true;
		}
	}
}