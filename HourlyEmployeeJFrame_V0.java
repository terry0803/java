package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class HourlyEmployeeJFrame_V0 extends EmployeeBaseJFrame_V0{
	public JTextField txtFieldHoursWorked;
	public JTextField txtFieldHourlyWage;
	public JTextField txtFieldMaxHWorked;
	public JTextField txtFieldRate4ExtraHours;
	public JLabel lblHoursWorked;
	public JLabel lblHourlyWage;
	public JLabel lblMaxWorkedhours;
	public JLabel lblExtrahoursRate;
	public HourlyEmployeeJFrame_V0(String emploeeType) {
		super(emploeeType);
		
		lblHoursWorked = new JLabel("Hours Worked:");
		lblHoursWorked.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoursWorked.setForeground(Color.BLACK);
		lblHoursWorked.setBackground(new Color(255, 255, 128));
		lblHoursWorked.setBounds(0, 257, 96, 29);
		getContentPane().add(lblHoursWorked);
		
		lblHourlyWage = new JLabel("Hourly Wage:");
		lblHourlyWage.setHorizontalAlignment(SwingConstants.LEFT);
		lblHourlyWage.setForeground(Color.BLACK);
		lblHourlyWage.setBackground(new Color(255, 255, 128));
		lblHourlyWage.setBounds(10, 288, 84, 29);
		getContentPane().add(lblHourlyWage);
		
		txtFieldHoursWorked = new JTextField();
		txtFieldHoursWorked.setColumns(10);
		txtFieldHoursWorked.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldHoursWorked.setBounds(94, 261, 96, 21);
		getContentPane().add(txtFieldHoursWorked);
		
		txtFieldHourlyWage = new JTextField();
		txtFieldHourlyWage.setColumns(10);
		txtFieldHourlyWage.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldHourlyWage.setBounds(94, 292, 96, 21);
		getContentPane().add(txtFieldHourlyWage);
		
		txtFieldMaxHWorked= new JTextField();
		txtFieldMaxHWorked.setColumns(10);
		txtFieldMaxHWorked.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldMaxHWorked.setBounds(217, 230, 96, 21);
		getContentPane().add(txtFieldMaxHWorked);
		
		txtFieldRate4ExtraHours = new JTextField();
		txtFieldRate4ExtraHours.setColumns(10);
		txtFieldRate4ExtraHours.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldRate4ExtraHours.setBounds(217, 291, 96, 21);
		getContentPane().add(txtFieldRate4ExtraHours);
		
		lblMaxWorkedhours = new JLabel("Max Worked-Hours :");
		lblMaxWorkedhours.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxWorkedhours.setForeground(Color.BLACK);
		lblMaxWorkedhours.setBackground(new Color(255, 255, 128));
		lblMaxWorkedhours.setBounds(217, 191, 108, 29);
		getContentPane().add(lblMaxWorkedhours);
		
		lblExtrahoursRate = new JLabel("Extra-Hours Rate:");
		lblExtrahoursRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblExtrahoursRate.setForeground(Color.BLACK);
		lblExtrahoursRate.setBackground(new Color(255, 255, 128));
		lblExtrahoursRate.setBounds(217, 257, 108, 29);
		getContentPane().add(lblExtrahoursRate);
	}
	  /**
     * Launch the application.
     */
    public static void main(String[] args) {
        employeeType="Hourly Employee";
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HourlyEmployeeJFrame_V0 frame = new HourlyEmployeeJFrame_V0(employeeType);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
