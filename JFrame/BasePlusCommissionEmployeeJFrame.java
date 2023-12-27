package Lin.polymorphism.employee.frame;

import javax.swing.*;
import java.awt.*;
import Lin.payablesys.employee.*;
import Lin.polymorphism.employee.frame.*;
import javax.swing.border.BevelBorder;

public class BasePlusCommissionEmployeeJFrame extends CommissionEmployeeJFrame_V1 {

	public JTextField txtFieldCommissionRate;
	public JTextField txtFieldGrossSales;
	public JTextField lblGrossSales;
	public JTextField lblCommissionRate;
	public JTextField lblBaseSalary;
	public JTextField txtFieldBaseSalary;

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// GUI components that are used in the program
    public static ButtonControllerSuperBase buttonController;
    public static VerifierCommissionEmployee verifierEmplyee;

    // Constructor
    public BasePlusCommissionEmployeeJFrame(String employeeType) {
        super(employeeType);
        
        JLabel lblComm = new JLabel("Commission Rate:");
        lblComm.setHorizontalAlignment(SwingConstants.LEFT);
        lblComm.setForeground(Color.BLACK);
        lblComm.setBackground(Color.WHITE);
        lblComm.setBounds(208, 208, 120, 29);
        getContentPane().add(lblComm);
        
        JTextField txtFieldCommissionRate = new JTextField();
        txtFieldCommissionRate.setColumns(10);
        txtFieldCommissionRate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
        txtFieldCommissionRate.setBackground(Color.WHITE);
        txtFieldCommissionRate.setBounds(208, 236, 96, 21);
        getContentPane().add(txtFieldCommissionRate);
        
        JTextField txtFieldGrossSales = new JTextField();
        txtFieldGrossSales.setColumns(10);
        txtFieldGrossSales.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
        txtFieldGrossSales.setBackground(Color.WHITE);
        txtFieldGrossSales.setBounds(94, 297, 96, 21);
        getContentPane().add(txtFieldGrossSales);
        
        JLabel lblGrossSale = new JLabel("Gross Sales:");
        lblGrossSale.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGrossSale.setForeground(Color.BLACK);
        lblGrossSale.setBackground(Color.WHITE);
        lblGrossSale.setBounds(10, 293, 74, 29);
        getContentPane().add(lblGrossSale);
        
        txtFieldBaseSalary = new JTextField();
        txtFieldBaseSalary.setColumns(10);
        txtFieldBaseSalary.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
        txtFieldBaseSalary.setBackground(Color.WHITE);
        txtFieldBaseSalary.setBounds(208, 297, 96, 21);
        getContentPane().add(txtFieldBaseSalary);
        
        JLabel lblBaseSalary = new JLabel("Base Salary:");
        lblBaseSalary.setHorizontalAlignment(SwingConstants.LEFT);
        lblBaseSalary.setForeground(Color.BLACK);
        lblBaseSalary.setBackground(Color.WHITE);
        lblBaseSalary.setBounds(208, 269, 120, 29);
        getContentPane().add(lblBaseSalary);
        initializeComponents();
    }

    private void initializeComponents() {
        // Initialization logic for GUI components

        // Layout setup and component adding code goes here
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        employeeType = "BasePlusCommission Employee";
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BasePlusCommissionEmployeeJFrame frame = new BasePlusCommissionEmployeeJFrame(employeeType);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

// Placeholder classes for compilation
class CommissionEmployeeJFrame extends JFrame {
    public CommissionEmployeeJFrame(String employeeType) {
        // Constructor logic
    }
}

class ButtonControllerSuperBase {
    // Button controller logic
}

class VerifierCommissionEmployee {
    // Verifier logic
}