package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;

public class SalariedEmployeeJFrame extends EmployeeBaseJFrame_V0{
	public SalariedEmployeeJFrame(String emploeeType) {
		super(emploeeType);
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