package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class HourlyEmployeeJFrame extends EmployeeBaseJFrame_V0{
	public HourlyEmployeeJFrame(String emploeeType) {
		super(emploeeType);
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
