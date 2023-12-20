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
import Lin.library.filestream.OpenFileRecord;
import Lin.polymorphism.employee.*;
import Lin.polymorphism.employee.frame.*;
import Lin.polymorphism.employee.menuoption.EarningLevelEnum1;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;
import Lin.library.enummenu.NumberType_MenuOption;

public class Helper4SuperEmployeeBase {
	protected InputNumberValidation ValidationGUI = new InputNumberValidation(false, true);
	protected PieChart2DMemo0 pieChartDemo; // old one from last year

	ArrayList<SalariedEmployee> CELIST_Salaried = new ArrayList<SalariedEmployee>(); // this is for creating file.
	ArrayList<HourlyEmployee> CELIST_Hourly = new ArrayList<HourlyEmployee>(); // this is for creating file.
	ArrayList<CommissionEmployee> CELIST_Commission = new ArrayList<CommissionEmployee>();
	ArrayList<BasePlusCommissionEmployee> CELIST_BasePlusCommission = new ArrayList<BasePlusCommissionEmployee>();

	public int EmployeeNo = 0;
	public String CompanyName = "";

	// initializing variables for grade record.
	String _SSN = "";
	String _firstName = "";
	String _lastName = "";

	// Salaried Employee
	public double _weekSalary = 0;

	// Hourly Employee
	public double _hourlyWage = 0.0;
	public double _rate4ExtraHours = 0.0;
	public double _hoursWorked = 0;
	public double maxHoursPerWeek = 168.0;

	// Commission Employee
	public double _grossSales = 0;
	public double _commissionRate = 0.0;

	// BasePlusCommission Employee
	public double _baseSalary = 0;
	// public double _grossSales = 0; // commented out, duplicate variable
	// public double _commissionRate = 0; // commented out, duplicate variable

	public static DecimalFormat twoDigits = new DecimalFormat("0.00");
	protected String wholeRecords4Output = "";
	public String finalReport = "";

	public boolean checkProfile = false;
	boolean checkRecord = false;

	protected InputNumberValidation_GUI_CONSOLE validationNumber_GUI = new InputNumberValidation_GUI_CONSOLE(false,
			true);
	public int employeeCounter = 0;

	// ReadFileExample readFile;
	public File fileWrite = null;// fileRead = null;
	public String wholeReport4EarningBook = ""; // for write to file

	EmployeeBaseJFrame_V0 frameEmployee;

	int PieChart2D_Type1 = 0, PieChart2D_Type2 = 1, PieChart3D_Type3 = 2;
	int pieChartChoosen = PieChart2D_Type1; // PieChart3D_Type3 = new */;

	static EmployeeBaseJFrame_V0 employeeBaseJFrame = null;
	static PieChartType_MenuOption pieChartType_MenuOption = null;
	public EmployeeBaseBook employeeBook;

	public String filePath = "./filePath";
	static FileChoosing4WriteOrRead_V2 fileChoosing4WriteOrRead;
	private ObjectOutputStream outputO;
	private Formatter outputT;

	protected ObjectInputStream inputO;
	protected Scanner inputT;
	String companyString;
	String employeeNosString;

	// FileTypeMenuOption streamType_MenuOption;//fileType
	static FileStreamType_MenuOption streamType_MenuOption = null;
	// ArrayList<Employee> CELIST_Employee = new ArrayList<Employee>();
	protected boolean isFileChosenOK = false;
	public boolean isReadFile = false;
	public boolean isCreateFile = false;
	public boolean useJPane = true;
	public boolean useJConsole = false; // true/false
	ReadFileExample readFile;

	public Helper4SuperEmployeeBase(/* Component component */ EmployeeBaseJFrame_V0 _frmEmployee) {
		frameEmployee = _frmEmployee;
		// frameEmployee = (EmployeeBaseJFrame) component; //??? maybe future

		// setup the display for the Distribution of wage-levels in Form
		setupDistribution4WageLevels();

		wholeRecords4Output = String.format("%s\t%10s\t%10s\t%10s\t", " ", "FirstName", "LastName", "SSN");

		setupNewStartUpButtons();
		employeeBook = frameEmployee.employeeBook;
	}

	public Helper4SuperEmployeeBase(Lin.polymorphism.employee.interfaceframe.EmployeeBaseJFrame employeeBaseJFrame2) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @temp_used
	 * @param employeeBaseInternalJFrame
	 */
	public Helper4SuperEmployeeBase(EmployeeBaseInternalJFrame employeeBaseInternalJFrame) {
		// TODO Auto-generated constructor stub
	}

	public void setupNewStartUpButtons() {
		resetButtons4NewStart(false);
		frameEmployee.btnSetProfile.setEnabled(true); // added on 02Aug19
		frameEmployee.btnExit.setEnabled(true); // added on 02Aug19
		frameEmployee.btnRefresh.setEnabled(true); // added on 02Aug19
		frameEmployee.btnReadFile.setEnabled(true); // added on 02Aug19
	}

	/**
	 * Setup/layout distributions for wage levels.
	 */
	public void setupDistribution4WageLevels() {
		// ...
		frameEmployee.lblALowerThreshold.setText("" + EarningLevelEnum1.LevelA.getValue());
		frameEmployee.lblBUpperThreshold.setText("" + EarningLevelEnum1.LevelA.getValue());
		frameEmployee.lblBLowerThreshold.setText("" + EarningLevelEnum1.LevelB.getValue());
		frameEmployee.lblCUpperThreshold.setText("" + EarningLevelEnum1.LevelB.getValue());
		// ...
		frameEmployee.lblUnit
				.setText("" + EarningLevelEnum1.UNIT.getTypeValue() + " (" + EarningLevelEnum1.UNIT.getValue() + ")");
	}

	/**
	 * prepare Basic Profile Using pre-Check.
	 */
	public void prepareBasicProfileUsingCheck() {
		checkProfile = validationNumber_GUI.checkStringNotEmpty(frameEmployee.textField.getText(),
				EmployeeRecordIndices.COMPANY_NAME.getRecordIndexType());

		JOptionPane.showMessageDialog(null, "employee=" + frameEmployee.getClass());

		if (!checkProfile)
			frameEmployee.textField.setText("");

		if (checkProfile)
			checkProfile = validationNumber_GUI.checkNumberValueByComparing_1flag(frameEmployee.textField_1.getText(),
					EmployeeRecordIndices.EMPLOYEE_NO.getRecordIndexType(), 0, 1,
					NumberType_MenuOption.INT_NUMBER_TYPE.getValueIndex());

		if (!checkProfile)
			frameEmployee.textField_1.setText("");
		// else EmployeeNo=validation_GUI.intValue;

		// finally-> if everything is ready-> get all input data in profile area
		if (checkProfile) {
			CompanyName = frameEmployee.textField.getText();
			EmployeeNo = Integer.parseInt(frameEmployee.textField_1.getText());
			// Open File can start from here (01Aug19)
			frameEmployee.btnOpenFile.setEnabled(true);
		}
	} // prepareBasicProfileUsingCheck()

	/**
	 * Validate and Check input record data.
	 */
	public void checkInputRecordData() {
		checkRecord = false;

		/*
		 * checkRecord = validation_GUI.checkStringNotEmpty(
		 * frameEmployee.txtFieldSSN.getText(),
		 * EmployeeRecordIndices.SSN.getRecordIndexType());
		 */
		checkRecord = validation_GUI.checkStringNotEmpty(frameEmployee.textField_3.getText(),
				EmployeeRecordIndices.SSN.getRecordIndexType());

		if (!checkRecord) {
			frameEmployee.textField_3.setText("");
		}
		// else _SSN = frameEmployee.txtFieldSSN.getText();

		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.textField_4.getText(),
					EmployeeRecordIndices.FIRST_NAME.getRecordIndexType());
		}

		if (!checkRecord) {
			frameEmployee.textField_4.setText("");
		}
		// else _firstName = frameEmployee.txtFieldFN.getText();

		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.textField_5.getText(),
					EmployeeRecordIndices.LAST_NAME.getRecordIndexType());
		}

		if (!checkRecord) {
			frameEmployee.textField_5.setText("");
		}
		// else _lastName = frameEmployee.txtFieldLN.getText();
	}
	// end checkInputRecordData

	public void AddEveryRecordAndShowProcessedResults(Employee record) /* throws IOException */ {
		if (!isReadFile) {
			// output record and flush buffer
			if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
				try {
					outputO.writeObject(record);
					outputO.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something wrong with your record data!",
							"No data was added into file", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				outputT.format("%s", record);
			}
		}

		frameEmployee.txtArea4RecordTextArea.setText(wholeRecords4Output); // add every record to output listbox.
		frameEmployee.listModel.addElement(record.toString3());
		frameEmployee.listArea4RecordListArea.getModel(frameEmployee.listModel);

		// Below display record results to a record-results area in the grade-book form
		if (!isReadFile) {
			frameEmployee.txtFieldEarnings.setText(twoDigits.format(record.earnings())); // only for creating file.
			frameEmployee.txtFieldEmpCounter.setText(String.format("%d", employeeCounter)); // total student number
																							// already processed
		}
	}

	public void processAndShowWageRecordsUsingCheck(EmployeeBaseBook employeeBaseBook) {
		// processAndShowWageRecordsUsingCheck logic here
	}

	public void outputFinalReport2TextArea() {
		frameEmployee.txtArea4RecordTextArea.setText(wholeRecords4Output);
		frameEmployee.listArea4RecordListArea.setModel(frameEmployee.listModel);
	}

	public String showGradeBookResults(EmployeeBaseBook _employeeBook) {
		if (employeeCounter != 0) {
			frameEmployee.textField_6.setText(String.format("%d", _employeeBook.employeeCounter));
			frameEmployee.textField_7.setText(twoDigits.format(_employeeBook.highestG()));
			frameEmployee.textField_8.setText(twoDigits.format(_employeeBook.lowestG()));
			if (employeeCounter == EmployeeNo) {
				_employeeBook.calculateAverage4Company();
				frameEmployee.textField_9.setText(twoDigits.format(_employeeBook.mean));

				wholeRecords4Output += _employeeBook.toString();
				frameEmployee.txtArea4RecordTextArea.setText(wholeRecords4Output);
				frameEmployee.btnCalculate.setEnabled(false);
			}
		} // end if
		else {
			JOptionPane.showMessageDialog(null, "老兄/老姊! 沒半個人 算甚麼東東阿 ", "No preset-profile or input",
					JOptionPane.ERROR_MESSAGE);
		} // end else
		return wholeRecords4Output;
	} // end showGradeBookResults

	/**
	 * Clear text-fields of record.
	 */
	public void clearRecordTextFields() {
		for (JTextField txtField : EmployeeBaseJFrame_V0.listTxtFieldsEmployeeG) {
			txtField.setText("");
		}
		// frameEmployee.txtFieldSSN.setText(""); //just for check
	}

	/**
	 * Clear areas of profile and results.
	 */
	public void clearProfileAndResults() {
		for (JTextField txtField : EmployeeBaseJFrame_V0.listTxtFieldsProfileG)
			txtField.setText("");
		for (JTextField txtField : frameEmployee.listTxtFieldsResultsG)
			txtField.setText("");
	}

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
		}

		if (condition == true) { // ??? if-else: need to confirm if there are something wrong..//
			// frmEmployee.btnCalculate.setText(Button_MenuOption.Process_Data.name());

			frameEmployee.btnCalculate.setText(Buttons4UniversalProcess_MenuOption.Process_Data.getButtonType());
			frameEmployee.btnSetProfile.setEnabled(false);
		} else {
			// frmEmployee.btnCalculate.setText(Button_MenuOption.Process_Data.name());

			frameEmployee.btnCalculate.setText(Buttons4UniversalProcess_MenuOption.Process_Data.getButtonType());
			frameEmployee.btnSetProfile.setEnabled(true); // false
		}
	} // end enableProfileTextBoxes

	public void showPieChartOfWageDistribution(PieChartType_MenuOption pieChartType_MenuOption0) {

		frameEmployee.employeeBook.levelsV[0] = (double) ((frameEmployee.employeeBook.aLevel * 100.0)
				/ employeeCounter);
		frameEmployee.employeeBook.levelsV[1] = (double) ((frameEmployee.employeeBook.bLevel * 100.0)
				/ employeeCounter);
		frameEmployee.employeeBook.levelsV[2] = (double) ((frameEmployee.employeeBook.cLevel * 100.0)
				/ employeeCounter);

		// 1. old one from last year--still working(2D)
		if (pieChartType_MenuOption == PieChartType_MenuOption.PIECHART2D_TYPE1) { // it can be closed separately.
			// pieChartDemo = new PieChart2DDemo("Wage-Level Distribution",
			// _employeeBook.levels5, _employeeBook.levels5);
			pieChartDemo = new PieChart2DDemo0("Wage-Level Distribution", frameEmployee.employeeBook.levelsS,
					frameEmployee.employeeBook.levelsV);

			// 2. new one (2D)
		} else if (pieChartType_MenuOption == PieChartType_MenuOption.PIECHART2D_TYPE2) { // if it is closed, the whole
			// app would exit.

			PieChart2DDemo1 demo = new PieChart2DDemo1("Wage-Level Distribution", frameEmployee.employeeBook.levelsS,
					frameEmployee.employeeBook.levelsV);
			demo.pack();
			// UIUtils.centerFrameOnScreen(demo); //?????? With or without are all the same
			// results.
			demo.setVisible(true);
		} else { // whole app. can still keep after this is closed.

			// 3. New one (3D)
			// PieChart3DDemo2 demo = new PieChart3DDemo2("Wage-Level Distribution",
			// _employeeBook.levels5);
			PieChart3DDemo2 demo = new PieChart3DDemo2("Wage-Level Distribution", frameEmployee.employeeBook.levelsS,
					frameEmployee.employeeBook.levelsV);
			demo.pack();
			demo.setVisible(true);
		}
	}// end showPieChartOfWageDistribution

	/**
	 * This method has been put into library. Here just kept for reference
	 * 
	 * @param _employeeBook
	 */
	public void showPieChartOfWageDistribution(EmployeeBaseBook _employeeBook) {
		// 1. old one from last year--Still working(2D)
		_employeeBook.levelsV[0] = (double) ((_employeeBook.aLevel * 100.00) / employeeCounter);
		_employeeBook.levelsV[1] = (double) ((_employeeBook.bLevel * 100.00) / employeeCounter);
		_employeeBook.levelsV[2] = (double) ((_employeeBook.cLevel * 100.00) / employeeCounter);

		if (pieChartChoosen == PieChart2D_Type1) { // it can be closed separately.
			pieChartDemo = new PieChart2DDemo0("Wage-Level Distribution", _employeeBook.levelsS, _employeeBook.levelsV);
		} else if (pieChartChoosen == PieChart2D_Type2) { // if it is closed, the whole app would exit.
			PieChart2DDemo1 demo = new PieChart2DDemo1("Wage-Level Distribution", _employeeBook.levelsS,
					_employeeBook.levelsV);
			demo.pack();
			// UIUtils.centerFrameOnScreen(demo); //?????? With or without are all the same
			// results.
			demo.setVisible(true);
		} else { // whole app. can still kept after this is closed.

			// 3. New one (3D)
			PieChart3DDemo2 demo = new PieChart3DDemo2("Wage-Level Distribution", _employeeBook.levelsS,
					_employeeBook.levelsV);
			demo.pack();
			demo.setVisible(true);
		}
	}

	// class for Button event handling
	public void switchPieChartType(/* EmployeeBaseBook _employeeBook */) {
		frameEmployee.employeeBook.levelsV[0] = (double) (frameEmployee.employeeBook.aLevel);
		frameEmployee.employeeBook.levelsV[1] = (double) (frameEmployee.employeeBook.bLevel);
		frameEmployee.employeeBook.levelsV[2] = (double) (frameEmployee.employeeBook.cLevel);

		Choice4PieChartType choice4PieChartType = new Choice4PieChartType();
		choice4PieChartType.switchPieChartTypeViaSwitchLib("Wage-Level Distribution",
				frameEmployee.employeeBook.levelsV, frameEmployee.employeeBook.levelsS);
	}

	public void resetComponentsForNewStart() {
		enableProfileTextBoxes(true);
		clearProfileAndResults();
		clearRecordTextFields();

		checkProfile = false;
		clearProfileAndResults();

		frameEmployee.txtArea4RecordTextArea.setText("");
		frameEmployee.listArea4RecordListArea.removeAll();
	}

	/**
	 * Reset buttons in JFrame for new start of payroll system.
	 * 
	 * @param _isEnable
	 */
	public void resetButtons4NewStart(boolean _isEnable) {
		for (int i = 0; i < frameEmployee.basicChoices.length; i++) {
			frameEmployee.optionButtons[i].setEnabled(_isEnable /* true */);
		}
	}

	public void openfile(String _filePath) throws FileNotFoundException, NullPointerException, IOException {
		isReadFile = false;
		isCreateFile = true;
		employeeCounter = 0;

		JOptionPane.showMessageDialog(null, "This file writer is for log report.", "Write a text-based report",
				JOptionPane.INFORMATION_MESSAGE);

		fileWrite = OpenFileRecord.getfile(_filePath, useJPane);
		if (fileWrite != null) {
			OpenFileRecord.openfile(fileWrite);
		}

		// ------Below is for choosing Stream-type used for writing account
		// records------
		JOptionPane.showMessageDialog(null, "The next file writer choosed is for recording every account record.",
				"Write Account Record", JOptionPane.INFORMATION_MESSAGE);
		ImageIcon icon = new ImageIcon("./resources/images/question_message_120x120.png");
		Choice4FileStreamType choice4FileStreamType = new Choice4FileStreamType();
		streamType_MenuOption = choice4FileStreamType.decideWhichFileStreamType(icon);

		if (streamType_MenuOption != null) {
			// ----Below is for fileChooser used for writing account records------
			// JOptionPane.showMessageDialog(null, "File chooser",
			// JOptionPane.INFORMATION_MESSAGE);
			fileChoosing4WriteOrRead = new FileChoosing4WriteOrRead_v2(true, false, streamType_MenuOption.getValue());
			fileChoosing4WriteOrRead.chooseFile(_filePath);
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

			if (fileChoosing4WriteOrRead.result == JFileChooser.APPROVE_OPTION) {
				frameEmployee.btnOpenFile.setEnabled(false); // New one
				frameEmployee.btnCalculate.setEnabled(true); // New one
			}
		} else
			JOptionPane.showMessageDialog(null, "You just cancel the action!");
	}

	public void writeFile(EmployeeBaseBook _employeeBook) {
		if (fileWrite != null) {
			OpenFileRecord.output.format(_employeeBook.toString());
			// OpenFileRecord.output.format("%s", wholeReport4EarningBook); // by using
			// this, no content(null); no good
			frameEmployee.btnWriteFile.setEnabled(false);
			frameEmployee.btnCloseFile.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "No file was choosen!", "Choose a file FIRST.",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	public void closefile() {
		OpenFileRecord.closeFile();
		fileChoosing4WriteOrRead.closeFile();

		// frameEmployee.btnWriteFile.setEnabled(false);
		frameEmployee.btnCloseFile.setEnabled(false);
		isFileChoosenOK = false;
	}

	public void readFile() throws ClassNotFoundException, IOException, NoSuchElementException, NullPointerException,
			NumberFormatException {
		isReadFile = true;
		boolean isFileNeeded = false;

		/**
		 * Preview file-content.
		 */
		isFileNeeded = OpenFileRecord.readFile2PreviewContent4ContinueOrNot(frameEmployee.txtArea4RecordTextArea,
				filePath, useSimpleOne);
		/**
		 * Below is for choosing Stream-type, used for writing account records
		 */
		if (isFileNeeded)
			readFile_EmployeeAccount();
	}

	public void readFile_EmployeeAccount() throws ClassNotFoundException, IOException {
		JOptionPane.showMessageDialog(null, "The next file writer chosen is for recording every account record.",
				"Read Account Records", JOptionPane.INFORMATION_MESSAGE);
		ImageIcon icon = new ImageIcon("/resources/images/question_message_120x120.png");
		Choice4FileStreamType choice4FileStreamType = new Choice4FileStreamType();
		streamType_MenuOption = choice4FileStreamType.decideWhichFileStreamType(icon);

		if (streamType_MenuOption != null) {
			/**
			 * Below is for fileChooser used for writing account records
			 */
			JOptionPane.showMessageDialog(null, "filePath=" + filePath);
			fileChoosing4WriteOrRead = new FileChoosing4WriteOrRead_v2(false, true, streamType_MenuOption.getValue());
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
			isFileChosenOK = true;

		} else
			JOptionPane.showMessageDialog(null, "You just cancel the action!");

	}

	public void advancedlyProcessBasics() {
		String[] arrOfStr = companyString.split("\t");
		CompanyName = arrOfStr[1];
		frameEmployee.textField.setText(CompanyName);
		frameEmployee.textField.setEnabled(false);

		arrOfStr = employeeNoString.split("\t");
		EmployeeNo = Integer.parseInt(arrOfStr[1]);
		frameEmployee.textField_1.setText(arrOfStr[1]);
		frameEmployee.textField_1.setEnabled(false);

		JOptionPane.showMessageDialog(null, "CompanyName=" + CompanyName + "\nEmployeeNo=" + EmployeeNo);
		employeeBook = frameEmployee.setBasics2StartBookingEmployee(); // initialize a new employeeBook.
		employeeCounter = 0; // reset to zero
	}

	public void addNprocessEveryNewRecord(Employee record) {
		employeeCounter += 1;
		frameEmployee.employeeBook.processEverySalaryProfile(record);

		record.setLevel(frameEmployee.employeeBook.LevelLetter);
		record.setColor(frameEmployee.employeeBook.indexColor);

		JOptionPane.showMessageDialog(null, "Employee: " + employeeCounter + ":\n" + record.toString2());
		wholeRecords40utput += record.toString();

		frameEmployee.txtArea4RecordTextArea.setText(wholeRecords40utput);

		AddEveryRecordAndShowProcessedResults(record);

		if (record instanceof SalariedEmployee) {
			CEList_Salaried.add((SalariedEmployee) record);
		} else if (record instanceof HourlyEmployee) {
			CEList_Hourly.add((HourlyEmployee) record);
		} else if (record instanceof BasePlusCommissionEmployee) {
			System.out.println("I am in BasePlusCommissionEmployee");
			CEList_BasePlusCommission.add((BasePlusCommissionEmployee) record);
		} else if (record instanceof CommissionEmployee) {
			CEList_Commission.add((CommissionEmployee) record);
			System.out.println("I am in CommissionEmployee");
		} else {
			System.out.println("Add Nothing!");
		}

		checkIfEmployeeCounterEqual2EmployeeNo();
	}

	public void addWholeRecords2JTable() {
		TableDemo4PayrollSystem_23July19_v3 demoOK = new TableDemo4PayrollSystem_23July19_v3(null,
				frameEmployee.contentPane);
		// demoOK.main(null);//if needed, try uncomment out this line and run...
		frameEmployee.dateUsed = returnObjectArray(demoOk);
		frameEmployee.tableAggregate = demoOK.createJTable(frameEmployee.tableAggregate,
				frameEmployee.table4RecordTableArea, frameEmployee.namesUsed, frameEmployee.dataUsed, null);
	}

	public Object[][] returnObjectArray(TableDemo4PayrollSystem_23July19_v3 demo) {
		return null;
	}

	public void checkIfEmployeeCounterEqual2EmployeeNo() {
		if (employeeCounter == EmployeeNo) {
			finalReport = wholeRecords40utput;
			JOptionPane.showMessageDialog(null, "All employees' records have done input!");

			frameEmployee.txtFieldIdA.setText("" + frameEmployee.employeeBook.aLevel);
			frameEmployee.txtFieldIdB.setText("" + frameEmployee.employeeBook.bLevel);
			frameEmployee.txtFieldIdC.setText("" + frameEmployee.employeeBook.cLevel);

			addWholeRecords2JTable();

			frameEmployee.btnOutputAll.isEnabled();
			frameEmployee.btnPieChartDemo.isEnabled();
			frameEmployee.btnCalculate.isEnabled();

			// -----------------------------------------------------------------------

			wholeReport4EarningBook = showGradeBookResults(frameEmployee.employeeBook);

			resetButtons4NewStart(true);

			frameEmployee.btnWriteFile.setEnabled(false);
			frameEmployee.btnOpenFile.setEnabled(false);
			frameEmployee.btnCloseFile.setEnabled(false);
			frameEmployee.btnSetProfile.setEnabled(false);
		}
	}

	public void refreshJFrame(/*
								 * EmployeeBaseJFrame component, ButtonController4SuperBase buttonController,
								 * String _employeeType
								 */ JDesktopPane theDesktop) {
		if (frameEmployee != null) {
			// frameEmployee.hide(); //OK, but just not shown, and still existed (no good to
			// memory)...
			frameEmployee.dispose();

			frameEmployee = frameEmployee.refreshJFrame();

			if (theDesktop != null) {
				theDesktop.add(frameEmployee);
			}
		} else
			JOptionPane.showMessageDialog(null, "You haven't started anything yet!", "Start Input data first",
					JOptionPane.INFORMATION_MESSAGE);
	}

	public String toString() {
		return finalReport;
	}
}
