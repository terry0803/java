// Fig. 9.10: CommissionEmployee.java
// CommissionEmployee class uses methods to manipulate its 
// private instance variables.
package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class CommissionEmployeeJFrame_V1 extends EmployeeBaseJFrame_V0{
	public JTextField txtFieldGrossSales;
	public JTextField txtFieldCommissionRate;
	public CommissionEmployeeJFrame_V1(String employeeType) {
		super(employeeType);
		
		JLabel lblGrossSale = new JLabel("Gross Sales:");
		lblGrossSale.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrossSale.setForeground(Color.BLACK);
		lblGrossSale.setBackground(Color.WHITE);
		lblGrossSale.setBounds(10, 310, 74, 29);
		getContentPane().add(lblGrossSale);
		
		JLabel lblComm = new JLabel("Commission Rate:");
		lblComm.setHorizontalAlignment(SwingConstants.LEFT);
		lblComm.setForeground(Color.BLACK);
		lblComm.setBackground(Color.WHITE);
		lblComm.setBounds(208, 225, 120, 29);
		getContentPane().add(lblComm);
		
		txtFieldGrossSales = new JTextField();
		txtFieldGrossSales.setColumns(10);
		txtFieldGrossSales.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldGrossSales.setBackground(Color.WHITE);
		txtFieldGrossSales.setBounds(94, 314, 96, 21);
		getContentPane().add(txtFieldGrossSales);
		
		txtFieldCommissionRate = new JTextField();
		txtFieldCommissionRate.setColumns(10);
		txtFieldCommissionRate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		txtFieldCommissionRate.setBackground(Color.WHITE);
		txtFieldCommissionRate.setBounds(208, 266, 96, 21);
		getContentPane().add(txtFieldCommissionRate);
	}
	public static void main(String[] args) {
		employeeType="Commission Employee";
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					CommissionEmployeeJFrame_V1 frame = new CommissionEmployeeJFrame_V1(employeeType);
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   } 
