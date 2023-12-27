package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import Lin.payablesys.employeetype.earningbook.CommissionEmployeeBook;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.payablesys.employeetype.earningbook.SalariedEmployeeBook;
import Lin.polymorphism.employee.buttoncontroller.ButtonController4SuperBase;
import Lin.polymorphism.employee.helper.Helper4CommissionEmployee;
import Lin.polymorphism.employee.helper.Helper4SalariedEmployee;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;

public class SalariedEmployeeJFrame_V0 extends EmployeeBaseJFrame_V0{
	public JTextField txtFieldWeeklySalary;
	public JLabel lblNewLabel;

		
	@Override
	protected void setupComponents4JPanel() { // x100 needed
		super.setupComponents4JPanel();
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Weekly Salary:");
		lblNewLabel.setBounds(28, 350, 92, 15);
		contentPane.add(lblNewLabel);
		
		txtFieldWeeklySalary = new JTextField();
		txtFieldWeeklySalary.setColumns(10);
		txtFieldWeeklySalary.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldWeeklySalary.setBackground(Color.WHITE);
		txtFieldWeeklySalary.setBounds(120, 347, 96, 21);
		contentPane.add(txtFieldWeeklySalary);
	}
	  /**
     * Launch the application.
     */
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
		employeeType = "Salaried Employee (by Ting_Ruei Lin)";
		SalariedEmployeeJFrame_V0 component = new SalariedEmployeeJFrame_V0(employeeType);
		Main_Run(component, employeeType, new ButtonController4SuperBase(component, null));
	}

	/**
	 * @wbp.parser.constructor
	 */
	public SalariedEmployeeJFrame_V0(String employeeType) {
		super(employeeType);
		employeeType4JFrame = "Salaried Employee (by Ting_Ruei Lin)";
		helper4Employee = new Helper4SalariedEmployee(this);
	}

	/**
	 * Create the frame. (Didn't use this in this time; Maybe consider using it in
	 * the future)
	 */
	public SalariedEmployeeJFrame_V0(String employeeType, JDesktopPane theDesktop) {
		super(employeeType);
		helper4Employee = new Helper4SalariedEmployee(this);
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
		listTxtFieldsEmployeeG.add(txtFieldWeeklySalary);
	}

	// end initializeTextFieldArrayList()

	@Override
	public EmployeeBaseBook setBasics2StartBookingEmployee() {
		employeeBook = new SalariedEmployeeBook(helper4Employee.CompanyName, helper4Employee.EmployeeNo, true);

		return employeeBook;
	}

	public EmployeeBaseJFrame_V0 refreshJFrame(JDesktopPane theDesktop) {
		EmployeeBaseJFrame_V0 component = new SalariedEmployeeJFrame_V0(employeeType4JFrame);

		// verifier4Employee = new
		// Verifier4CommissionEmployee((CommissionEmployeeJFrame) component);
		// helper4Employee = new Helper4CommissionEmployee((CommissionEmployeeJFrame)
		// component);

		buttonController = new ButtonController4SuperBase(component, theDesktop);
		Main_Run(component, employeeType4JFrame, buttonController);

		return component;
	
}
}
