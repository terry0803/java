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
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.frame.CommissionEmployeeJFrame_V1;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;
//import Lin.polymorphism.system.EmployeePayrollSystem_23July19_v3;
//import Lin.polymorphism.employee.menupotion.EmployeeRecordIndices;
// import io.swingtest.app18.table.TableDemoPayrollSystem_23July19_v3;
// import io.swingtest2.app108.TableDemoPayrollSystem_23July19_v2;

public class Helper4CommissionEmployee extends Helper4SuperEmployeeBase {

	public Helper4CommissionEmployee(/* Component component */CommissionEmployeeJFrame_V1 component) {
		super(component);
		frameEmployee = (CommissionEmployeeJFrame_V1) component;
	}

	@Override
	public void checkInputRecordData() {
		super.checkInputRecordData();
		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkNumberValueByComparing_1flag(
					((CommissionEmployeeJFrame_V1) frameEmployee).txtFieldGrossSales.getText(),
					EmployeeRecordIndices.GROSS_SALES.getRecordIndexType(), 0, 1,
					NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex());

			if (!checkRecord)
				((CommissionEmployeeJFrame_V1) frameEmployee).txtFieldGrossSales.setText("");
		}
	}

	@Override
	public void getInputDataReady(boolean _checkRecord) {
		super.getInputDataReady(_checkRecord);
		if (_checkRecord) {
			_grossSales = Double
					.parseDouble(((CommissionEmployeeJFrame_V1) frameEmployee).txtFieldGrossSales.getText());
			_commissionRate = Double
					.parseDouble(((CommissionEmployeeJFrame_V1) frameEmployee).txtFieldCommissionRate.getText());
		}
	}

	@Override
	public void processAndShowWageRecordsUsingCheck() {
		if (employeeCounter < EmployeeNo) {
			checkInputRecordData();
			getInputDataReady(checkRecord);
			if (checkRecord) {
				CommissionEmployee record = new CommissionEmployee(_firstName, _lastName, _SSN,
						frameEmployee.isSimpleFormat, _grossSales, _commissionRate);
				addNprocessEveryNewRecord(record);
			} // end inner if
		} // end outer if
	}
// end processAndShowWageRecordsUsingCheck

	@Override
	public Object[][] returnObjectArray() {
		Object[][] data = new Object[eList_Commission.size()][frameEmployee.listTitleName4Table.size()];

		for (int i = 0; i < eList_Commission.size(); i++) {
			Object[] object = { eList_Commission.get(i).getSocialSecurityNumber(),
					eList_Commission.get(i).getFirstName(), eList_Commission.get(i).getLastName(),
					eList_Commission.get(i).getGrossSales(), eList_Commission.get(i).getCommissionRate(),
					eList_Commission.get(i).getEarnings(), eList_Commission.get(i).getLevel(),
					eList_Comission.get(i).getColor() };

			data[i] = object;
		}
		return data;
	}

	@Override
	public void readFile() throws NumberFormatException, ClassNotFoundException, NoSuchElementException,
			NullPointerException, ClassCastException, IOException {
		super.readFile();
	} // end readFile()

	@Override
	public void readRecordData() throws NumberFormatException, ClassNotFoundException, NoSuchElementException,
	NullPointerException, ClassCastException, IOException {

		CommissionEmployee record = null;
		if (isFileChoosenOK()) {
			eList_Commission = new ArrayList<CommissionEmployee>();

			if (streamType_MenuOption == FileStreamType_MenuOption.STANDARD_BASED) {
				while (inputT.hasNext()) { // while there is more to read
					inputT.next();
					record = new CommissionEmployee(inputT.next(), inputT.next(), inputT.next(), true,
							inputT.nextDouble(), inputT.nextDouble());
					System.out.println("record=" + record);

					addNprocessEveryNewRecord(record);
				} // end while
			} else { // FileStreamType_MenuOption.BYTE_BASED
				for (int i = 0; i < EmployeeNo; i++) {
					record = (CommissionEmployee) inputO.readObject();
					record = new CommissionEmployee(record.getFirstName(), record.getLastName(),
							record.getSocialSecurityNumber(), frameEmployee.isSimpleFormat, record.getGrossSales(),
							record.getCommissionRate());

					addNprocessEveryNewRecord(record);
				} // end for
			} // end else
		} // end outer if
		closefile();
	}
}
