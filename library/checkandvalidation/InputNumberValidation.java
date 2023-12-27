package Lin.library.checkandvalidation;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Lin.library.enummenu.NumberType_MenuOption;

/**
 * Modified from "class InputNumberValidation_GUI_CONSOLE".
 * 
 * @author MCLo
 *
 */
public class InputNumberValidation extends JFrame {
	Scanner input;
	public boolean CONSOLE_ON = false;
	public boolean GUI_ON = true;

//	public double doubleValue = 0;
//	public int intValue = 0;
//	public float floatValue=0.0f;

	public Number numberValue = 0.0;
	public String stringInput = "";

//    public static int INT_NumberType=1, DOUBLE_NumberType=2, FLOAT_NumberType=3;
	public static int INT_NumberType = NumberType_MenuOption.INT_NUMBER_TYPE.getValueIndex(),
			DOUBLE_NumberType = NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex(),
			FLOAT_NumberType = NumberType_MenuOption.FLOAT_NUMBER_TYPE.getValueIndex();
	public int NumberType = 0;
	public double inputValue = 0.0;
	public String reminder = "";

	/**
	 * constructor with 2 parameters.
	 * 
	 * @param _consoleOn
	 * @param _guiOn
	 */
	public InputNumberValidation(boolean _consoleOn, boolean _guiOn) {
		CONSOLE_ON = _consoleOn;
		GUI_ON = _guiOn;
		input = new Scanner(System.in);
	}

	/**
	 * constructor with 3 parameters.
	 * 
	 * @param _NumberType
	 * @param ConsoleOn
	 * @param GuiOn
	 */
	public InputNumberValidation(int _NumberType, boolean ConsoleOn, boolean GuiOn) {
		NumberType = _NumberType;
		CONSOLE_ON = ConsoleOn;
		GUI_ON = GuiOn;
		input = new Scanner(System.in);
	}

	/**
	 * Parse String and convert to right type of Number needed
	 * 
	 * @param NumberData_String
	 * @param _NumberType
	 * @return
	 */
	public Number parseNumber2TypeNeeded(String NumberData_String, int _NumberType) {
		Number _numberValue = 0;

		if (_NumberType == INT_NumberType)
			_numberValue = Integer.parseInt(NumberData_String);
		else if (_NumberType == DOUBLE_NumberType)
			_numberValue = Double.parseDouble(NumberData_String);
		else if (_NumberType == FLOAT_NumberType)
			_numberValue = Float.parseFloat(NumberData_String);

		return _numberValue;
	}

	/**
	 * <p>
	 * Check input data (Number) to see if it is right format enquired.
	 * 
	 * @param NumberData_String
	 * @param KeyS
	 * @param _NumberType
	 * @return check_S_Num
	 * @throws NumberFormatException
	 */
	public boolean checkNumberValue(String NumberData_String, String KeyS, int _NumberType)
			throws NumberFormatException {
		boolean check_S_Num = false;
		reminder = "Re-Input=>" + KeyS;

		try {
			if (_NumberType == INT_NumberType)
				numberValue = Integer.parseInt(NumberData_String);
			else if (_NumberType == DOUBLE_NumberType)
				numberValue = Double.parseDouble(NumberData_String);
			else if (_NumberType == FLOAT_NumberType)
				numberValue = Float.parseFloat(NumberData_String);

			check_S_Num = true;
		} catch (NumberFormatException/* Exception */ ex) // process invalid number or format(InputMismatchException is
															// included in 'NumberFormatException')
		{
			if (GUI_ON)
				JOptionPane.showMessageDialog(null, reminder, "Error in inputing value",
						JOptionPane.INFORMATION_MESSAGE);
			else
				System.err.println("\r\nError in inputing value\n" + reminder);
		} // end try-catch

		return check_S_Num;
	}// end check_NumberValue

	/**
	 * <p>
	 * Validate input data (Number) to see if it is right type of Number.
	 * 
	 * @param KeyS
	 * @param _NumberType
	 * @return
	 */
	public Number validateNumberValue(String KeyS, int _NumberType) {
		String NumberData_String = "";
		boolean check_S_Num = false;
		String Qes = "Please enter " + KeyS + " >> ";

		while (check_S_Num == false) {
			if (GUI_ON) {
				NumberData_String = JOptionPane.showInputDialog(Qes);
				/**
				 * Here, maybe it is needed to consider adding some codes for handling the
				 * clicking of cancel btn on showInputDialog...
				 */
			}

			else {
				System.out.print(Qes);
				NumberData_String = input.nextLine();
			}

			check_S_Num = checkNumberValue(NumberData_String, KeyS, _NumberType);
		} // end while

		return numberValue;
	}// end validate_NumberValue

	/**
	 * <p>
	 * Validate input data (string) to be not: Empty
	 * <p>
	 * Modified on 16July19
	 * 
	 * @param KeyS
	 * @return
	 */

	public String validateStringNotEmpty(String KeyS) {
		String stringInput = "";
		boolean check_S = false;
		String Qes = "Please enter " + KeyS + " >> ";

		while (check_S == false) {
			if (GUI_ON) {
				stringInput = JOptionPane.showInputDialog(Qes);
				// JOptionPane.showMessageDialog(null, "stringInput="+stringInput);
			} else {
				System.out.print(Qes);
				stringInput = input.nextLine();
			}
			check_S = checkStringNotEmpty(stringInput, KeyS);
		} // end while
		return stringInput;
	}// validate_String_NotEmpty

	/**
	 * <p>
	 * Check input data (string) to see it is not: Empty
	 */
	public boolean checkStringNotEmpty(String _stringInput, String KeyS) {
		boolean check_S = false;
		reminder = "Re-input " + KeyS + "(Cannot be Empty !)";

		try {
			if (!(_stringInput.isEmpty())) {
				check_S = true;
				stringInput = _stringInput;
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			if (GUI_ON) {
				JOptionPane.showMessageDialog(this,  "Re-input " + KeyS + "(Cannot be Empty !)",
						ex.getMessage(),
						JOptionPane.ERROR_MESSAGE);
			} else {
				System.err.println("\r\nError in inputing value\n" + reminder);// without '\r', the order will be
																				// wrong...
			}
		} // end try-catch

		return check_S;

	}// validate_String_NotEmpty

	/**
	 * <p>
	 * <---Below used Wildcards in Methods that Accept Type Parameters.--->
	 * <p>
	 * Check Input data if equal to,or larger or smaller than thresheldValue
	 * according to value of flagValue;
	 * <p>
	 * flagValues of 0, +1 and -1 ====> mean "=", ">", and "<" respectively.
	 */
	public boolean checkNumberValueByComparing_1flag(String NumberData_String, String KeyS, Number thresheldValue,
			int flagValue, int _NumberType) {
		reminder = "";
		boolean check_S_Num = false;
		try {
			if (_NumberType == INT_NumberType)
				numberValue = Integer.parseInt(NumberData_String);
			else if (_NumberType == DOUBLE_NumberType)
				numberValue = Double.parseDouble(NumberData_String);
			else if (_NumberType == FLOAT_NumberType)
				numberValue = Float.parseFloat(NumberData_String);

			if (compareNumber(numberValue, thresheldValue) == flagValue) {
				check_S_Num = true;
			} else {
				if (flagValue == 0)
					reminder = KeyS + "(= " + thresheldValue + "!)";
				else if (flagValue == +1)
					reminder = KeyS + "(> " + thresheldValue + "!)";
				else
					reminder = KeyS + "(< " + thresheldValue + "!)";

				throw new Exception();
			}
		} catch (Exception ex) {
			if (GUI_ON) {
				JOptionPane.showMessageDialog(this, "\nPlease re-input " + reminder, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			} else {
				System.err.println("\r\nError in inputing value\n" + reminder);// without '\r', the order will be
				// wrong...
			}

		} // end try-catch

		return check_S_Num;
	}// end check_NumberValueUsingCompare_1flag

	/**
	 * <p>
	 * <---Below used Wildcards in Methods that Accept Type Parameters.--->
	 * <p>
	 * compare 2 Number values of a and to decide if:
	 * <p>
	 * 1) a < b--> return -1;
	 * <p>
	 * 2) a > b--> return +1;
	 * <p>
	 * 3) a = b--> return 0;
	 * 
	 * @param a < b; a > b; a = b;
	 * @return -1 ; +1 ; 0
	 */
	public int compareNumber(Number a, Number b) {
//    	JOptionPane.showMessageDialog(null, "a="+a+"; b="+b);
		if (((a.intValue() < b.intValue())) || ((a.doubleValue() < b.doubleValue()))
				|| ((a.floatValue() < b.floatValue())))
			return -1;
		else if (((a.intValue() > b.intValue())) || ((a.doubleValue() > b.doubleValue()))
				|| ((a.floatValue() > b.floatValue())))
			return +1;
		else
			return 0;

	}// end compareNumber

}
