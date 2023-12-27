package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import Lin.payablesys.employeetype.earningbook.CommissionEmployeeBook;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.payablesys.employeetype.earningbook.HourlyEmployeeBook;
import Lin.payablesys.employeetype.earningbook.SalariedEmployeeBook;
import Lin.polymorphism.employee.buttoncontroller.ButtonController4SuperBase;
import Lin.polymorphism.employee.helper.Helper4CommissionEmployee;
import Lin.polymorphism.employee.helper.Helper4HourlyEmployee;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;

public class HourlyEmployeeJFrame_V0 extends EmployeeBaseJFrame_V0{
	public JTextField txtFieldHoursWorked;
	public JTextField txtFieldHourlyWage;
	public JTextField txtFieldMaxHWorked;
	public JTextField txtFieldRate4ExtraHours;
	public JLabel lblHoursWorked;
	public JLabel lblHourlyWage;
	public JLabel lblMaxWorkedhours;
	public JLabel lblExtrahoursRate;
	
	@Override
	protected void setupComponents4JPanel() { // x100 needed
		super.setupComponents4JPanel();
		contentPane.setLayout(null);
		lblHoursWorked = new JLabel("Hours Worked:");
		lblHoursWorked.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoursWorked.setForeground(Color.BLACK);
		lblHoursWorked.setBackground(new Color(255, 255, 128));
		lblHoursWorked.setBounds(28, 341, 96, 29);
		contentPane.add(lblHoursWorked);
		
		lblHourlyWage = new JLabel("Hourly Wage:");
		lblHourlyWage.setHorizontalAlignment(SwingConstants.LEFT);
		lblHourlyWage.setForeground(Color.BLACK);
		lblHourlyWage.setBackground(new Color(255, 255, 128));
		lblHourlyWage.setBounds(40, 376, 84, 29);
		contentPane.add(lblHourlyWage);
		
		txtFieldHoursWorked = new JTextField();
		txtFieldHoursWorked.setColumns(10);
		txtFieldHoursWorked.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldHoursWorked.setBounds(122, 380, 96, 21);
		contentPane.add(txtFieldHoursWorked);
		
		txtFieldHourlyWage = new JTextField();
		txtFieldHourlyWage.setColumns(10);
		txtFieldHourlyWage.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldHourlyWage.setBounds(122, 346, 96, 21);
		contentPane.add(txtFieldHourlyWage);
		
		txtFieldMaxHWorked= new JTextField();
		txtFieldMaxHWorked.setColumns(10);
		txtFieldMaxHWorked.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldMaxHWorked.setBounds(248, 311, 96, 21);
		contentPane.add(txtFieldMaxHWorked);
		
		txtFieldRate4ExtraHours = new JTextField();
		txtFieldRate4ExtraHours.setColumns(10);
		txtFieldRate4ExtraHours.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldRate4ExtraHours.setBounds(248, 380, 96, 21);
		contentPane.add(txtFieldRate4ExtraHours);
		
		lblMaxWorkedhours = new JLabel("Max Worked-Hours :");
		lblMaxWorkedhours.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxWorkedhours.setForeground(Color.BLACK);
		lblMaxWorkedhours.setBackground(new Color(255, 255, 128));
		lblMaxWorkedhours.setBounds(236, 272, 136, 29);
		contentPane.add(lblMaxWorkedhours);
		
		lblExtrahoursRate = new JLabel("Extra-Hours Rate:");
		lblExtrahoursRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblExtrahoursRate.setForeground(Color.BLACK);
		lblExtrahoursRate.setBackground(new Color(255, 255, 128));
		lblExtrahoursRate.setBounds(236, 342, 136, 29);
		contentPane.add(lblExtrahoursRate);
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
		employeeType = "Hourly Employee (by Ting_Ruei Lin)";
		HourlyEmployeeJFrame_V0 component = new HourlyEmployeeJFrame_V0(employeeType);
		Main_Run(component, employeeType, new ButtonController4SuperBase(component, null));
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public HourlyEmployeeJFrame_V0(String employeeType) {
		super(employeeType);
		employeeType4JFrame = "Commission Employee (by Ting_Ruei Lin)";
		helper4Employee = new Helper4HourlyEmployee(this);
	}

	/**
	 * Create the frame. (Didn't use this in this time; Maybe consider using it in
	 * the future)
	 */
	public HourlyEmployeeJFrame_V0(String employeeType, JDesktopPane theDesktop) {
		super(employeeType);
		helper4Employee = new Helper4HourlyEmployee(this);
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
		listTxtFieldsEmployeeG.add(txtFieldHoursWorked);
		listTxtFieldsEmployeeG.add(txtFieldHourlyWage);
		listTxtFieldsEmployeeG.add(txtFieldMaxHWorked);
		listTxtFieldsEmployeeG.add(txtFieldRate4ExtraHours);
	}

	// end initializeTextFieldArrayList()

	@Override
	public EmployeeBaseBook setBasics2StartBookingEmployee() {
		employeeBook = new HourlyEmployeeBook(helper4Employee.CompanyName, helper4Employee.EmployeeNo, true);

		return employeeBook;
	}

	public EmployeeBaseJFrame_V0 refreshJFrame(JDesktopPane theDesktop) {
		EmployeeBaseJFrame_V0 component = new HourlyEmployeeJFrame_V0(employeeType4JFrame);

		// verifier4Employee = new
		// Verifier4CommissionEmployee((CommissionEmployeeJFrame) component);
		// helper4Employee = new Helper4CommissionEmployee((CommissionEmployeeJFrame)
		// component);

		buttonController = new ButtonController4SuperBase(component, theDesktop);
		Main_Run(component, employeeType4JFrame, buttonController);

		return component;
}
}
