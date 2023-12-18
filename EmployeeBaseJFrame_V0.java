package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthLookAndFeel;

import Lin.library.enummenu.Buttons4UniversalProcess_MenuOption;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.buttoncontroller.ButtonController4SuperBase;
import Lin.polymorphism.employee.helper.Helper4SuperEmployeeBase;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class EmployeeBaseJFrame_V0 extends JFrame {

	public static final long serialVersionUID = 1L;
	public static EmployeeBaseJFrame_V0 frame;
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
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_8;
	public JTextField textField_9;
	public JTextField textField_10;
	public JTextField textField_11;
	public JTextField textField_12;
	public JTextField textField_13;
	public JTextField textField_14;
	public JTextField textField_15;
	public JTextField textField_16;

	public static String employeeType;

	public JButton[] optionButtons;
	public Buttons4UniversalProcess_MenuOption[] basicChoices = { Buttons4UniversalProcess_MenuOption.Process_Data,
			Buttons4UniversalProcess_MenuOption.Refresh, Buttons4UniversalProcess_MenuOption.Clear_Record,
			Buttons4UniversalProcess_MenuOption.Set_Profile,
			Buttons4UniversalProcess_MenuOption.Clear_Profile_and_Results,
			Buttons4UniversalProcess_MenuOption.Output_Results, Buttons4UniversalProcess_MenuOption.OpenFile,
			Buttons4UniversalProcess_MenuOption.ReadFile, Buttons4UniversalProcess_MenuOption.WriteFile,
			Buttons4UniversalProcess_MenuOption.CloseFile, Buttons4UniversalProcess_MenuOption.PieChartDemo };

	JTabbedPane tabbedPane;
	public String title4InputArea = "Main Frame Area", tip4InputArea = "Input and Calculation Area";
	public String title4TextArea = "Report Output Area", tip4TextArea = "Output Final Result Here";
	public String title4List = "Record List Area", tip4List = "Output Record List";
	public String title4JTable = "Record Output Table", tip4JTable = "Output Records Here";

	public JTextArea txtArea4RecordTextArea;
	public JList<Object> listArea4RecordListArea;
	// https://stackoverflow.com/questions/5212983/jlist-add-remove-item
	public DefaultListModel<Object> listModel = new DefaultListModel<Object>(); // need to import
																				// javax.swing.DefaultListModel
	// (DefaultListModel is a raw type. References to generic type
	// DefaultListModel<E> should be parameterized)

	public JTable table4RecordTableArea;
	public Box box1, box2, box3;

	public static List<JTextField> listTxtFieldsProfileG = new LinkedList<>();
	public static List<JTextField> listTxtFieldsEmployeeG = new LinkedList<>();
	public List<JTextField> listTxtFieldsResultsG = new LinkedList<>();

	public List<String> listTitleName4Table = new LinkedList<>();
	public String[] namesUsed;
	public Object[][] dataUsed; // used for JTable

	public JScrollPane tableAggregate; // needed late in inherited classes

	public static String classNameCurrent = null;
	private JMenu mnLookFeel;
	private JMenuBar menuBar;
	private ButtonGroup buttonGroup;
	private JRadioButtonMenuItem itemCustom;

	public static ButtonController4SuperBase buttonController;
	public Helper4SuperEmployeeBase helper4Employee;
	public static Verifier4SuperEmployeeBase Verifier4SuperEmployee;
	public EmployeeBaseBook employeeBook;

	public JDesktopPane theDesktop; // added 28July19 after done 'InheritancePayrollSystem'
	public String employeeType4JFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		employeeType = "SuperBase Employee (by TRLin 2023/11/08)";
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmployeeBaseJFrame_V0 frame = new EmployeeBaseJFrame_V0(employeeType);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		employeeType = "SuperBase Employee";
		EmployeeBaseJFrame_V0 frame_real = new EmployeeBaseJFrame_V0(employeeType);
		Main_Run(frame_real, employeeType, new ButtonController4SuperBase(frame_real, null)); // null */);

	}

	/**
	 * @wbp.parser.constructor
	 */
	public EmployeeBaseJFrame_V0(String employeeType) {
		employeeType4JFrame = employeeType;
		setupAll();
	}

	public EmployeeBaseJFrame_V0(String employeeType, JDesktopPane _theDesktop) {
		employeeType4JFrame = "SuperBase Employee";
		setupAll();
		theDesktop = _theDesktop;
	}

	public void setupAll() {
		setUpTitleAndBasics4JFrame("Employee-Book Application for ", employeeType);
		createAndSetupCoreComponents4JTabbedPane(); // added
		setupComponents4JPanel(); // move all components in contentPane inside of this method.

		initializeButtonArray();
		initializeTextFieldArrayList();

		initializeTitleNamesList4JTable();
		initialize4TitleNamesString4JTable();

		setupMenubarWithLookAndFeel(300, 0, 115, 35, EmployeeBaseJFrame_V0.class, this);

		verifier4Employee = new Verifier4SuperEmployeeBase(this);
		helper4Employee = new Helper4SuperEmployeeBase(this);
	}

	public static void Main_Run(EmployeeBaseJFrame_V0 component, String _employeeType,
			ButtonController4SuperBase _buttonController/* JDesktopPane theDesktop */) {
		buttonController = _buttonController;
		buttonController.addActionListenerOnButtons();
		run2StartOrRefresh(_employeeType, component);

		component.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		component.pluginVerifier4TextFieldArrayList();
		component.setVisible(true);
	}
	
	public static void setTheLookAndFeelInMain(/*Component resourceBase*/ EmployeeBaseJFrame_V0 _frame) {
    // Set the look and feel.
    if(classNameCurrent == null) {
        initLookAndFeel(_frame.getClass());
        // initLookAndFeel(component.getClass()));
    } else {
        try {
            UIManager.setLookAndFeel(classNameCurrent);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    SwingUtilities.updateComponentTreeUI(_frame);
    // SwingUtilities.updateComponentTreeUI(component);
}
	
	public static void run2StartOrRefresh(String _frameTitle, EmployeeBaseJFrame_V0 component) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                // Set the look and feel.
	                setTheLookAndFeelInMain(component);

	                frame = component;

	                frame.setTitle(_frameTitle + "-App");
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setBounds(100, 100, 704, 750);
	                frame.setVisible(true);

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

	protected void setUpTitleAndBasics4JFrame(String _frameTitle, String _employeeType) {
	    setTitle(_frameTitle + _employeeType);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 705, 745);
	}

	
	protected void createAndSetupCoreComponents4JTabbedPane() {
	    contentPane = new JPanel();
	    // contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //original
	    contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, Color.CYAN, null)); // modified
	    contentPane.setBackground(new Color(225, 225, 255)); //added on 4Aug19
	    
	    contentPane.setLayout(null); // without this line, layout is funny!

	    box1 = Box.createHorizontalBox();
	    box2 = Box.createHorizontalBox();
	    box3 = Box.createHorizontalBox();

	    txtArea4RecordTextArea = new JTextArea(500, 650); // original (500, 400)
	    txtArea4RecordTextArea.setEditable(false);
	    //txtArea4RecordTextArea.setLineWrap(true); // with this line on--> no horizontal JScrollPane
	    box1.add(new JScrollPane(txtArea4RecordTextArea));

	    listArea4RecordListArea = new JList<>();
	    listArea4RecordListArea.setBounds(10, 10, 500, 600);
	    listArea4RecordListArea.setAutoscrolls(true);
	    // add(box); //Can be deleted
	    box2.add(new JScrollPane(listArea4RecordListArea));

	 // Add both core-components of panel (for RecordBasic) and box to JTabbedPane
	    tabbedPane = new JTabbedPane(); // Create JTabbedPane()
	    tabbedPane.addTab(title4InputArea, null, contentPane, tip4InputArea);
	    tabbedPane.addTab(title4TextArea, null, box1, tip4TextArea);
	    tabbedPane.addTab(title4List, null, box2, tip4List);
	    tabbedPane.addTab(title4JTable, null, box3, tip4JTable);

	    /**
	     * google "JTabbedPane() color" Colorize a tab in a JTabbedPane using java swing
	     * https://stackoverflow.com/questions/11333946/colorize-a-tab-in-a-jtabbedpane-using-java-swing
	     */
	    tabbedPane.setBackgroundAt(0, Color.CYAN);
	    tabbedPane.setBackgroundAt(1, Color.GREEN);
	    tabbedPane.setBackgroundAt(2, Color.YELLOW);
	    tabbedPane.setBackgroundAt(3, Color.MAGENTA);

	    getContentPane().add(tabbedPane);

	    setSize(712,750);
	    setVisible(true);
	    
	}


	

	/**
	 * Create the frame.
	 */
	protected void setupComponents4JPanel()  {
		setTitle("Employee-Book Application (by TRLin 2023/11/08)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnSetProfile = new JButton("Set Profile");
		btnSetProfile.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnSetProfile.setBackground(new Color(227, 227, 227));
		btnSetProfile.setBounds(10, 10, 263, 29);
		contentPane.add(btnSetProfile);

		lblNewLabel = new JLabel("Company:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 49, 74, 29);
		contentPane.add(lblNewLabel);

		JTextField textField = new JTextField();
		textField.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
		textField.setBounds(94, 53, 179, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		btnClearProfileresults = new JButton("Clear Profile/Results");
		btnClearProfileresults.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		btnClearProfileresults.setBackground(new Color(227, 227, 227));
		btnClearProfileresults.setBounds(344, 10, 263, 29);
		contentPane.add(btnClearProfileresults);

		lblTotalEmployee = new JLabel("Total Employee:");
		lblTotalEmployee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEmployee.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotalEmployee.setBounds(340, 49, 90, 29);
		contentPane.add(lblTotalEmployee);

		JTextField textField_1 = new JTextField();
		textField_1.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
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
		textField_2.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
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
		lblSsn.setBounds(10, 165, 74, 29);
		contentPane.add(lblSsn);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setBackground(new Color(255, 255, 255));
		lblFirstName.setBounds(10, 196, 74, 29);
		contentPane.add(lblFirstName);

		lblRightName = new JLabel("Right Name:");
		lblRightName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRightName.setForeground(Color.BLACK);
		lblRightName.setBackground(new Color(255, 255, 128));
		lblRightName.setBounds(10, 227, 74, 29);
		contentPane.add(lblRightName);

		JTextField textField_3 = new JTextField();
		textField_3.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 128), null, null));
		textField_3.setColumns(10);
		textField_3.setBounds(94, 169, 96, 21);
		contentPane.add(textField_3);

		JTextField textField_4 = new JTextField();
		textField_4.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_4.setColumns(10);
		textField_4.setBounds(94, 200, 96, 21);
		contentPane.add(textField_4);

		JTextField textField_5 = new JTextField();
		textField_5.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setColumns(10);
		textField_5.setBounds(94, 231, 96, 21);
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
		textField_6.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_6.setColumns(10);
		textField_6.setBounds(478, 165, 125, 21);
		contentPane.add(textField_6);

		JTextField textField_7 = new JTextField();
		textField_7.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
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
		textField_8.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
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
		textField_9.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
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
		textField_14.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_14.setBackground(new Color(255, 198, 198));
		textField_14.setColumns(10);
		textField_14.setBounds(478, 387, 96, 21);
		contentPane.add(textField_14);

		JTextField textField_15 = new JTextField();
		textField_15.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
		textField_15.setBackground(new Color(255, 198, 198));
		textField_15.setColumns(10);
		textField_15.setBounds(478, 431, 96, 21);
		contentPane.add(textField_15);

		JTextField textField_16 = new JTextField();
		textField_16.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 0, 160), null, null));
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
	protected void initializeButtonArray() {
	    JButton[] buttonsInitialized = {
	        btnCalculate, btnRefresh, btnClearRecord, btnSetProfile,btnClearProfileresults,
	        btnOutputToTextArea, btnExit, btnOpenFile, btnReadFile, btnWriteFile, btnCloseFile, btnPieChartDemo 
	    };

	    optionButtons = buttonsInitialized;
	    for (int i = 0; i < basicChoices.length; i++) {
	        optionButtons[i].setIcon(new ImageIcon(EmployeeBaseJFrame_V0.class.getResource(basicChoices[i].getImageIcon())));
	        optionButtons[i].setText(basicChoices[i].getButtonType());
	        System.out.println("i=" + i + " " + basicChoices[i].getImageIcon());

	        contentPane.add(optionButtons[i]); //I believe this line is no need. Confirm later
	    }
	} // end initializeButtonArray()

	protected void initializeTextFieldArrayList() {
	    JTextField[] txtFieldsProfile = { textField, textField_1 };
	    JTextField[] txtFieldsEmployee = { textField_3, textField_4, textField_5, textField_2 };
	    JTextField[] txtFieldsOutput = { textField_6, textField_8, textField_7, textField_9, 
	    		textField_14, textField_15, textField_16 };
	    
	    for (JTextField txtField : txtFieldsProfile) {
	        //txtField.setInputVerifier(verifier4SuperEmployeeBase); // for verification
	        listTxtFieldsProfileG.add(txtField);
	        //contentPane.add(txtField);
	    }

	    for (JTextField txtField : txtFieldsEmployee) {
	        //txtField.setInputVerifier(verifier4SuperEmployeeBase); // for verification
	        listTxtFieldsEmployeeG.add(txtField);
	        //contentPane.add(txtField);
	    }

	    for (JTextField txtField : txtFieldsOutput) {
	        listTxtFieldsResultsG.add(txtField);
	        //contentPane.add(txtField);
	    }

	}

	
	
	protected void pluginVerifier4TextFieldArrayList() {
	    for (JTextField txtField : listTxtFieldsEmployeeG) {
	        txtField.setInputVerifier(verifier4Employee); // for verification
	    }
	    // listTxtFieldsEmployeeG

	    for (JTextField txtField : listTxtFieldsProfileG) {
	        txtField.setInputVerifier(verifier4Employee); // for verification
	    }
	    // listTxtFieldsProfileG
	}

	public void initializeTitleNamesList4JTable() {
	    String[] titleNames4Table = { 
	        EmployeeRecordIndices.SSN.getRecordIndexType(),
	        EmployeeRecordIndices.FIRST_NAME.getRecordIndexType(),
	        EmployeeRecordIndices.LAST_NAME.getRecordIndexType() 
	    };
	    

	    for (String titleName : titleNames4Table) {
	        listTitleName4Table.add(titleName);
	    }
	}

	    public void initialize4TitleNamesString4JTable(/* List<String> listTitleName4Table */) {
	        namesUsed = new String[listTitleName4Table.size()];

	        for (int i = 0; i < namesUsed.length; i++) {
	            namesUsed[i] = listTitleName4Table.get(i).toString(); // .toString() is not needed for String objects
	        }
	    }
	    
	    
	    static void initLookAndFeel(Class<?> resourceBase) {
	        SynthLookAndFeel lookAndFeel = new SynthLookAndFeel();

	        try {
	            // SynthLookAndFeel load() method throws a checked exception
	            // (java.text.ParseException) so it must be handled

	            //lookAndFeel.load(EmployeeBaseJFrame.class.getResourceAsStream("synthDemo.xml"), EmployeeBaseJFrame.class);
	            lookAndFeel.load(resourceBase.getResourceAsStream("synthDemo.xml"), resourceBase);

	            UIManager.setLookAndFeel(lookAndFeel);
	        } catch (Exception e) {
	            System.err.println("Couldn't get specified look and feel (" + lookAndFeel + "), for some reason.");
	            System.err.println("Using the default look and feel.");
	            e.printStackTrace();
	        }
	    }

	    
	    protected void setupMenubarWithLookAndFeel(int _x, int _y, int _width, int _height, Class<?> resourceBase, Component component) {
	        menuBar = new JMenuBar();
	        menuBar.setMargin(new Insets(4, 4, 4, 4));
	        menuBar.setBackground(Color.CYAN);
	        menuBar.setBounds(_x, _y, _width, _height); // e.g. menuBar.setBounds(300, 0, 115, 35);
	        contentPane.add(menuBar);

	        mnLookFeel = new JMenu(" Look&Feel");
	        mnLookFeel.setHorizontalAlignment(SwingConstants.CENTER);
	        mnLookFeel.setPreferredSize(new Dimension(115, 22));
	        mnLookFeel.setToolTipText("Change LOOK & FEEL");
	        mnLookFeel.setBounds(new Rectangle(3, 3, 3, 3));
	        mnLookFeel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 12));
	        mnLookFeel.setBorderPainted(true);
	        mnLookFeel.setBackground(new Color(255, 182, 193));
	        mnLookFeel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, 
	        		Color.BLUE, new Color(255, 250, 205), new Color(135, 206, 235)));
	        
	        buttonGroup = new ButtonGroup();
	        final UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
	        for (int i = 0; i < info.length; i++) {
	            JRadioButtonMenuItem item = new JRadioButtonMenuItem(info[i].getName(), i == 4); // i == 0 original
	            item.setForeground(new Color(200, 0, 200)); 
	            item.setBackground(new Color(200, 255, 200));
	            final String className = info[i].getClassName();
	            System.out.println(className);

	            item.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent ae) {
	                    try {
	                        UIManager.setLookAndFeel(className);
	                    } catch (Exception e) {
	                        System.out.println(e);
	                    }
	                    SwingUtilities.updateComponentTreeUI(/*resourceBase*/component); // modified by using Component to this for the
	                    // consideration of re-use in inheritance
	                    /*
	                    * SwingUtilities.updateComponentTreeUI(EmployeeBaseJFrame.this); // It was old
	                    * one. (OK; but it won't do nay good for re-use consideration)
	                    */
	                    classNameCurrent = className;
	                }
	            });
	            buttonGroup.add(item);
	            mnLookFeel.add(item);
	        }
	        
	        
	        itemCustom = new JRadioButtonMenuItem("Custom", false);
	        itemCustom.setForeground(new Color(0, 0, 0)); // added by mc
	        itemCustom.setBackground(new Color(255, 0, 0));
	        itemCustom.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	                //try { initLookAndFeel(); }
	                try {
	                    initLookAndFeel(resourceBase);
	                } catch (Exception e) {
	                    System.out.println(e);
	                }
	                SwingUtilities.updateComponentTreeUI(EmployeeBaseJFrame_V0.this);
	            }
	        });
	        buttonGroup.add(itemCustom);
	        mnLookFeel.add(itemCustom);
	        // --------------End Design ButtonGroup for LookAndFeel----------------
	        menuBar.add(mnLookFeel);
	    }
	        //setupMenuBarWithLookAndFeel()

	        public void addJTable2Box() {
	            box3.add(tableAggregate);
	        }

	        public EmployeeBaseBook setBasics2StartBookingEmployee() {
	            employeeBook = new EmployeeBaseBook(helper4Employee.CompanyName, helper4Employee.EmployeeNo, true);
	            btnOpenFile.setEnabled(true); // added on 01Aug19
	            btnCalculate.setEnabled(false); // old one
	            return employeeBook;
	        }

	        public EmployeeBaseJFrame_V0 refreshJFrame() {
	            EmployeeBaseJFrame_V0 component = new EmployeeBaseJFrame_V0(employeeType4JFrame);
	            buttonController = new ButtonController4SuperBase(new EmployeeBaseJFrame_V0(employeeType4JFrame), theDesktop);
	            Main_Run(component, employeeType4JFrame, buttonController);

	            return component;
	        }   
	    }
