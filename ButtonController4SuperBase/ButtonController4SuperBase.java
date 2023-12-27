package Lin.polymorphism.employee.buttoncontroller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import Lin.library.enummenu.Buttons4UniversalProcess_MenuOption;
import Lin.library.filestream.ReadFileExample;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.frame.*;
import Lin.polymorphism.employee.menuoption.*;
import Lin.polymorphism.employee.helper.Helper4SuperEmployeeBase1;

public /* abstract */ class ButtonController4SuperBase {
	Helper4SuperEmployeeBase1 helper;

	public boolean checkBasicProfile = false;
	public JButton[] optionButtons;
	Buttons4UniversalProcess_MenuOption[] btnChoicesEnums;
	EmployeeBaseJFrame_V0 frameEmployee;
	ReadFileExample readFile;
	public File fileWriteFile = null, fileRead = null;
	public EmployeeBaseBook employeeBook;
	private String filePath = "./filePath";

	public String wholeReport4EarningBookString = ""; // for writing to file

	JDesktopPane theDesktop;

	public ButtonController4SuperBase(EmployeeBaseJFrame_V0 component, JDesktopPane _theDesktop) {
		
		frameEmployee=component;
		
		optionButtons = frameEmployee.optionButtons;
		btnChoicesEnums = frameEmployee.basicChoices;
		helper = frameEmployee.helper4Employee;
		employeeBook = frameEmployee.employeeBook;
		
		theDesktop = _theDesktop;
	}
	
	public void addActionListenerOnButtons() {
		for (int task = 0; task < optionButtons.length; ++task) {
			optionButtons[task].addActionListener(new ButtonHandlerBySwitch());
		}// end for
	}
	
	private class ButtonHandlerBySwitch implements ActionListener{
		private String taskChoiceType_S;
		private Buttons4UniversalProcess_MenuOption btnChoice;
		
		public void actionPerformed(ActionEvent event) {
			taskChoiceType_S = event.getActionCommand();
			JOptionPane.showMessageDialog(null,  taskChoiceType_S);
			
			for(int i = 0; i < optionButtons.length; i++) {
				if(btnChoicesEnums[i].getButtonType() == taskChoiceType_S) {
					
					btnChoice = btnChoicesEnums[i];
					break;
				}
			}
			
			try {
				switchChoices(btnChoice);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,  e.getMessage());
			}
		} //end actionPerformed
	} //end class ButtonHandLerBySwitch
	
	public void switchChoices(Buttons4UniversalProcess_MenuOption choiceEnum) throws FileNotFoundException{
		
		switch(choiceEnum) {
		case Set_Profile:
			clickBtnToSetProfile();
			break;
		case Process_Data:
			clickBtnToCalculateAll();
			break;
		case Refresh:
			refreshJFrame();
			break;
		case Output_Results:
			outputFinalReport();
			break;
		case Clear_Record:
			clearRecordTextFields();
			break;
		case Clear_Profile_and_Results:
			clearProfileAndResults();
			break;
		case OpenFile:
			openFile();
			break;
		case ReadFile:
			readFile();
			break;
		case WriteFile:
			WriteFile();
			break;
		case CloseFile:
			closefile();
			break;
		case PieChartDemo:
			showPieChartOfWageDistribution();
			break;
		case Exit:
			exitAppInQuestion();
			//System.exit(0);
		default:
			break;
		}
	} //end witchChoices
	
	public void clickBtnToSetProfile() {
		if(helper.isReadFile)
		{
			JOptionPane.showMessageDialog(null,  "Please re-input data.", "GUI needs to be Refleshed !",
					JOptionPane.INFORMATION_MESSAGE);
			refreshJFrame();
		}
		else {
			
			helper.prepareBasicProfileUsingCheck();
			checkBasicProfile = helper.checkProfile;
			
			JOptionPane.showMessageDialog(null,  "checkBasicProfile=" + helper.checkProfile);
			
			if(checkBasicProfile) {
				frameEmployee.helper4Employee.enableProfileTextBoxes(false);
				setProFile();
				JOptionPane.showMessageDialog(null,  "Start Inputting Record", "Basic-Profie OK!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} //end ClickBtnToSetProfile
	}
	
	public void setProFile() {
		employeeBook = frameEmployee.setBasics2StartBookingEmployee();
	} //end setProfile
	
	public void clickBtnToCalculateAll() {
		
		if(checkBasicProfile) {
			helper.processAndShowWageRecordsUsingCheck();
		}
//		wholeReport4EarningBookString=""; //for store report to write into file
//		
//		if(checkBasicProfile) {
//			
//			helper.processAndShowWageRecordsUsingCheck(employeeBook);
//			if(helper.employeeCounter == helper.EmployeeNo) {
//				wholeReport4EarningBookString = helper.showGradeBookResults(employeeBook);
//				
//				helper.restButtons4NewStart(true);
//				
//				frameEmployee.btnOpenFile.setEnabled(false);
//				frameEmployee.btnCalculate.setEnabled(false);
//				frameEmployee.btnCloseFile.setEnabled(false);
//			}
//		}
	}
	
	
	public void openFile() {
		try {
			helper.openFile(filePath);
			
		}catch (FileNotFoundException e) {
//			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null,  e.getMessage(), "FileNotFoundException",
					JOptionPane.INFORMATION_MESSAGE);
		}catch (NullPointerException e) { //added on 01Aug19
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "NullPointerException",
					JOptionPane.INFORMATION_MESSAGE);
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null,  "  The Basic Profile\ndidn't saved as needed!", "No profile Saved ",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void WriteFile() {
		helper.WriteLogFile(employeeBook);
	}
	
	public void closefile() {
		helper.closefile();
	}
	
	public void readFile() {
		try {
			if(helper.isCreateFile || helper.isReadFile) {
				refreshJFrame();
				helper.isCreateFile = false;
				
			}else
				helper.readFile();
			    helper.readRecordData();
		}catch(ClassNotFoundException | IOException | NoSuchElementException
				| NullPointerException | ClassCastException | IllegalArgumentException
				| ArrayIndexOutOfBoundsException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage() +"\n" 
					+e.toString()+ "/n"
					+"\n                 ClassNotFoundException"
					+"\n                 IOException"
					+"\n                 NoSuchElementException"
					+"\n                 IllegalArgumentException"
					+"\n                 NullPointerException"
					+"\n                 ClassCastException"
					+"\n                 ArrayIndexOutOfBoundsException",
					"Maybe Re-Open Another File to Read?", JOptionPane.INFORMATION_MESSAGE);		
		}
	}
	
	public void showPieChartOfWageDistribution() {
		helper.runPieChart3DFX();
	}
	
	public void clearRecordTextFields() {
		helper.clearRecordTextFields();
	}
	
	public void outputFinalReport() {
		helper.outputFinalReport();
	}
	
	public void clearProfileAndResults() {
		helper.clearProfileAndResults();
	}
	
	public void refreshJFrame() {
		helper.refreshJFrame(theDesktop);
	}
	
	public void exitAppInQuestion() {
		helper.exitAppInQuestion();
	}
}