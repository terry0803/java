package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class SalariedEmployeeJFrame_V0 extends EmployeeBaseJFrame_V0{
	public JTextField txtFieldWeeklySalary;
	public JLabel lblNewLabel;
	public SalariedEmployeeJFrame_V0(String emploeeType) {
		super(emploeeType);
		
		lblNewLabel = new JLabel("Weekly Salary:");
		lblNewLabel.setBounds(0, 273, 92, 15);
		getContentPane().add(lblNewLabel);
		
		txtFieldWeeklySalary = new JTextField();
		txtFieldWeeklySalary.setColumns(10);
		txtFieldWeeklySalary.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldWeeklySalary.setBackground(Color.WHITE);
		txtFieldWeeklySalary.setBounds(93, 270, 96, 21);
		getContentPane().add(txtFieldWeeklySalary);
	}
	  /**
     * Launch the application.
     */
    public static void main(String[] args) {
        employeeType="Salaried Employee";
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	SalariedEmployeeJFrame_V0 frame = new SalariedEmployeeJFrame_V0(employeeType);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
