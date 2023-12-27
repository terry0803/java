// Fig. 9.10: CommissionEmployee.java
// CommissionEmployee class uses methods to manipulate its 
// private instance variables.
package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CommissionEmployeeJFrame_V0 extends EmployeeBaseJFrame_V0{
	public CommissionEmployeeJFrame_V0(String employeeType) {
		super(employeeType);
	}
	public static void main(String[] args) {
		employeeType="Commission Employee";
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					CommissionEmployeeJFrame_V0 frame = new CommissionEmployeeJFrame_V0(employeeType);
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   } 
