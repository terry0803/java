package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Lin.payablesys.employeetype.*;

public class CommissionEmployeeJFrame_231108 extends EmployeeBaseJFrame_V1 {

    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        employeeType = "Commission Employee by Mei-Chun Lo 2023/11/08";
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CommissionEmployeeJFrame_231108 frame = new CommissionEmployeeJFrame_231108(employeeType);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CommissionEmployeeJFrame_231108(String employeeType) {
        super(employeeType);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
//        setContentPane(contentPane);
    }
}