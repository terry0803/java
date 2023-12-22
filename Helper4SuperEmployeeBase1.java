package Lin.polymorphism.employee.helper;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.security.sasl.SaslServer;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Lin.library.checkandvalidation.InputNumberValidation;
import Lin.library.checkandvalidation.InputNumberValidation_GUI_CONSOLE;
import Lin.library.enummenu.Buttons4UniversalProcess_MenuOption;
import Lin.library.enummenu.FileStreamType_MenuOption;
import Lin.library.filestream.FileChoosing4WriteOrRead_20Dec23_extends;
import Lin.library.filestream.OpenFileRecord;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.*;
import Lin.polymorphism.employee.frame.*;
import Lin.polymorphism.employee.menuoption.EarningLevelEnum1;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;
import Lin.library.enummenu.NumberType_MenuOption;

public class Helper4SuperEmployeeBase1 {
	EmployeeBaseJFrame_V0 frameEmployee;
	public int EmployeeNo = 0;
	public String CompanyName = "";

	// initialize variables for grade record used in SuperEmployeeBase.
	String _SSN = "";
	String _firstName = "";
	String _lastName = "";

	// Commission Employee
	public double _grossSales = 0;
	public double _commissionRate = 0.0;

	// BasePlusCommission Employee
	public double _baseSalary = 0;

	// Hourly Employee
	public double _hourlyWage = 0.0;
	public double _rate4ExtraHours = 0.0;
	public double _hoursWorked = 0;
	public double _maxHoursPerWeek = 80.0;
	public double _minRateOfExtraHours = 1.0;
	public double _maxRateOfExtraHours = 2.0;
	public double _MAX_WORKED_HOURS = 168;
	public double _normalHoursWorked = 40.0;

	/**
	 * if using 168--> that is inhuman (people still need some time to sleep, not
	 * working whole week)
	 */

	// Salaried Employee
	public double _weekSalary = 0;

	public int employeeCounter = 0;
	public static DecimalFormat twoDigits = new DecimalFormat("0.00");

	protected boolean checkON = true;
	protected InputNumberValidation validation_GUI = new InputNumberValidation(false, true);// OK
	protected InputNumberValidation_GUI_CONSOLE validationNumber_GUI = new InputNumberValidation_GUI_CONSOLE(false,
			true);

	public boolean checkProfile = false;
	public boolean checkRecord = false;

	static EmployeeBaseJFrame_V0 employeeBaseJFrame = null;
	// public EmployeeBaseBook employeeBook; // kept for reminder--> better not use
	// this one

	public String filePath = "./filePath";
	public static FileChoosing4WriteOrRead fileChoosing4WriteOrRead;public FileChoosing4WriteOrRead_25Dec20 extends FileChoosing4WriteOrRead;

	public ObjectOutputStream outputO;
	public Formatter outputT;
	protected ObjectInputStream inputO;
	protected Scanner inputT;
	public File fileWritten = null /* , fileRead = null */;

	String companyString;
	String employeeNoString;

	public boolean isReadFile = false;
	public boolean isCreateFile = false;
	protected boolean isFileChoosenOK = false;

	static FileStreamType_MenuOption streamType_MenuOption = null;
	public boolean isJOptionPaneUsed = false;// false: use JList; true: use JOptionPane
	public boolean usesSimpleOne = true;
	public boolean useJPane = true;

	ArrayList<CommissionEmployee> eList_Commission = new ArrayList<CommissionEmployee>();
	ArrayList<BasePlusCommissionEmployee> eList_BasePlusCommission = new ArrayList<BasePlusCommissionEmployee>();
	ArrayList<SalariedEmployee> eList_Salaried = new ArrayList<SalariedEmployee>();// this is for creating file.
	ArrayList<HourlyEmployee> eList_Hourly = new ArrayList<HourlyEmployee>();// this is for creating file.

	public Helper4SuperEmployeeBase1(EmployeeBaseJFrame_V0 _frmEmployee) {
		frameEmployee = _frmEmployee;

		/**
		 * Reset buttons in JFrame for new start of payroll system.
		 */
		setUpNewStartUpButtons();

		/**
		 * setup the display
		 */
		setupDistribution4WageLevels();
	}

	public void resetButtons4NewStart(boolean _isEnabled) {
		for (int i = 0; i < frameEmployee.basicChoices.length; i++) {
			frameEmployee.optionButtons[i].setEnabled(_isEnabled); // Assuming to enable or disable
		}
	} // end resetButtons4NewStart

	public void setUpNewStartUpButtons() {
		resetButtons4NewStart(false);
		frameEmployee.btnSetProfile.setEnabled(true);
		frameEmployee.btnExit.setEnabled(true);
		frameEmployee.btnRefresh.setEnabled(true);
		frameEmployee.btnReadFile.setEnabled(true);
	} // end setUpNewStartUpButtons()

	/**
	 * Setup/layout distributions' labels/wordings for wage levels.
	 */
	public void setupDistribution4WageLevels() {
		frameEmployee.lblALowerThreshold.setText("" + EarningLevelEnum1.LevelA.getValue());
		frameEmployee.lblBUpperThreshold.setText("" + EarningLevelEnum1.LevelA.getValue());
		frameEmployee.lblBLowerThreshold.setText("" + EarningLevelEnum1.LevelB.getValue());
		frameEmployee.lblCUpperThreshold.setText("" + EarningLevelEnum1.LevelC.getValue());
		frameEmployee.lblUnit
				.setText("" + EarningLevelEnum1.UNIT.getLevelType() + " (" + EarningLevelEnum1.UNIT.getValue() + ")");
	} // end setupDistribution4WageLevels()

	/**
	 * prepare Basic profile using pre-check. Basic profile includes SSN, first name
	 * and last name for every employee considered either of two processes,
	 * described below, can be considered to obtain basic profile
	 */
	public void prepareBasicProfileUsingCheck() {
		checkProfile = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldCN.getText(),
				EmployeeRecordIndices.COMPANY_NAME.getRecordIndexType());

		if (checkON) {
			JOptionPane.showMessageDialog(null, "employee=" + frameEmployee.getClass());
		}

		if (checkProfile) {
			CompanyName = validationNumber_GUI.stringInput(); // obtain company name (added 24Nov19)
			checkProfile = validationNumber_GUI.checkNumberValueByComparing_1flag(frameEmployee.txtFieldEN.getText(),
					EmployeeRecordIndices.EMPLOYEE_NO.getRecordIndexType(), 0, 1,
					NumberType_MenuOption.INT_NUMBER_TYPE.getValueIndex());
		}

		if (checkProfile) {
			frameEmployee.txtFieldEN.setText("");
		} else {
			EmployeeNo = validationNumber_GUI.numberValue.intValue(); // obtain number of employees (added 24Nov19)
		}

		/**
		 * if basic profile are ready, then Open-File process can start from here
		 * (24Nov19)
		 */
		frameEmployee.btnOpenFile.setEnabled(true);
	}



/**
 * finally-> if everything is ready--> get all input data in profile area.
 * including company name and number of employees considered.
 * However, it seems that below can be commented out or just deleted if those
 * profile data have been obtained/assigned in above process.
 */
// if (checkProfile) { CompanyName = frameEmployee.txtFieldCN.getText();
// EmployeeNo = Integer.parseInt(frameEmployee.txtFieldEN.getText());
// 
// Open File can start from here (01Aug19)
// frameEmployee.btnOpenFile.setEnabled(true);
// }


// prepareBaseProfileUsingCheck()

public void enableProfileTextBoxes(boolean isEnable) {
    boolean condition = false;
    for (JTextField txtField : EmployeeBaseJFrame_V0.listTxtFieldsProfileG) {
        txtField.setEnabled(isEnable);
        condition = !isEnable;
    }

    
    for (JTextField txtField : frameEmployee.listTxtFieldsResultsG) {
        txtField.setEnabled(!isEnable);
    }
    
    
    for (JTextField txtField : EmployeeBaseJFrame_V0.listTxtFieldsEmployeeG) {
        txtField.setEnabled(!isEnable);
        
        if (condition == true) { // If-else: need to confirm if there are something wrong
            //frameEmployee.btnCalculate.setText(Button_MenuOption.Process_Data.name());
        	frameEmployee.btnCalculate.setText(BtnsUniversalProcess_MenuOpAdv.Process_Data.getButtonType());
            frameEmployee.btnSetProfile.setEnabled(false);
        } else {
            //frameEmployee.btnCalculate.setText(Button_MenuOption.Process_Data.name());
        	frameEmployee.btnCalculate.setText(BtnsUniversalProcess_MenuOpAdv.Process_Data.getButtonType());
            frameEmployee.btnSetProfile.setEnabled(true); // false
        }
    }
}

	// ... [further code] ...

	/**
	 * Validate and Check input record data. Here, only consider basic record data
	 * for every employee (including SSN, first name and last name).
	 */
	public void checkInputRecordData() {
		checkRecord = false;

		// Validate SSN is not empty
		checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldSSN.getText(),
				EmployeeRecordIndices.SSN.getRecordIndexType());

		// If SSN is valid, validate First Name is not empty
		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldFN.getText(),
					EmployeeRecordIndices.FIRST_NAME.getRecordIndexType());
		}

		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldLN.getText(),
					EmployeeRecordIndices.LAST_NAME.getRecordIndexType());
		}
	} // end checkInputRecordData

	/**
	 * finally-> if everything is ready-> get all input data in Record area
	 */
	public void getInputDataReady(boolean _checkRecord) {
		if (_checkRecord) {
			_SSN = frameEmployee.txtFieldSSN.getText();
			_firstName = frameEmployee.txtFieldFN.getText();
			_lastName = frameEmployee.txtFieldLN.getText();
		}
	}

	/**
	 * Only exit the one frame-app in question.
	 */
	public void exitAppInQuestion() {
		frameEmployee.dispose();
	} // end exitAppInQuestion()

	public void refreshJFrame(JDesktopPane theDesktop) {
		if (frameEmployee != null) {
			frameEmployee.dispose();
			frameEmployee = frameEmployee.refreshJFrame(theDesktop);

			if (theDesktop != null) {
				theDesktop.add(frameEmployee);
			}

		} else {
			JOptionPane.showMessageDialog(null, "You haven't started anything yet!", "Start Input data first",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void readFile_EmployeeAccount() throws ClassNotFoundException, IOException, ArrayIndexOutOfBoundsException {
		JOptionPane.showMessageDialog(null, "The next file writer chosen is for recording every account record.",
				"Read Account Records", JOptionPane.INFORMATION_MESSAGE);
		ImageIcon icon = new ImageIcon("/resources/images/question_message_120x120.png");

		Object[] options = { true, false };
		InputDialogPanel inputDialodPanel = new InputDialogPanel();
		isJOptionPaneUsed = (boolean) inputDialodPanel.chooseBooleanChoices(options, "Use JOptionPane?");

		streamType_MenuOption = choice4FileStreamType.decideWhichFileStreamType(icon, isJOptionPaneUsed);

		if (streamType_MenuOption != null) {
			/**
			 * Below is for fileChooser used for writing account records
			 */
			fileChoosing4WriteOrRead = new FileChoosing4WriteOrRead_25Dec20_extends(false, true,
					streamType_MenuOption.getValue());
			fileChoosing4WriteOrRead.chooseFile(filePath);
			fileChoosing4WriteOrRead.openFile2Read(streamType_MenuOption.getOptionType());

			if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
				inputO = fileChoosing4WriteOrRead.inputO; // Here, output has been implemented and not 'null'

				// Read basic profile into file(added on 02Aug19)
				companyString = inputO.readObject().toString();
				employeeNoString = inputO.readObject().toString();
			} else {
				inputT = fileChoosing4WriteOrRead.inputT(); // Here output has been implemented and not 'null'

				// Read basic profile into file(added on 02Aug19)
				companyString = inputT.nextLine();
				employeeNoString = inputT.nextLine();
			}
			advancedlyProcessBasics();

			if (fileChoosing4WriteOrRead.result == JFileChooser.APPROVE_OPTION) {
				// System.out.println("I am inside of 'fileChoosing4WriteOrRead.result ==
				// JFileChooser.APPROVE_OPTION'");
				System.out.println("File chosen for Read is successfully opened!");
			}
			isFileChoosenOK = true;

		} else
			JOptionPane.showMessageDialog(null, "You just cancel the action!");
	}

	public boolean decideUseJOptionPaneOrListDialog(Object[] options, String title) {
		InputDialogPanel inputDialodPanel = new InputDialogPanel();
		Object choice = inputDialodPanel.chooseBooleanChoices(options, title);

		return (boolean) choice;
	}

	public void advancedlyProcessBasics() throws ArrayIndexOutOfBoundsException {
		String[] arrOfStr = companyString.split("\t");
		CompanyName = arrOfStr[1];
		frameEmployee.txtFieldCN.setText(CompanyName);
		frameEmployee.txtFieldCN.setEnabled(false);

		arrOfStr = employeeNoString.split("\t");
		EmployeeNo = Integer.parseInt(arrOfStr[1]);
		frameEmployee.txtFieldEN.setText(arrOfStr[1]);
		frameEmployee.txtFieldEN.setEnabled(false);

		JOptionPane.showMessageDialog(null, "CompanyName=" + CompanyName + "\nEmployeeNo=" + EmployeeNo);

		frameEmployee.employeeBook = frameEmployee.setBasics2StartBookingEmployee(); // initialize a new employeeBook.
		employeeCounter = 0; // reset to zero
	}

	public void openFile(String _filePath) throws FileNotFoundException, NullPointerException, IOException {
		isReadFile = false;
		isCreateFile = true;
		employeeCounter = 0;

		JOptionPane.showMessageDialog(null, "This file writer is for log report.", "Write a text-based report",
				JOptionPane.INFORMATION_MESSAGE);

		fileWritten = OpenFileRecord.getfile(_filePath, useJPane);
		if (fileWritten != null) {
			OpenFileRecord.openFile(fileWritten);
		}

		if (OpenFileRecord.output != null) {
			JOptionPane.showMessageDialog(null, "The next file writer choosed is for recording every accounnt record.",
					"Write Account Records", JOptionPane.INFORMATION_MESSAGE);
			ImageIcon icon = new ImageIcon("./resources/images/question_message_120x120.png");
			streamType_MenuOption = Choice4FileStreamType.decideWhichFileStreamType(icon, false);
			JOptionPane.showMessageDialog(null, streamType_MenuOption, "Stream-type Chosen",
					JOptionPane.INFORMATION_MESSAGE);
			if (streamType_MenuOption != null) {
				fileChoosing4WriteOrRead = new FileChoosing4WriteOrRead_25Dec20(true, false,
						streamType_MenuOption.getValue());
				fileChoosing4WriteOrRead.chooseFile(_filePath, "Create File");

				if (fileChoosing4WriteOrRead.result == JFileChooser.APPROVE_OPTION) {
					fileChoosing4WriteOrRead.openFile2Write(streamType_MenuOption.getOptionType());

					String compannyString = String.format("%s\t%s\n", "Company", CompanyName);
					String employeeNoString = String.format("%s\t%s", "EmployeeNo", EmployeeNo);
					if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
						outputO = fileChoosing4WriteOrRead.outputO; // here output has been implemented and not 'null'

						// write basic profile into file(added on 02Aug19)
						outputO.writeObject(compannyString);
						outputO.writeObject(employeeNoString);

					} else {
						outputT = fileChoosing4WriteOrRead.outputT; // here output has been implemented and not 'null'

						// write basic profile into file(added on 02Aug19)
						outputT.format(compannyString);
						outputT.format(employeeNoString);
					}
					frameEmployee.btnOpenFile.setEnabled(false);
					frameEmployee.btnCalculate.setEnabled(true);
					frameEmployee.btnClearProfile.setEnabled(true);
				}
			} else
				JOptionPane.showMessageDialog(null, "You just cancel the action!");
		}
	}

	public void processAndShowWageRecordsUsingCheck() {
		// processAndShowWageRecordsUsingCheck logic here
	}

	public void addNprocessEveryNewRecord(Employee record) {
		employeeCounter += 1;
		frameEmployee.employeeBook.processEverySalaryProfile(record);
		JOptionPane.showMessageDialog(null, "Employee: " + employeeCounter + ":\n" + record.toString2());

		writeRecord2ReportFileNdisplayCompleteRecord(record);

		addRecord2CrossespondingArrayList(record);

		go2FinalPhaseIfDoneAllRecordsInput();
	}

	public void go2FinalPhaseIfDoneAllRecordsInput() {
		if (employeeCounter == EmployeeNo) {
			JOptionPane.showMessageDialog(null, "All employees' records have done input!");

			addWholeRecords2JTable();

			displayNcompleteEarningBookResults(frameEmployee.employeeBook);

			if (!isReadFile) {
				WriteLogFile(frameEmployee.employeeBook);
				closefile();
			}

			resetButtons4NewStart(true);
			frameEmployee.btnOpenFile.setEnabled(false);
			frameEmployee.btnCalculate.setEnabled(false);
		}
	}

	public void displayNcompleteEarningBookResults(EmployeeBaseBook _employeebook) {
		if (employeeCounter != 0) {
			frameEmployee.txtFieldLA.setText("" + frameEmployee.employeeBook.aLevel);
			frameEmployee.txtFieldLB.setText("" + frameEmployee.employeeBook.bLevel);
			frameEmployee.txtFieldLC.setText("" + frameEmployee.employeeBook.cLevel);

			frameEmployee.txtFieldEmpCounter.setText(String.format("%d", _employeebook.employeeCounter));
			frameEmployee.txtFieldHighestE.setText(twoDigits.format(_employeebook.highestE));
			frameEmployee.txtFieldLowestE.setText(twoDigits.format(_employeebook.lowestE));

			_employeebook.calculateAverageNproduceLevelArray();
			frameEmployee.txtFieldAverageE.setText(twoDigits.format(_employeebook.meanEarning));
		} else {
			JOptionPane.showMessageDialog(null, "老兄/老姊! 沒半個人 算甚麼東東阿 ", "No preset-profile or input",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void addWholeRecords2JTable() {
		frameEmployee.dataUsed = returnObjectArray();

		TableDialogEditDemo_newByMCLo_UsingExtends demoTable = new TableDialogEditDemo_newByMCLo_UsingExtends(
				frameEmployee.table4RecordTableArea, frameEmployee.namesUsed, frameEmployee.dataUsed);

		frameEmployee.tableAggregate = demoTable.scrollPane;
	}

	public void WriteLogFile(EmployeeBaseBook _employeeBook) {
		if (fileWritten != null && OpenFileRecord.output != null) {
			OpenFileRecord.output.format(frameEmployee.employeeBook.toString());
		} else {
			JOptionPane.showMessageDialog(null, "No file was choosen!", "Choose a file FIRST.",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	public void closefile() {
		OpenFileRecord.closeFile();
		fileChoosing4WriteOrRead.closeFile();
		isFileChoosenOK = false;
	}

	public void addRecord2CrossespondingArrayList(Employee record) {
		if (record instanceof SalariedEmployee) {
			eList_Salaried.add((SalariedEmployee) record);
		} else if (record instanceof HourlyEmployee) {
			eList_Hourly.add((HourlyEmployee) record);
		} else if (record instanceof BasePlusCommissionEmployee) {
			System.out.println("I am in BasePlusCommissionEmployee");
			eList_BasePlusCommission.add((BasePlusCommissionEmployee) record);
		} else if (record instanceof CommissionEmployee) {
			eList_Commission.add((CommissionEmployee) record);
		} else {
			System.out.println("Add Nothing!");
		}
	}

	public void writeRecord2ReportFileNdisplayCompleteRecord(Employee record) {
		if (!isReadFile) {
			addEveryRecord2FileStream(record);
		}

		frameEmployee.txtArea4RecordTextArea.setText(frameEmployee.employeeBook.recordsConcatenated);

		frameEmployee.listModel.addElement(record.toString3());

		if (!isReadFile)
			frameEmployee.txtFieldEarnings.setText(String.format("%d", employeeCounter));
	}

	public void addEveryRecord2FileStream(Employee record) {
		// output record and flush buffer
		if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
			try {
				outputO.writeObject(record);
				outputO.flush();
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something wrong with your record data!",
						"No data was added into file", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			outputT.format("%s", record);
		}
	} // end addEveryRecord2FileStream

	public Object[][] returnObjectArray() {
		return null;
	} // end returnObjectArray()

	/**
	 * Clear text-fields of record.
	 */
	public void clearRecordTextFields() {
		for (JTextField txtField : EmployeeBaseJFrame_V0.listTxtFieldsEmployeeG)
			txtField.setText("");
	} // end clearRecordTextField

	/**
	 * Clear areas of profile and results.
	 */
	public void clearProfileAndResults() {
		for (JTextField txtField : EmployeeBaseJFrame_V0.listTxtFieldsProfileG) {
			txtField.setText("");
		}

		for (JTextField txtField : frameEmployee.listTxtFieldsResultsG) {
			txtField.setText("");
		}
	}

	public void outputFinalReport() {
		frameEmployee.txtArea4RecordTextArea.setText(frameEmployee.employeeBook.toString());

//    	    JOptionPane.showMessageDialog(null, frameEmployee.employeeBook.recordsConcatenated, 
//    	                                  "txtArea", JOptionPane.INFORMATION_MESSAGE);

		frameEmployee.listArea4RecordListArea.setModel(frameEmployee.listModel);
		frameEmployee.addJTable2Box();
	} // end outputFinalReport()

	public void readFile() throws ClassNotFoundException, IOException, NoSuchElementException, NullPointerException,
			NumberFormatException, IllegalArgumentException, ClassCastException, ArrayIndexOutOfBoundsException {
		isReadFile = true;
		boolean isFileNeeded = false;

		if (frameEmployee.ifPreviewing) {
			/**
			 * Preview file-content.
			 */
			JOptionPane.showMessageDialog(null, "This file reader is for previewing log report.",
					"Read a text-based log report", JOptionPane.INFORMATION_MESSAGE);

			isFileNeeded = OpenFileRecord.readFile2PreviewContent4ContinueOrNot(frameEmployee.txtArea4RecordTextArea,
					filePath, useSimpleOne);

			/**
			 * Below is for choosing Stream-type, used for writing account records
			 */
			if (isFileNeeded) {
				readFile_EmployeeAccount();
			}
		} else { // just directly read account file without previewing file for confirmation.
			readFile_EmployeeAccount();
		}
	} // end readFile

	public void readRecordData() throws NumberFormatException, ClassNotFoundException, NullPointerException,
			ClassCastException, IOException {

	}

	public void runPieChart3DFX() {
		PieChart3DFXDemo2_byMClo.categories = new String[3];
		PieChart3DFXDemo2_byMClo.categories = Stream.of(
				EarningLevelEnum1.LevelA.getLevelType(),
				EarningLevelEnum1.LevelB.getLevelType(), 
				EarningLevelEnum1.LevelC.getLevelType()).toArray(String[]::new);

		// Used for calculate % related
		PieChart3DFXDemo2_byMClo.values4Categories = new double[PieChart3DFXDemo2_byMClo.categories.length];

		PieChart3DFXDemo2_byMClo.values4Categories[0] = frameEmployee.employeeBook.levelsV[0];
		PieChart3DFXDemo2_byMClo.values4Categories[1] = frameEmployee.employeeBook.levelsV[1];
		PieChart3DFXDemo2_byMClo.values4Categories[2] = frameEmployee.employeeBook.levelsV[2];

		PieChart3DFXDemo2_byMClo.title2Display = "Wage Distribution";

		// Application.launch(PieChart3DFXDemo2_byMClo.class); // the best
	}

	// end class Helper4SuperEmployeeBase

}
