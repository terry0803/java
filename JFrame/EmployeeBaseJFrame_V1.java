package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class EmployeeBaseJFrame_V1 extends JFrame {

	public static final long serialVersionUID = 1L;
	public JButton btnSetProfile;
	public JButton btnClearProfileresults;
	public JButton btnClearRecord;
	public JButton btnCalculate;
	public JButton btnOutputToTextArea;
	public JButton btnPieChartDemo;
	public JButton btnRefresh;
	public JButton btnOpenFile;
	public JButton btnWriteFile;
	public JButton btnReadFile;
	public JButton btnCloseFile;
	public JButton btnExit;
	public JLabel lblNewLabel;
	public JLabel lblTotalEmployee;
	public JLabel lblEarnings;
	public JLabel lblResultsArea;
	public JLabel lblSsn;
	public JLabel lblFirstName;
	public JLabel lblEmployeeCounter;
	public JLabel lblHighestEarnings;
	public JLabel lblRightName;
	public JLabel lblLowestEarnings;
	public JLabel lblAverageEarnings;
	public JLabel lblUnit;
	public JLabel lblAlevel;
	public JLabel lblBlevel;
	public JLabel lblClevel;
	public JLabel lblUnit_1;
	public JSeparator separator;
	public JSeparator separator_2;
	public JSeparator separator_1_1;
	public JPanel contentPane;
	
	public static String employeeType;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		employeeType = "SuperBase Employee (by TRLin 2023/11/08)";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeBaseJFrame_V1 frame = new EmployeeBaseJFrame_V1(employeeType);
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
	public EmployeeBaseJFrame_V1(String employeeType) {
		setTitle("Employee-Book Application (by TRLin 2023/11/08)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setupComponents4JPanel();
//		btnSetProfile = new JButton("Set Profile");
//		btnSetProfile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnSetProfile.setBackground(new Color(227, 227, 227));
//		btnSetProfile.setBounds(10, 10, 263, 29);
//		contentPane.add(btnSetProfile);
//		
//		lblNewLabel = new JLabel("Company:");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblNewLabel.setBounds(10, 49, 74, 29);
//		contentPane.add(lblNewLabel);
//		
//		JTextField textField = new JTextField();
//		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
//		textField.setBounds(94, 53, 179, 21);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
//		btnClearProfileresults = new JButton("Clear Profile/Results");
//		btnClearProfileresults.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnClearProfileresults.setBackground(new Color(227, 227, 227));
//		btnClearProfileresults.setBounds(340, 10, 263, 29);
//		contentPane.add(btnClearProfileresults);
//		
//		lblTotalEmployee = new JLabel("Total Employee:");
//		lblTotalEmployee.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblTotalEmployee.setBounds(340, 49, 90, 29);
//		contentPane.add(lblTotalEmployee);
//		
//		JTextField textField_1 = new JTextField();
//		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
//		textField_1.setColumns(10);
//		textField_1.setBounds(440, 53, 163, 21);
//		contentPane.add(textField_1);
//		
//		separator = new JSeparator();
//		separator.setOpaque(true);
//		separator.setBackground(new Color(0, 64, 0));
//		separator.setForeground(new Color(0, 128, 0));
//		separator.setBounds(10, 88, 593, 3);
//		contentPane.add(separator);
//		
//		lblEarnings = new JLabel("Earnings:");
//		lblEarnings.setOpaque(true);
//		lblEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblEarnings.setForeground(new Color(0, 0, 0));
//		lblEarnings.setBackground(new Color(255, 255, 128));
//		lblEarnings.setBounds(10, 113, 74, 29);
//		contentPane.add(lblEarnings);
//		
//		JTextField textField_2 = new JTextField();
//		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
//		textField_2.setColumns(10);
//		textField_2.setBounds(94, 117, 96, 21);
//		contentPane.add(textField_2);
//		
//		btnClearRecord = new JButton("Clear Record");
//		btnClearRecord.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnClearRecord.setBackground(new Color(227, 227, 227));
//		btnClearRecord.setBounds(200, 116, 123, 29);
//		contentPane.add(btnClearRecord);
//		
//		lblSsn = new JLabel("SSN:");
//		lblSsn.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblSsn.setForeground(Color.BLACK);
//		lblSsn.setBackground(new Color(255, 255, 128));
//		lblSsn.setBounds(10, 204, 74, 29);
//		contentPane.add(lblSsn);
//		
//		lblFirstName = new JLabel("First Name:");
//		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblFirstName.setForeground(Color.BLACK);
//		lblFirstName.setBackground(new Color(255, 255, 255));
//		lblFirstName.setBounds(10, 243, 74, 29);
//		contentPane.add(lblFirstName);
//		
//		lblRightName = new JLabel("Right Name:");
//		lblRightName.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblRightName.setForeground(Color.BLACK);
//		lblRightName.setBackground(new Color(255, 255, 128));
//		lblRightName.setBounds(10, 282, 74, 29);
//		contentPane.add(lblRightName);
//		
//		JTextField textField_3 = new JTextField();
//		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
//		textField_3.setColumns(10);
//		textField_3.setBounds(94, 208, 96, 21);
//		contentPane.add(textField_3);
//		
//		JTextField textField_4 = new JTextField();
//		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_4.setColumns(10);
//		textField_4.setBounds(94, 247, 96, 21);
//		contentPane.add(textField_4);
//		
//		JTextField textField_5 = new JTextField();
//		textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_5.setBackground(new Color(255, 255, 255));
//		textField_5.setColumns(10);
//		textField_5.setBounds(94, 286, 96, 21);
//		contentPane.add(textField_5);
//		
//		JSeparator separator_1 = new JSeparator();
//		separator_1.setOpaque(true);
//		separator_1.setForeground(new Color(0, 128, 0));
//		separator_1.setBackground(new Color(0, 0, 128));
//		separator_1.setBounds(372, 113, 231, 3);
//		contentPane.add(separator_1);
//		
//		separator_1_1 = new JSeparator();
//		separator_1_1.setOpaque(true);
//		separator_1_1.setForeground(new Color(0, 128, 0));
//		separator_1_1.setBackground(new Color(0, 0, 128));
//		separator_1_1.setBounds(372, 139, 231, 3);
//		contentPane.add(separator_1_1);
//		
//		lblResultsArea = new JLabel("Results Area");
//		lblResultsArea.setHorizontalAlignment(SwingConstants.CENTER);
//		lblResultsArea.setForeground(Color.BLACK);
//		lblResultsArea.setBackground(new Color(255, 255, 128));
//		lblResultsArea.setBounds(372, 113, 231, 29);
//		contentPane.add(lblResultsArea);
//		
//		lblEmployeeCounter = new JLabel("Employee Counter:");
//		lblEmployeeCounter.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblEmployeeCounter.setForeground(Color.BLACK);
//		lblEmployeeCounter.setBackground(new Color(255, 255, 128));
//		lblEmployeeCounter.setBounds(372, 165, 96, 29);
//		contentPane.add(lblEmployeeCounter);
//		
//		JTextField textField_6 = new JTextField();
//		textField_6.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_6.setColumns(10);
//		textField_6.setBounds(478, 165, 125, 21);
//		contentPane.add(textField_6);
//		
//		JTextField textField_7 = new JTextField();
//		textField_7.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_7.setColumns(10);
//		textField_7.setBounds(478, 208, 125, 21);
//		contentPane.add(textField_7);
//		
//		lblHighestEarnings = new JLabel("Highest Earnings:");
//		lblHighestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblHighestEarnings.setForeground(Color.BLACK);
//		lblHighestEarnings.setBackground(new Color(255, 255, 128));
//		lblHighestEarnings.setBounds(372, 204, 96, 29);
//		contentPane.add(lblHighestEarnings);
//		
//		lblLowestEarnings = new JLabel("Lowest Earnings:");
//		lblLowestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblLowestEarnings.setForeground(Color.BLACK);
//		lblLowestEarnings.setBackground(new Color(255, 255, 128));
//		lblLowestEarnings.setBounds(372, 243, 96, 29);
//		contentPane.add(lblLowestEarnings);
//		
//		JTextField textField_8 = new JTextField();
//		textField_8.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_8.setColumns(10);
//		textField_8.setBounds(478, 247, 125, 21);
//		contentPane.add(textField_8);
//		
//		lblAverageEarnings = new JLabel("Average Earnings:");
//		lblAverageEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblAverageEarnings.setForeground(Color.BLACK);
//		lblAverageEarnings.setBackground(new Color(255, 255, 128));
//		lblAverageEarnings.setBounds(372, 282, 96, 29);
//		contentPane.add(lblAverageEarnings);
//		
//		JTextField textField_9 = new JTextField();
//		textField_9.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_9.setColumns(10);
//		textField_9.setBounds(478, 286, 125, 21);
//		contentPane.add(textField_9);
//		
//		separator_2 = new JSeparator();
//		separator_2.setForeground(new Color(0, 128, 0));
//		separator_2.setBackground(new Color(0, 64, 0));
//		separator_2.setBounds(10, 336, 593, 2);
//		contentPane.add(separator_2);
//		
//		JLabel lblDistributionOfWagelevels = new JLabel("Distribution of Wage-Levels");
//		lblDistributionOfWagelevels.setFont(new Font("Berlin Sans FB", Font.ITALIC, 12));
//		lblDistributionOfWagelevels.setOpaque(true);
//		lblDistributionOfWagelevels.setHorizontalAlignment(SwingConstants.CENTER);
//		lblDistributionOfWagelevels.setForeground(Color.BLACK);
//		lblDistributionOfWagelevels.setBackground(new Color(0, 255, 255));
//		lblDistributionOfWagelevels.setBounds(10, 348, 593, 29);
//		contentPane.add(lblDistributionOfWagelevels);
//		
//		lblUnit = new JLabel("Unit:");
//		lblUnit.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblUnit.setForeground(Color.BLACK);
//		lblUnit.setBackground(new Color(255, 255, 128));
//		lblUnit.setBounds(10, 427, 74, 29);
//		contentPane.add(lblUnit);
//		
//		lblAlevel = new JLabel("A_Level>=");
//		lblAlevel.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblAlevel.setForeground(Color.BLACK);
//		lblAlevel.setBackground(new Color(255, 255, 128));
//		lblAlevel.setBounds(199, 388, 74, 29);
//		contentPane.add(lblAlevel);
//		
//		lblBlevel = new JLabel("B_Level  =");
//		lblBlevel.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblBlevel.setForeground(Color.BLACK);
//		lblBlevel.setBackground(new Color(255, 255, 128));
//		lblBlevel.setBounds(199, 427, 74, 29);
//		contentPane.add(lblBlevel);
//		
//		lblClevel = new JLabel("C_Level<=");
//		lblClevel.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblClevel.setForeground(Color.BLACK);
//		lblClevel.setBackground(new Color(255, 255, 128));
//		lblClevel.setBounds(199, 473, 74, 29);
//		contentPane.add(lblClevel);
//		
//		JLabel lblThousand = new JLabel("Thousand");
//		lblThousand.setOpaque(true);
//		lblThousand.setHorizontalAlignment(SwingConstants.CENTER);
//		lblThousand.setForeground(Color.BLACK);
//		lblThousand.setBackground(new Color(255, 255, 0));
//		lblThousand.setBounds(116, 427, 74, 29);
//		contentPane.add(lblThousand);
//		
//		JTextField textField_10 = new JTextField();
//		textField_10.setColumns(10);
//		textField_10.setBackground(new Color(255, 255, 191));
//		textField_10.setBounds(295, 392, 126, 21);
//		contentPane.add(textField_10);
//		
//		JTextField textField_11 = new JTextField();
//		textField_11.setColumns(10);
//		textField_11.setBackground(new Color(255, 255, 191));
//		textField_11.setBounds(295, 431, 41, 21);
//		contentPane.add(textField_11);
//		
//		JTextField textField_12 = new JTextField();
//		textField_12.setColumns(10);
//		textField_12.setBackground(new Color(255, 255, 191));
//		textField_12.setBounds(380, 431, 41, 21);
//		contentPane.add(textField_12);
//		
//		JTextField textField_13 = new JTextField();
//		textField_13.setColumns(10);
//		textField_13.setBackground(new Color(255, 255, 191));
//		textField_13.setBounds(295, 477, 126, 21);
//		contentPane.add(textField_13);
//		
//		lblUnit_1 = new JLabel("~");
//		lblUnit_1.setOpaque(true);
//		lblUnit_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblUnit_1.setForeground(Color.BLACK);
//		lblUnit_1.setBackground(new Color(255, 255, 191));
//		lblUnit_1.setBounds(344, 433, 27, 15);
//		contentPane.add(lblUnit_1);
//		
//		JTextField textField_14 = new JTextField();
//		textField_14.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_14.setBackground(new Color(255, 198, 198));
//		textField_14.setColumns(10);
//		textField_14.setBounds(478, 387, 96, 21);
//		contentPane.add(textField_14);
//		
//		JTextField textField_15 = new JTextField();
//		textField_15.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_15.setBackground(new Color(255, 198, 198));
//		textField_15.setColumns(10);
//		textField_15.setBounds(478, 431, 96, 21);
//		contentPane.add(textField_15);
//		
//		JTextField textField_16 = new JTextField();
//		textField_16.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
//		textField_16.setColumns(10);
//		textField_16.setBackground(new Color(255, 198, 198));
//		textField_16.setBounds(478, 477, 96, 21);
//		contentPane.add(textField_16);
//		
//		JSeparator separator_2_1 = new JSeparator();
//		separator_2_1.setForeground(new Color(0, 128, 0));
//		separator_2_1.setBackground(new Color(0, 64, 0));
//		separator_2_1.setBounds(10, 512, 593, 2);
//		contentPane.add(separator_2_1);
//		
//		btnCalculate = new JButton("Calculate");
//		btnCalculate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnCalculate.setBackground(new Color(227, 227, 227));
//		btnCalculate.setBounds(10, 524, 96, 29);
//		contentPane.add(btnCalculate);
//		
//		btnOpenFile = new JButton("Open File");
//		btnOpenFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnOpenFile.setBackground(new Color(227, 227, 227));
//		btnOpenFile.setBounds(10, 575, 96, 29);
//		contentPane.add(btnOpenFile);
//		
//		btnOutputToTextArea = new JButton("Output to TextArea");
//		btnOutputToTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnOutputToTextArea.setBackground(new Color(227, 227, 227));
//		btnOutputToTextArea.setBounds(141, 524, 145, 29);
//		contentPane.add(btnOutputToTextArea);
//		
//		btnPieChartDemo = new JButton("Pie-Chart Demo");
//		btnPieChartDemo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnPieChartDemo.setBackground(new Color(227, 227, 227));
//		btnPieChartDemo.setBounds(334, 524, 145, 29);
//		contentPane.add(btnPieChartDemo);
//		
//		btnRefresh = new JButton("Refresh");
//		btnRefresh.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnRefresh.setBackground(new Color(227, 227, 227));
//		btnRefresh.setBounds(513, 524, 90, 29);
//		contentPane.add(btnRefresh);
//		
//		btnWriteFile = new JButton("Write File");
//		btnWriteFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnWriteFile.setBackground(new Color(227, 227, 227));
//		btnWriteFile.setBounds(141, 575, 104, 29);
//		contentPane.add(btnWriteFile);
//		
//		btnReadFile = new JButton("Read File");
//		btnReadFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnReadFile.setBackground(new Color(227, 227, 227));
//		btnReadFile.setBounds(266, 575, 96, 29);
//		contentPane.add(btnReadFile);
//		
//		btnCloseFile = new JButton("Close File");
//		btnCloseFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnCloseFile.setBackground(new Color(227, 227, 227));
//		btnCloseFile.setBounds(380, 575, 99, 29);
//		contentPane.add(btnCloseFile);
//		
//		btnExit = new JButton("Exit");
//		btnExit.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
//		btnExit.setBackground(new Color(227, 227, 227));
//		btnExit.setBounds(513, 575, 90, 29);
//		contentPane.add(btnExit);
//		
//		textField_17 = new JTextField();
//		textField_17.setBounds(227, 286, 96, 21);
//		contentPane.add(textField_17);
//		textField_17.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("Commission Rate:");
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setBounds(200, 257, 145, 15);
//		contentPane.add(lblNewLabel_1);
	}
	protected void setupComponents4JPanel()
	{
		btnSetProfile = new JButton("Set Profile");
		btnSetProfile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnSetProfile.setBackground(new Color(227, 227, 227));
		btnSetProfile.setBounds(10, 10, 263, 29);
		contentPane.add(btnSetProfile);
		
		lblNewLabel = new JLabel("Company:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 49, 74, 29);
		contentPane.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
		textField.setBounds(94, 53, 179, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnClearProfileresults = new JButton("Clear Profile/Results");
		btnClearProfileresults.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnClearProfileresults.setBackground(new Color(227, 227, 227));
		btnClearProfileresults.setBounds(340, 10, 263, 29);
		contentPane.add(btnClearProfileresults);
		
		lblTotalEmployee = new JLabel("Total Employee:");
		lblTotalEmployee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEmployee.setBounds(340, 49, 90, 29);
		contentPane.add(lblTotalEmployee);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
		textField_1.setColumns(10);
		textField_1.setBounds(440, 53, 163, 21);
		contentPane.add(textField_1);
		
		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBackground(new Color(0, 64, 0));
		separator.setForeground(new Color(0, 128, 0));
		separator.setBounds(10, 88, 593, 3);
		contentPane.add(separator);
		
		lblEarnings = new JLabel("Earnings:");
		lblEarnings.setOpaque(true);
		lblEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEarnings.setForeground(new Color(0, 0, 0));
		lblEarnings.setBackground(new Color(255, 255, 128));
		lblEarnings.setBounds(10, 113, 74, 29);
		contentPane.add(lblEarnings);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
		textField_2.setColumns(10);
		textField_2.setBounds(94, 117, 96, 21);
		contentPane.add(textField_2);
		
		btnClearRecord = new JButton("Clear Record");
		btnClearRecord.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnClearRecord.setBackground(new Color(227, 227, 227));
		btnClearRecord.setBounds(200, 116, 123, 29);
		contentPane.add(btnClearRecord);
		
		lblSsn = new JLabel("SSN:");
		lblSsn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSsn.setForeground(Color.BLACK);
		lblSsn.setBackground(new Color(255, 255, 128));
		lblSsn.setBounds(10, 201, 74, 29);
		contentPane.add(lblSsn);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setBackground(new Color(255, 255, 255));
		lblFirstName.setBounds(10, 232, 74, 29);
		contentPane.add(lblFirstName);
		
		lblRightName = new JLabel("Right Name:");
		lblRightName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRightName.setForeground(Color.BLACK);
		lblRightName.setBackground(new Color(255, 255, 128));
		lblRightName.setBounds(10, 263, 74, 29);
		contentPane.add(lblRightName);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
		textField_3.setColumns(10);
		textField_3.setBounds(94, 205, 96, 21);
		contentPane.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_4.setColumns(10);
		textField_4.setBounds(94, 236, 96, 21);
		contentPane.add(textField_4);
		
		JTextField textField_5 = new JTextField();
		textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setColumns(10);
		textField_5.setBounds(94, 267, 96, 21);
		contentPane.add(textField_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setForeground(new Color(0, 128, 0));
		separator_1.setBackground(new Color(0, 0, 128));
		separator_1.setBounds(372, 113, 231, 3);
		contentPane.add(separator_1);
		
		separator_1_1 = new JSeparator();
		separator_1_1.setOpaque(true);
		separator_1_1.setForeground(new Color(0, 128, 0));
		separator_1_1.setBackground(new Color(0, 0, 128));
		separator_1_1.setBounds(372, 139, 231, 3);
		contentPane.add(separator_1_1);
		
		lblResultsArea = new JLabel("Results Area");
		lblResultsArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultsArea.setForeground(Color.BLACK);
		lblResultsArea.setBackground(new Color(255, 255, 128));
		lblResultsArea.setBounds(372, 113, 231, 29);
		contentPane.add(lblResultsArea);
		
		lblEmployeeCounter = new JLabel("Employee Counter:");
		lblEmployeeCounter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeCounter.setForeground(Color.BLACK);
		lblEmployeeCounter.setBackground(new Color(255, 255, 128));
		lblEmployeeCounter.setBounds(372, 165, 96, 29);
		contentPane.add(lblEmployeeCounter);
		
		JTextField textField_6 = new JTextField();
		textField_6.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_6.setColumns(10);
		textField_6.setBounds(478, 165, 125, 21);
		contentPane.add(textField_6);
		
		JTextField textField_7 = new JTextField();
		textField_7.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_7.setColumns(10);
		textField_7.setBounds(478, 208, 125, 21);
		contentPane.add(textField_7);
		
		lblHighestEarnings = new JLabel("Highest Earnings:");
		lblHighestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHighestEarnings.setForeground(Color.BLACK);
		lblHighestEarnings.setBackground(new Color(255, 255, 128));
		lblHighestEarnings.setBounds(372, 204, 96, 29);
		contentPane.add(lblHighestEarnings);
		
		lblLowestEarnings = new JLabel("Lowest Earnings:");
		lblLowestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLowestEarnings.setForeground(Color.BLACK);
		lblLowestEarnings.setBackground(new Color(255, 255, 128));
		lblLowestEarnings.setBounds(372, 243, 96, 29);
		contentPane.add(lblLowestEarnings);
		
		JTextField textField_8 = new JTextField();
		textField_8.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_8.setColumns(10);
		textField_8.setBounds(478, 247, 125, 21);
		contentPane.add(textField_8);
		
		lblAverageEarnings = new JLabel("Average Earnings:");
		lblAverageEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAverageEarnings.setForeground(Color.BLACK);
		lblAverageEarnings.setBackground(new Color(255, 255, 128));
		lblAverageEarnings.setBounds(372, 282, 96, 29);
		contentPane.add(lblAverageEarnings);
		
		JTextField textField_9 = new JTextField();
		textField_9.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_9.setColumns(10);
		textField_9.setBounds(478, 286, 125, 21);
		contentPane.add(textField_9);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 128, 0));
		separator_2.setBackground(new Color(0, 64, 0));
		separator_2.setBounds(10, 336, 593, 2);
		contentPane.add(separator_2);
		
		JLabel lblDistributionOfWagelevels = new JLabel("Distribution of Wage-Levels");
		lblDistributionOfWagelevels.setFont(new Font("Berlin Sans FB", Font.ITALIC, 12));
		lblDistributionOfWagelevels.setOpaque(true);
		lblDistributionOfWagelevels.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistributionOfWagelevels.setForeground(Color.BLACK);
		lblDistributionOfWagelevels.setBackground(new Color(0, 255, 255));
		lblDistributionOfWagelevels.setBounds(10, 348, 593, 29);
		contentPane.add(lblDistributionOfWagelevels);
		
		lblUnit = new JLabel("Unit:");
		lblUnit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnit.setForeground(Color.BLACK);
		lblUnit.setBackground(new Color(255, 255, 128));
		lblUnit.setBounds(10, 427, 74, 29);
		contentPane.add(lblUnit);
		
		lblAlevel = new JLabel("A_Level>=");
		lblAlevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlevel.setForeground(Color.BLACK);
		lblAlevel.setBackground(new Color(255, 255, 128));
		lblAlevel.setBounds(199, 388, 74, 29);
		contentPane.add(lblAlevel);
		
		lblBlevel = new JLabel("B_Level  =");
		lblBlevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBlevel.setForeground(Color.BLACK);
		lblBlevel.setBackground(new Color(255, 255, 128));
		lblBlevel.setBounds(199, 427, 74, 29);
		contentPane.add(lblBlevel);
		
		lblClevel = new JLabel("C_Level<=");
		lblClevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClevel.setForeground(Color.BLACK);
		lblClevel.setBackground(new Color(255, 255, 128));
		lblClevel.setBounds(199, 473, 74, 29);
		contentPane.add(lblClevel);
		
		JLabel lblThousand = new JLabel("Thousand");
		lblThousand.setOpaque(true);
		lblThousand.setHorizontalAlignment(SwingConstants.CENTER);
		lblThousand.setForeground(Color.BLACK);
		lblThousand.setBackground(new Color(255, 255, 0));
		lblThousand.setBounds(116, 427, 74, 29);
		contentPane.add(lblThousand);
		
		JTextField textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(255, 255, 191));
		textField_10.setBounds(295, 392, 126, 21);
		contentPane.add(textField_10);
		
		JTextField textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBackground(new Color(255, 255, 191));
		textField_11.setBounds(295, 431, 41, 21);
		contentPane.add(textField_11);
		
		JTextField textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBackground(new Color(255, 255, 191));
		textField_12.setBounds(380, 431, 41, 21);
		contentPane.add(textField_12);
		
		JTextField textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBackground(new Color(255, 255, 191));
		textField_13.setBounds(295, 477, 126, 21);
		contentPane.add(textField_13);
		
		lblUnit_1 = new JLabel("~");
		lblUnit_1.setOpaque(true);
		lblUnit_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnit_1.setForeground(Color.BLACK);
		lblUnit_1.setBackground(new Color(255, 255, 191));
		lblUnit_1.setBounds(344, 433, 27, 15);
		contentPane.add(lblUnit_1);
		
		JTextField textField_14 = new JTextField();
		textField_14.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_14.setBackground(new Color(255, 198, 198));
		textField_14.setColumns(10);
		textField_14.setBounds(478, 387, 96, 21);
		contentPane.add(textField_14);
		
		JTextField textField_15 = new JTextField();
		textField_15.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_15.setBackground(new Color(255, 198, 198));
		textField_15.setColumns(10);
		textField_15.setBounds(478, 431, 96, 21);
		contentPane.add(textField_15);
		
		JTextField textField_16 = new JTextField();
		textField_16.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_16.setColumns(10);
		textField_16.setBackground(new Color(255, 198, 198));
		textField_16.setBounds(478, 477, 96, 21);
		contentPane.add(textField_16);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(new Color(0, 128, 0));
		separator_2_1.setBackground(new Color(0, 64, 0));
		separator_2_1.setBounds(10, 512, 593, 2);
		contentPane.add(separator_2_1);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnCalculate.setBackground(new Color(227, 227, 227));
		btnCalculate.setBounds(10, 524, 96, 29);
		contentPane.add(btnCalculate);
		
		btnOpenFile = new JButton("Open File");
		btnOpenFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnOpenFile.setBackground(new Color(227, 227, 227));
		btnOpenFile.setBounds(10, 575, 96, 29);
		contentPane.add(btnOpenFile);
		
		btnOutputToTextArea = new JButton("Output to TextArea");
		btnOutputToTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnOutputToTextArea.setBackground(new Color(227, 227, 227));
		btnOutputToTextArea.setBounds(141, 524, 145, 29);
		contentPane.add(btnOutputToTextArea);
		
		btnPieChartDemo = new JButton("Pie-Chart Demo");
		btnPieChartDemo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnPieChartDemo.setBackground(new Color(227, 227, 227));
		btnPieChartDemo.setBounds(334, 524, 145, 29);
		contentPane.add(btnPieChartDemo);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnRefresh.setBackground(new Color(227, 227, 227));
		btnRefresh.setBounds(513, 524, 90, 29);
		contentPane.add(btnRefresh);
		
		btnWriteFile = new JButton("Write File");
		btnWriteFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnWriteFile.setBackground(new Color(227, 227, 227));
		btnWriteFile.setBounds(141, 575, 104, 29);
		contentPane.add(btnWriteFile);
		
		btnReadFile = new JButton("Read File");
		btnReadFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnReadFile.setBackground(new Color(227, 227, 227));
		btnReadFile.setBounds(266, 575, 96, 29);
		contentPane.add(btnReadFile);
		
		btnCloseFile = new JButton("Close File");
		btnCloseFile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnCloseFile.setBackground(new Color(227, 227, 227));
		btnCloseFile.setBounds(380, 575, 99, 29);
		contentPane.add(btnCloseFile);
		
		btnExit = new JButton("Exit");
		btnExit.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnExit.setBackground(new Color(227, 227, 227));
		btnExit.setBounds(513, 575, 90, 29);
		contentPane.add(btnExit);
	}
}
