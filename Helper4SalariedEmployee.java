package Lin.polymorphism.employee.helper;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

import Lin.library.enummenu.FileStreamType_MenuOption;
import Lin.library.enummenu.NumberType_MenuOption;
import Lin.polymorphism.employee.CommissionEmployee;
import Lin.polymorphism.employee.Employee;
import Lin.polymorphism.employee.SalariedEmployee;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.frame.CommissionEmployeeJFrame_V1;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;
// import io.swingtest2.jtable.TableDemo4PayrollSystem_23July19_v3;
// import io.swingtest2.app108.TableDemo4PayrollSystem_23July19_v2;

import Lin.polymorphism.employee.frame.SalariedEmployeeJFrame;

public class Helper4SalariedEmployee extends Helper4SuperEmployeeBase {

    public Helper4SalariedEmployee(/* Component component */SalariedEmployeeJFrame component) {
        super(component);
        frameEmployee = (SalariedEmployeeJFrame) component;
    }

    @Override
    public void checkInputRecordData() {
        super.checkInputRecordData();
        if (checkRecord) {
            checkRecord = validationNumber_GUI.checkNumberValueByComparing_iflag(
                ((SalariedEmployeeJFrame) frameEmployee).txtFieldWeeklySalary.getText(),
                EmployeeRecordIndices.WEEKLY_SALARY.getRecordIndexType(), 0, 1,
                NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex());
        }

        if (!checkRecord)
            ((SalariedEmployeeJFrame) frameEmployee).txtFieldWeeklySalary.setText("");
    } // end checkInputRecordData()

    /**
     * finally-> if everything is ready--> get all input data in Record area
     */
    @Override
    public void getInputDataReady(boolean _checkRecord) {
        super.getInputDataReady(_checkRecord);
        if (_checkRecord) {
            _weekSalary = Double.parseDouble(((SalariedEmployeeJFrame) frameEmployee).txtFieldWeeklySalary.getText());
        }
    }

    @Override
    public void processAndShowWageRecordsUsingCheck() {
        if (employeeCounter < EmployeeNo) {
            checkInputRecordData();
            getInputDataReady(checkRecord);
            if (checkRecord) {
                SalariedEmployee record = new SalariedEmployee(_firstName, _lastName, _SSN, frameEmployee.isSimpleFormat, _weekSalary);
                addNprocessEveryNewRecord(record);
            } // end inner if
        } // end outer if
    } // end processAndShowWageRecordsUsingCheck

    
    @Override
    public Object[][] returnObjectArray() {
        Object[][] data = new Object[eList_Salaried.size()][frameEmployee.listTitleName4Table.size()];

        for (int i = 0; i < eList_Salaried.size(); i++) {
            Object[] object = {
                eList_Salaried.get(i).getSocialSecurityNumber(),
                eList_Salaried.get(i).getFirstName(),
                eList_Salaried.get(i).getLastName(),
                eList_Salaried.get(i).getWeeklySalary(),
                eList_Salaried.get(i).getEarnings(),
                eList_Salaried.get(i).getLevel(),
                eList_Salaried.get(i).getColor()
            };
            data[i] = object;
        }

        return data;
    } //end returnObjectArray()

    
    @Override
    public void readFile() throws NumberFormatException, ClassNotFoundException, NoSuchElementException,
            NullPointerException, ClassCastException, IOException {
        super.readFile();
    } //end readFile()

    @Override
    public void readRecordData() throws NumberFormatException, ClassNotFoundException, NoSuchElementException,
            NullPointerException, ClassCastException, IOException {

        SalariedEmployee record = null;
        if (isFileChooserOK()) {
            eList_Salaried = new ArrayList<SalariedEmployee>();

            if (streamType_MenuOption == FileStreamType_MenuOption.STANDARD_BASED) {
                while (inputT.hasNext()) { // while there is more to read
                    inputT.next(); // Presumably skips a token or consumes a delimiter
                    record = new SalariedEmployee(inputT.next(), inputT.next(), inputT.next(), true,
                            inputT.nextDouble()); // Last double is presumably the salary
                    System.out.println("record=" + record);

                    addNprocessEveryNewRecord(record);
                } // end while
            } else if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
                for (int i = 0; i < EmployeeNo; i++) {
                    record = (SalariedEmployee) inputO.readObject();
                    record = new SalariedEmployee(record.getFirstName(), record.getLastName(),
                            record.getSocialSecurityNumber(), frameEmployee.isSimpleFormat, record.getWeeklySalary());

                    addNprocessEveryNewRecord(record);
                } // end for
            } // end else
        } //end outer if

        closefile(); // MAKE SURE to Close Files Opened.
    } // end class Helper4CommissionEmployee
}
