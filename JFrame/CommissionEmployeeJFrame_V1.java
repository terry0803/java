// Fig. 9.10: CommissionEmployee.java
// CommissionEmployee class uses methods to manipulate its 
// private instance variables.
package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import Lin.payablesys.employeetype.earningbook.CommissionEmployeeBook;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.buttoncontroller.ButtonController4SuperBase;
import Lin.polymorphism.employee.helper.Helper4CommissionEmployee;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;

public class CommissionEmployeeJFrame_V1 extends EmployeeBaseJFrame_V0 {
	public JTextField txtFieldGrossSales;
	public JTextField txtFieldCommissionRate;
	public JLabel lblGrossSales;
	public JLabel lblCommissionRate;

	public static void main(String[] args) {
//		employeeType="Commission Employee";
//		EventQueue.invokeLater(new Runnable(){
//			public void run() {
//				try {
//					CommissionEmployeeJFrame_V1 frame = new CommissionEmployeeJFrame_V1(employeeType);
//					frame.setVisible(true);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		employeeType = "Commission Employee (by Ting_Ruei Lin)";
		CommissionEmployeeJFrame_V1 component = new CommissionEmployeeJFrame_V1(employeeType);
		Main_Run(component, employeeType, new ButtonController4SuperBase(component, null));
	}

	/**
	 * @wbp.parser.constructor
	 */
	public CommissionEmployeeJFrame_V1(String employeeType) {
		super(employeeType);
		employeeType4JFrame = "Commission Employee (by Ting_Ruei Lin)";
		helper4Employee = new Helper4CommissionEmployee(this);
	}

	/**
	 * Create the frame. (Didn't use this in this time; Maybe consider using it in
	 * the future)
	 */
	public CommissionEmployeeJFrame_V1(String employeeType, JDesktopPane theDesktop) {
		super(employeeType);
		helper4Employee = new Helper4CommissionEmployee(this);
	}

	@Override
	protected void setupComponents4JPanel() { // x100 needed
		super.setupComponents4JPanel();
		contentPane.setLayout(null);

		lblGrossSales = new JLabel("Gross Sales:");
		lblGrossSales.setBounds(41, 354, 69, 15);
		lblGrossSales.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGrossSales.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblGrossSales);

		txtFieldGrossSales = new JTextField();
		txtFieldGrossSales.setBounds(120, 352, 96, 21);
		txtFieldGrossSales.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldGrossSales.setColumns(10);
		contentPane.add(txtFieldGrossSales);

		lblCommissionRate = new JLabel("Commission Rate:");
		lblCommissionRate.setBounds(252, 295, 109, 15);
		lblCommissionRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommissionRate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblCommissionRate);

		txtFieldCommissionRate = new JTextField();
		txtFieldCommissionRate.setBounds(262, 320, 96, 21);
		txtFieldCommissionRate.setColumns(10);
		txtFieldCommissionRate.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		contentPane.add(txtFieldCommissionRate);
	}

	@Override
	public void initializeTitleNamesList4JTable() {
		super.initializeTitleNamesList4JTable();
		listTitleName4Table.add(EmployeeRecordIndices.GROSS_SALES.getRecordIndexType()); // EmployeeR
		listTitleName4Table.add(EmployeeRecordIndices.COMMISSION_RATE.getRecordIndexType());
		listTitleName4Table.add(EmployeeRecordIndices.EARNINGS.getRecordIndexType());
		listTitleName4Table.add(EmployeeRecordIndices.WAGE_LEVEL.getRecordIndexType());
		listTitleName4Table.add(EmployeeRecordIndices.INDEX_COLOR.getRecordIndexType());
	}

	/**
	 * Initialize JTextField array for record's textFields.
	 */
	@Override
	protected void initializeTextFieldArrayList() {
		super.initializeTextFieldArrayList();
		listTxtFieldsEmployeeG.add(txtFieldGrossSales);
		listTxtFieldsEmployeeG.add(txtFieldCommissionRate);
	}

	// end initializeTextFieldArrayList()

	@Override
	public EmployeeBaseBook setBasics2StartBookingEmployee() {
		employeeBook = new CommissionEmployeeBook(helper4Employee.CompanyName, helper4Employee.EmployeeNo, true);

		return employeeBook;
	}

	public EmployeeBaseJFrame_V0 refreshJFrame(JDesktopPane theDesktop) {
		EmployeeBaseJFrame_V0 component = new CommissionEmployeeJFrame_V1(employeeType4JFrame);

		// verifier4Employee = new
		// Verifier4CommissionEmployee((CommissionEmployeeJFrame) component);
		// helper4Employee = new Helper4CommissionEmployee((CommissionEmployeeJFrame)
		// component);

		buttonController = new ButtonController4SuperBase(component, theDesktop);
		Main_Run(component, employeeType4JFrame, buttonController);

		return component;
	}

}
