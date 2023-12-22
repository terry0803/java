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
import Lin.polymorphism.employee.helper.Helper4SuperEmployeeBase;

public /* abstract */ class ButtonController4SuperBase {
    Helper4SuperEmployeeBase helper;

    public boolean checkBasicProfile = false;
    public JButton[] optionButtons;
    Buttons4UniversalProcess_MenuOption[] btnChoicesEnums;
    EmployeeBaseJFrame_V0 frameEmployee;
    ReadFileExample readFile;
    public File fileWrite = null, fileRead = null;
    public EmployeeBaseBook employeeBook;
    private String filePath = "./filePath";

    public String wholeReport4EarningBook = ""; // for writing to file

    JDesktopPane theDesktop;

    public ButtonController4SuperBase(EmployeeBaseJFrame_V0 component, JDesktopPane _theDesktop) {
        frameEmployee = component;
        optionButtons = frameEmployee.optionButtons;
        btnChoicesEnums = frameEmployee.basicChoices;
        helper = frameEmployee.helper4Employee;
        employeeBook = frameEmployee.employeeBook;
        theDesktop = _theDesktop;
    }

    public void addActionListenerOnButtons() {
        for (int task = 0; task < optionButtons.length; task++) {
            optionButtons[task].addActionListener(new ButtonHandlerBySwitch());
        }
    }

    private class ButtonHandlerBySwitch implements ActionListener {
        private String taskChoiceType_S;
        private Buttons4UniversalProcess_MenuOption btnChoice;

        public void actionPerformed(ActionEvent event) {
            taskChoiceType_S = event.getActionCommand();
            JOptionPane.showMessageDialog(null, taskChoiceType_S);
            for (int i = 0; i < optionButtons.length; i++) {
                if (btnChoice.getButtonType() == taskChoiceType_S) {
                    JOptionPane.showMessageDialog(null, btnChoicesEnums[i].getButtonType());
                    btnChoice = btnChoicesEnums[i];
                    break;
                }
            }
            try {
                switchChoices(btnChoice);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void switchChoices(Buttons4UniversalProcess_MenuOption choiceEnum) throws FileNotFoundException {
        switch (choiceEnum) {
            case Set_Profile:
                clickBtnToSetProfile();
                break;
            case Process_Data:
                clickBtnToCalculateAll();
                break;
            case Refresh:
                refreshJFrame(); // Implement this method according to your requirement
                break;
            case Output_Results:
                outputFinalReport2TextArea(); // Implement this method according to your requirement
                break;
            case Clear_Record:
                clearRecordTextFields(); // Implement this method according to your requirement
                break;
            case Clear_Profile_and_Results:
                clearProfileAndResults(); // Implement this method according to your requirement
                break;
            case OpenFile:
                openfile(); // Implement this method according to your requirement
                break;
            case ReadFile:
                readFile(); // Implement this method according to your requirement
                break;
            case WriteFile:
                writeFile(); // Implement this method according to your requirement
                break;
            case CloseFile:
                closefile(); // Implement this method according to your requirement
                break;
            case PieChartDemo:
                showPieChartOfWageDistribution(); // Implement this method according to your requirement
                break;
            case Exit:
                System.exit(0);
        }
    }

    public void clickBtnToSetProfile() {
        if (helper.isReadFile) {
            JOptionPane.showMessageDialog(null, "Please re-input data.", "GUI needs to be Refreshed!", JOptionPane.INFORMATION_MESSAGE);
            refreshJFrame();
        } else {
            helper.prepareBasicProfileUsingCheck();
            checkBasicProfile = helper.checkProfile();
            JOptionPane.showMessageDialog(null, "checkBasicProfile=" + helper.checkProfile);
            if (checkBasicProfile) {
                frameEmployee.helper4Employee.enableProfileTextBoxes(false);
                setProfile();
                JOptionPane.showMessageDialog(null, "Start Inputting Record", "Basic-Profile OK!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void setProfile() {
    	frameEmployee.btnCalculate.setEnabled(true);
    	frameEmployee.btnOpenFile.setEnabled(false);
        employeeBook = frameEmployee.setBasics2StartBookingEmployee();
    }

    public void clickBtnToCalculateAll() {
        wholeReport4EarningBook = ""; // for store report to write into file
        if (checkBasicProfile) {
            helper.processAndShowWageRecordsUsingCheck(employeeBook);
            if (helper.employeeCounter == helper.EmployeeNo) {
                wholeReport4EarningBook = helper.showGradeBookResults(employeeBook);
            }
            helper.setButtons4NewStart(true);
            frameEmployee.btnOpenFile.setEnabled(false);
            frameEmployee.btnCalculate.setEnabled(false);
            frameEmployee.btnCloseFile.setEnabled(false);
//            frameEmployee.btnWriteFile.setEnabled(true);
//            frameEmployee.btnClearFile.setEnabled(true);
//            frameEmployee.btnOutputAll.setEnabled(true);
//            frameEmployee.btnPieChartDemo.setEnabled(true);
//            frameEmployee.btnRefresh.setEnabled(true);
//            frameEmployee.btnReadFile.setEnabled(true);
        }
    }

    public void openfile() {
        try {
            helper.openfile(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FileNotFoundException", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) { // added on 01Aug19
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "NullPointerException", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "The Basic Profile\\ndidn't saved as needed!", "No profile Saved ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeFile() {
        helper.writeFile(employeeBook);
    }

    public void closefile() {
        helper.closefile();
    }

    public void readFile() {
        try {
            if (helper.isCreateFile || helper.isReadFile) {
                refreshJFrame(); // added on 28July19
                helper.isCreateFile = false;
            } else 
                helper.readFile();
                // TO DO readFile() Exceptions //ClassNotFoundException | IOException | NoSuchElementException
            
        } catch (ClassNotFoundException | IOException | NoSuchElementException | NullPointerException | NumberFormatException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n" + "\n               ClassNotFoundException" 
            + "\n                                  IOException" + "\n                 NoSuchElementException"
            + "\n                         NumberFormatException"+"\n                     NullPointerException",
            "Maybe Re-Open Another File to Read", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void showPieChartOfWageDistribution() {
        //helper.showPieChartOfWageDistribution(employeeBook);
        helper.switchPieChartType(/* employeeBook */);
    }

    public void clearRecordTextFields() {
        helper.clearRecordTextFields();
    }

    public void outputFinalReport2TextArea() {
        helper.outputFinalReport2TextArea();
    }

    public void clearProfileAndResults() {
        helper.clearProfileAndResults();
    }

    public void refreshJFrame() {
    	
    	helper.refreshJFrame(theDesktop);
        // implementation of refreshJFrame
    }
}