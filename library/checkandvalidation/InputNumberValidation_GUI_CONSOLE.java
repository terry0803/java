package Lin.library.checkandvalidation;

import java.util.Scanner;

import javax.swing.*;
import Lin.library.enummenu.NumberType_MenuOption;

/**
 * The Use of Wildcards in Methods that Accept Type Parameters.
 * <p>
 * Title: Library of Color Management System
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 *
 * <p>
 * Company: Mei-Chun Lo
 * </p>
 *
 * @author lo.cms.shu.edu.tw
 * @version 4.0
 * 
 *          <p>
 *          11/Nov/2017 Modified
 *          <p>
 *          24/Sep/2018 Modified
 */
public class InputNumberValidation_GUI_CONSOLE extends JFrame {
	Scanner input;
	public boolean CONSOLE_ON = false;
	public boolean GUI_ON = true;

	private static final long serialVersionUID = 2L;
	public double doubleValue = 0;
	public int intValue = 0;
	public Number numberValue = 0.0;
	public String stringInput = "";

//  public static int INT_NumberType=1, DOUBLE_NumberType=2, FLOAT_NumberType=3;
	public static int INT_NumberType = NumberType_MenuOption.INT_NUMBER_TYPE.getValueIndex(),
			DOUBLE_NumberType = NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex(),
			FLOAT_NumberType = NumberType_MenuOption.FLOAT_NUMBER_TYPE.getValueIndex();
	public int NumberType = 0;
//	public double inputValue = 0.0;
	public String reminder = "";

	public InputNumberValidation_GUI_CONSOLE(boolean ConsoleOn, boolean GuiOn) {
		CONSOLE_ON = ConsoleOn;
		GUI_ON = GuiOn;
		input = new Scanner(System.in);
	}

	public InputNumberValidation_GUI_CONSOLE(int _NumberType, boolean ConsoleOn, boolean GuiOn) {
		NumberType = _NumberType;
		CONSOLE_ON = ConsoleOn;
		GUI_ON = GuiOn;
		input = new Scanner(System.in);
	}

	/**
	 * <p>
	 * Validate input data (string) to be not: Empty
	 */
	public String validateStringNotEmpty(String KeyS) {
		String stringInput = "";
		boolean check_S = false;
		String Qes = "Please enter " + KeyS + "!";

		while (check_S == false) {
			stringInput = JOptionPane.showInputDialog(Qes);
			// JOptionPane.showMessageDialog(null, "stringInput="+stringInput);
			if (stringInput != null)
				check_S = checkStringNotEmpty(stringInput, KeyS);
			else {
				JOptionPane.showMessageDialog(null, "you just cancel the action!");

				System.exit(1);
			}
		} // end while
		return stringInput;

	}// end validate_String_NotEmpty

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
				JOptionPane.showMessageDialog(this, "Re-input " + KeyS + "(Cannot be Empty !)", ex.getMessage(),
						JOptionPane.ERROR_MESSAGE);
			} else {
				System.err.println("\nError in inputing value\n" + reminder);
			}
		} // end try-catch

		return check_S;

	}// end validate_String_NotEmpty

	/**
	 * <p>
	 * Validate input data (Number) to be:
	 * <p>
	 * 1) "equal to or larger than"(i.e. >=) thresheldValue; or
	 * <p>
	 * 2) "equal to or smaller than" (i.e. <=) thresheldValue
	 * <p>
	 * according to value of flagValue2_notEqual;
	 * <p>
	 * Here:
	 * <p>
	 * a) flagValue1_Equal=0; and b) flagValue2_notEqual = +1 and -1 mean ">=", and
	 * "<=" respectively.
	 */
	public Number validateNumberValueByComparing_2flags(String KeyS, Number thresheldValue, int flagValue1_Equal,
			int flagValue2_notEqual, int _NumberType) {
		String NumberData_String;

		boolean check_S_Num = false;
		String Qes = "Please enter " + KeyS + "!";

		while (check_S_Num == false) {
			NumberData_String = JOptionPane.showInputDialog(Qes);
			check_S_Num = checkNumberValueByComparing_2flags(NumberData_String, KeyS, thresheldValue, flagValue1_Equal,
					flagValue2_notEqual, _NumberType);
		} // end while

		return numberValue;
	}// end validate_NumberValueUsingCompare_2flags

	/**
	 * <p>
	 * Check input data (Number) to see if it is:
	 * <p>
	 * 1) "equal to or larger than"(i.e. >=) thresheldValue; or
	 * <p>
	 * 2) "equal to or smaller than" (i.e. <=) thresheldValue
	 * <p>
	 * according to value of flagValue2_notEqual ;
	 * <p>
	 * Here:
	 * <p>
	 * a) flagValue1_Equal=0; and b) flagValue2_notEqual = +1 and -1 mean ">=", and
	 * "<=" respectively.
	 */
	public boolean checkNumberValueByComparing_2flags(String NumberData_String, String KeyS, Number thresheldValue,
			int flagValue1_Equal, int flagValue2_notEqual, int _NumberType) {
		boolean check_S_Num = false;

		if ((checkStringNotEmpty(NumberData_String, KeyS)))// added 24Nov19
		{
			reminder = "";
			try {
				numberValue = parseNumber2TypeNeeded(NumberData_String, _NumberType);

				if ((compareNumber(numberValue, thresheldValue.intValue()) == flagValue1_Equal)
						|| (compareNumber(numberValue, thresheldValue) == flagValue2_notEqual)) {
					check_S_Num = true;
				} else {
					if (flagValue2_notEqual == +1)
						reminder = KeyS + "(>= " + thresheldValue + "!)";
					else
						reminder = KeyS + "(<= " + thresheldValue + "!)";

					throw new NumberFormatException();
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "\nPlease re-input " + reminder, ex.getMessage(),
						JOptionPane.ERROR_MESSAGE);
			} // end try-actch
		}

		return check_S_Num;
	}// end check_NumberValueUsingCompare_2flags

	/**
	 * <p>
	 * Check input data (double) to see if it is: between minValue(>=) and
	 * maxValue(<=)
	 * <p>
	 * 0-->"="; P1--> positive 1, i.e. +1 (>); N1--> negative 1, i.e. -1 (<);
	 */
	public boolean checkNumberValueInRange_min0P1max0N1(String NumberData_String, String KeyS, Number minValue,
			Number maxValue, int _NumberType) throws NumberFormatException {
		boolean check_S_Num = false;

		if ((checkStringNotEmpty(NumberData_String, KeyS)))// added 24Nov19
		{
			reminder = "Re-Input=>" + KeyS + "\n(between " + minValue + "(>=) and " + maxValue + "(<=)!)";
			try {
				numberValue = parseNumber2TypeNeeded(NumberData_String, _NumberType);
				if (((_NumberType == INT_NumberType) && ((numberValue.intValue() <= maxValue.intValue())
						&& (numberValue.intValue() >= minValue.intValue())))
						|| ((_NumberType == DOUBLE_NumberType) && ((numberValue.doubleValue() <= maxValue.doubleValue())
								&& (numberValue.doubleValue() >= minValue.doubleValue())))
						|| ((_NumberType == FLOAT_NumberType) && ((numberValue.floatValue() <= maxValue.floatValue())
								&& (numberValue.floatValue() >= minValue.floatValue())))) {
					check_S_Num = true;
				} else {

					throw new NumberFormatException();
				}
			} catch (NumberFormatException ex) // process invalid number or format
			{
				JOptionPane.showMessageDialog(null, reminder, "Error inputing Number value",
						JOptionPane.INFORMATION_MESSAGE);
			} // end try-actch
		}

		return check_S_Num;
	}// end check_NumberValueInRange_min0P1max0N1

	/**
	 * <p>
	 * Validate input data (double) to see if it is: between minValue(>=) and
	 * maxValue(<=)
	 * <p>
	 * 0-->"="; P1--> positive 1, i.e. +1 (>); N1--> negative 1, i.e. -1 (<);
	 * Modified/Added handling for Cancel btn on 14July19 (see
	 * https://stackoverflow.com/questions/11494222/how-to-handle-cancel-button-in-joptionpane/11494262)
	 * (also https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html)
	 */
	public Number validateNumberValueInRange_min0P1mNumberax0N1(String KeyS, Number minValue, Number maxValue,
			int _NumberType) {
		String NumberData_String;
		boolean check_S_Num = false;
		String Qes = "Enter/Select " + KeyS + " >> ";
		reminder = "You just clicked on CANCEL button!";// use this one will have different results from below one(have
														// a try by swapping both...)

		while (check_S_Num == false) {
//			reminder="You just clicked on CANCEL button!";//use this one will have different results from previous one

			NumberData_String = JOptionPane.showInputDialog(Qes);
			if ((NumberData_String != null) && (NumberData_String.length() > 0)) {
				check_S_Num = checkNumberValueInRange_min0P1max0N1(NumberData_String, KeyS, minValue, maxValue,
						_NumberType);
			} else {
				JOptionPane.showMessageDialog(null, reminder, "CANCELLED", JOptionPane.INFORMATION_MESSAGE);

				System.exit(1);
			}

		} // end while

		return numberValue;
	}// end validate_NumberValueInRange_min0P1max0N1

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

		if ((checkStringNotEmpty(NumberData_String, KeyS)))// added 24Nov19
		{
			reminder = "Re-Input=>" + KeyS;
			try {
				if (_NumberType == INT_NumberType)
					numberValue = Integer.parseInt(NumberData_String);
				else if (_NumberType == DOUBLE_NumberType)
					numberValue = Double.parseDouble(NumberData_String);
				else if (_NumberType == FLOAT_NumberType)
					numberValue = Double.parseDouble(NumberData_String);

				check_S_Num = true;
			} catch (NumberFormatException ex) // process invalid number or format
			{
				if (GUI_ON)
					JOptionPane.showMessageDialog(null, reminder, "Error in inputing value",
							JOptionPane.INFORMATION_MESSAGE);
				else
					System.err.println("\nError in inputing value\n" + reminder);
			} // end try-catch
		}
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
		String Qes = "Enter " + KeyS + "!";

		while (check_S_Num == false) {
			if (GUI_ON)
				NumberData_String = JOptionPane.showInputDialog(Qes);
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
	 * <---Below used Wildcards in Methods that Accept Type Parameters.--->
	 * <p>
	 * Validate Input Number data to be equal to,or larger or smaller than
	 * thresheldValue according to value of flagValue;
	 * <p>
	 * flagValues of 0, +1 and -1 ===> mean "=", ">", and "<" respectively.
	 */
	public Number validateNumberValueByComparing_1flag(String KeyS, Number thresheldValue, int flagValue,
			int _NumberType) {
		String numberData_String;
		boolean check_S_Num = false;
		String Qes = "Please enter " + KeyS + "!";

		while (check_S_Num == false) {
			numberData_String = JOptionPane.showInputDialog(Qes);
			check_S_Num = checkNumberValueByComparing_1flag(numberData_String, KeyS, thresheldValue, flagValue,
					_NumberType);
		} // end while

		return numberValue;
	}// end Number validate_NumberValueUsingCompare_1flag

	/**
	 * <p>
	 * <---Below used Wildcards in Methods that Accept Type Parameters.--->
	 * <p>
	 * Check Input data if equal to, or larger or smaller than thresheldValue
	 * according to the value of flagValue in question;
	 * <p>
	 * flagValues of 0, +1 and -1 ====> mean "=", ">", and "<" respectively.
	 */
	public boolean checkNumberValueByComparing_1flag(String NumberData_String, String KeyS, Number thresheldValue,
			int flagValue, int _NumberType) {
//		reminder = "\nPlease re-input -->" + KeyS;
		boolean check_S_Num = false;
		if ((checkStringNotEmpty(NumberData_String, KeyS)))// added 24Nov19
		{
			reminder = "\nPlease re-input -->" + KeyS;
			try {
//			JOptionPane.showMessageDialog(null, "NumberData_String=" + NumberData_String);
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
						reminder += "(= " + thresheldValue + "!)";
					else if (flagValue == 1)
						reminder += "(> " + thresheldValue + "!)";
					else
						reminder += "(< " + thresheldValue + "!)";

					JOptionPane.showMessageDialog(null, reminder);
					throw new Exception();

				}

			} catch (Exception ex) {
				if (GUI_ON) {

					JOptionPane.showMessageDialog(this, "\n" + reminder, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
				} else {
					System.err.println("\r\nError in inputing value\n" + reminder);// without '\r', the order will be
					// wrong...
				}
			} // end try-catch
		}

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

	/**
	 * Parse String and convert to right type of Number needed
	 */
	public Number parseNumber2TypeNeeded(String NumberData_String, int _NumberType) {
		Number _numberValue = 0;
		if (_NumberType == INT_NumberType)
			_numberValue = Integer.parseInt(NumberData_String);
		else if (_NumberType == DOUBLE_NumberType)
			_numberValue = Double.parseDouble(NumberData_String);
		else if (_NumberType == FLOAT_NumberType)
			_numberValue = Double.parseDouble(NumberData_String);

		return _numberValue;
	}

	public Number validateDataValueInRange(String keyString, double minValue, double maxValue, boolean checkFlagMin0,
			boolean checkFlagMax0, int _typeInt) throws NullPointerException {
		Number _numberValue = 0;
		boolean check_S_Num = false;
		boolean isCancel = false;
		String minValueS = "", maxValueS = "";

		if (_typeInt == INT_NumberType) {
			minValueS = String.valueOf((int) minValue);
			maxValueS = String.valueOf((int) maxValue);
		} else {
			minValueS = String.valueOf(minValue);
			maxValueS = String.valueOf(maxValue);
		}

		String Qes = keyString + "\n(between " +
		/* (_typeInt==INT_NumberType ? (int)minValue: minValue )+ */
				minValueS + (checkFlagMin0 ? "(>=) " : "(>) ") + "and " +
				/* (_typeInt==INT_NumberType ? (int)maxValue: maxValue) + */
				maxValueS + (checkFlagMax0 ? "(<=)!)" : "(<)!)") + "?";
		String data_String = "";

		while (check_S_Num == false && (!isCancel)) {
			if (CONSOLE_ON) {
				System.out.println(Qes);
				data_String = input.next();
			} else// i.e. GUI_ON
			{
				data_String = JOptionPane.showInputDialog(Qes);

				if (data_String != null) {
					isCancel = false;
//					return streamType_MenuOption;
				} else {
					JOptionPane.showMessageDialog(null, "you just cancel the action!");
					isCancel = true;// reset to initial default value (added 16Dec18)
					// System.out.println("Cancel is pressed");
					System.exit(1);
				}

			}
			if (data_String != null)
				check_S_Num = checkDataValueInRange(data_String, keyString, minValue, maxValue, checkFlagMin0,
						checkFlagMax0, _typeInt);

		} // end while

		if (!isCancel)
			_numberValue = parseNumber2TypeNeeded(data_String, _typeInt);
		else
			return null;

		return _numberValue;
		// return check_S_Num;
	}// end Number validateDataValueInRange

	public boolean checkNumberValueInRange_min0P1max0N1(String data_String, String keyString, double minValue,
			double maxValue, boolean checkFlagMin0, boolean checkFlagMax0, int _typeInt) {

		boolean check_S_Num = false;
		NumberType = _typeInt;

		check_S_Num = TryCatchInRange(data_String, keyString, minValue, maxValue, checkFlagMin0, checkFlagMax0,
				_typeInt);

		numberValue = 0.0;// re-zero?????
		return check_S_Num;
	}// end boolean checkDataValueInRange

	/**
	 * <summary> Checks the data value in range. </summary>
	 * 
	 * @param data_String   <param name="data_String">The data_ string.</param>
	 * @param keyString     <param name="keyString">The key string.</param>
	 * @param minValue      <param name="minValue">The minimum value.</param>
	 * @param maxValue      <param name="maxValue">The maximum value.</param>
	 * @param checkFlagMin0 <param name="checkFlagMin0">if set to 0<c>true: >=min;
	 *                      false: > min </c> [check flag min0].</param>
	 * @param checkFlagMax0 <param name="checkFlagMax0">if set to 0<c>true: <=max;
	 *                      false: < max </c> [check flag max0].</param>
	 * @param _typeInt
	 * @return true or false.
	 */
	public boolean checkDataValueInRange(String data_String, String keyString, double minValue, double maxValue,
			boolean checkFlagMin0, boolean checkFlagMax0, int _typeInt) {

		boolean check_S_Num = false;
		NumberType = _typeInt;

		check_S_Num = TryCatchInRange(data_String, keyString, minValue, maxValue, checkFlagMin0, checkFlagMax0,
				_typeInt);

		numberValue = 0.0;// re-zero?????
		return check_S_Num;
	}// end boolean checkDataValueInRange

	public boolean TryCatchInRange(String data_String, String keyString, double minValue, double maxValue,
			boolean flagMin0, boolean flagMax0, int _NumberType) {
		boolean check_S_Num = false;
		reminder = "Re-input/Check " + keyString + "\n(between " + minValue + (flagMin0 ? "(>=) " : "(>) ") + "and "
				+ maxValue + (flagMax0 ? "(<=)!)" : "(<)!)");
		// JOptionPane.showMessageDialog("reminder:" + reminder);

		try {

//			judgeTypeInsideTryClause(data_String);//OK too

			numberValue = parseNumber2TypeNeeded(data_String, _NumberType);

			if ((flagMin0 ? (numberValue.doubleValue() >= minValue) : (numberValue.doubleValue() > minValue))
					&& (flagMax0 ? (numberValue.doubleValue() <= maxValue) : (numberValue.doubleValue() < maxValue))) {
				check_S_Num = true;

			} else {
				throw new Exception();
			}
		} catch (Exception ex) {

			if (CONSOLE_ON)
				System.out.println(ex + "\r\n" + reminder);

			if (GUI_ON)
				JOptionPane.showMessageDialog(this, reminder, "Re-input/Check" /* ex.toString() */,
						JOptionPane.ERROR_MESSAGE);

		} // end try-catch

		// JOptionPane.showMessageDialog("check_S_Num="+ check_S_Num);
		// JOptionPane.showMessageDialog("inputValue="+inputValue);
		return check_S_Num;
	}// end boolean TryCatchInRange

	public void judgeTypeInsideTryClause(String dataInString) {

		if (NumberType == INT_NumberType) {
			intValue = Integer.parseInt(dataInString);
			numberValue = intValue;
		} else if (NumberType == DOUBLE_NumberType) {
			doubleValue = Double.parseDouble(dataInString);

			numberValue = doubleValue;
		}
		// MessageBox.Show("inputValue=" + inputValue);
	}// end void judgeTypeInsideTryClause
}// end class InputNumberDataValidation_GUI
