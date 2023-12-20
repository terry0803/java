package Lin.polymorphism.employee.helper;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

import Lin.library.enummenu.FileStreamType_MenuOption;
import Lin.library.enummenu.NumberType_MenuOption;
import Lin.polymorphism.employee.BasePlusCommissionEmployee;
import Lin.polymorphism.employee.CommissionEmployee;
import Lin.polymorphism.employee.Employee;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.frame.BasePlusCommissionEmployeeJFrame;
import Lin.polymorphism.employee.frame.CommissionEmployeeJFrame_V1;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;
// import io.swingtest.app18.table.TableDemoPayrollSystem_23July19_v3;
// import io.swingtest2.app108.TableDemoPayrollSystem_23July19_v2;

public class Helper4BasePlusCommissionEmployee extends Helper4CommissionEmployee {

    public Helper4BasePlusCommissionEmployee(/* Component component */BasePlusCommissionEmployeeJFrame component) {
        super(component);
        frameEmployee = component;
    }

    @Override
    public void checkInputRecordData() {
        super.checkInputRecordData();
        
        
        if (checkRecord) {
            checkRecord = validationNumber_GUI.checkNumberValueByComparing_iflag(
                ((BasePlusCommissionEmployeeJFrame) frameEmployee).txtFieldBaseSalary.getText(),
                EmployeeRecordIndices.BASE_SALARY.getRecordIndexType(), 0, 1,
                NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex());
        }

        if (!checkRecord)
            ((BasePlusCommissionEmployeeJFrame) frameEmployee).txtFieldBaseSalary.setText("");

        @Override
        public void getInputDataReady(boolean _checkRecord) {
            super.getInputDataReady(_checkRecord);
            // _grossSales = Double.parseDouble(((BasePlusCommissionEmployeeJFrame) frameEmployee).txtFieldGrossSales.getText());
            // _commissionRate = Double
            //     .parseDouble(((BasePlusCommissionEmployeeJFrame) frameEmployee).txtFieldCommissionRate.getText());
            if (_checkRecord) {
                _baseSalary = Double
                    .parseDouble(((BasePlusCommissionEmployeeJFrame) frameEmployee).txtFieldBaseSalary.getText());
            }
        }

        @Override
        public void processAndShowWageRecordsUsingCheck() {
            if (employeeCounter < EmployeeNo) {
                checkInputRecordData();
                getInputDataReady(checkRecord);
                if (checkRecord) {
                    BasePlusCommissionEmployee record = new BasePlusCommissionEmployee(_firstName, _lastName, _SSN,
                        frameEmployee.isSimpleFormat, _grossSales, _commissionRate, _baseSalary);
                    addNprocessEveryNewRecord(record);
                } // end inner if
            } // end outer if
        } // end processAndShowWageRecordsUsingCheck
    
        
        @Override
        public Object[][] returnObjectArray() {
            Object[][] data = new Object[eList_BasePlusCommission.size()][frameEmployee.listTitleName4Table.size()];

            for (int i = 0; i < eList_BasePlusCommission.size(); i++) {
                Object[] object = {
                    eList_BasePlusCommission.get(i).getSocialSecurityNumber(),
                    eList_BasePlusCommission.get(i).getFirstName(),
                    eList_BasePlusCommission.get(i).getLastName(),
                    eList_BasePlusCommission.get(i).getGrossSales(),
                    eList_BasePlusCommission.get(i).getCommissionRate(),
                    eList_BasePlusCommission.get(i).getEarnings(),
                    eList_BasePlusCommission.get(i).getLevel(),
                    eList_BasePlusCommission.get(i).getColor(),
                    eList_BasePlusCommission.get(i).getBaseSalary()
                };
                data[i] = object;
            }

            return data;
        } //end returnObjectArray()

        @Override
        public void readFile() throws NumberFormatException, ClassNotFoundException, NoSuchElementException,
                NullPointerException, ClassCastException, IOException {
            super.readFile();
        }
        
        
        @Override
        public void readRecordData() throws NumberFormatException, ClassNotFoundException, NoSuchElementException,
                NullPointerException, ClassCastException, IOException {
            BasePlusCommissionEmployee record = null;
            if (isFileChooserOK()) {
                eList_BasePlusCommission = new ArrayList<BasePlusCommissionEmployee>();

                if (streamType_MenuOption == FileStreamType_MenuOption.STANDARD_BASED) {
                    while (inputT.hasNext()) { // while there is more to read
                        inputT.next();
                        record = new BasePlusCommissionEmployee(inputT.next(), inputT.next(), inputT.next(), true,
                                inputT.nextDouble(), inputT.nextDouble(), inputT.nextDouble());
                        System.out.println("record=" + record);

                        addNprocessEveryNewRecord((BasePlusCommissionEmployee)record);
                    } // end while
                } else if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
                    for (int i = 0; (i < EmployeeNo); i++) {
                        record = (BasePlusCommissionEmployee) inputO.readObject();
                        record = new BasePlusCommissionEmployee(record.getFirstName(), record.getLastName(),
                                record.getSocialSecurityNumber(),
                                frameEmployee.isSimpleFormat, 
                                record.getGrossSales(), record.getCommissionRate(), record.getBaseSalary());

                        addNprocessEveryNewRecord((BasePlusCommissionEmployee)record);
                    } // end for
                } // end else
            } // end if
            // fileChoosing4WriteOrRead.closeFile(); // MAKE SURE to Close File Opened.
            closefile();
        } // end class Helper4CommissionEmployee
    }

