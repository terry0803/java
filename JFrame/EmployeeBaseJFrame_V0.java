package Lin.polymorphism.employee.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.synth.SynthLookAndFeel;

import Lin.library.enummenu.Buttons4UniversalProcess_MenuOption;
import Lin.payablesys.employeetype.earningbook.EmployeeBaseBook;
import Lin.polymorphism.employee.buttoncontroller.ButtonController4SuperBase;
import Lin.polymorphism.employee.helper.Helper4SuperEmployeeBase1;
import Lin.polymorphism.employee.menuoption.EmployeeRecordIndices;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class EmployeeBaseJFrame_V0 extends JFrame {

	public static final long serialVersionUID = 1L;
	public static EmployeeBaseJFrame_V0 frame;
	public JPanel contentPane;
	public JTextField txtFieldCN;
	public JTextField txtFieldEN;
	public JTextField txtFieldEarnings;
	public JTextField txtFieldSSN;
	public JTextField txtFieldFN;
	public JTextField txtFieldLN;
	public JTextField txtFieldEmpCounter;
	public JTextField txtFieldHighestE;
    public JTextField txtFieldLowestE;
	public JTextField txtFieldAverageE;
	public JTextField txtFieldLA;
	public JTextField txtFieldLB;
	public JTextField txtFieldLC;

	public JLabel lblCompanyName;
	public JLabel lblTotalEmployees;
	public JLabel lblEarnings;
	public JLabel lblSSN;
	public JLabel lblFirstName;
	public JLabel lblLastName;

	public JSeparator separatorResultTop;
	public JSeparator separatorResultBottom;
	public JSeparator separator_1;
	public JSeparator separator_2;
	public JLabel lblAlevel;
	public JLabel lblBlevel;
	public JLabel lblClevel;
	public JLabel lblUnitSymbol;
	public JLabel lblUnit;
	public JLabel lblRange;
	public JLabel lblALowerThreshold;
	public JLabel lblBLowerThreshold;
	public JLabel lblBUpperThreshold;
	public JLabel lblCUpperThreshold;
	public JLabel lblDistribution;
	public JSeparator separator;
	public JLabel lblResultArea;
	public JLabel lblLowestEarnings;
	public JLabel lblAverageEarnings;
	public JLabel lblHighestEarnings;
	public JLabel lblEmpCounter;

	public JButton btnSetProfile;
	public JButton btnClearProfile;
	public JButton btnClearRecord;
	public JButton btnCalculate;
	public JButton btnOpenFile;
	public JButton btnOutputAll;
	public JButton btnWriteFile;
	public JButton btnPieChartDemo;
	public JButton btnReadFile;
	public JButton btnCloseFile;
	public JButton btnRefresh;
	public JButton btnExit;

	public static String employeeType;

	public JButton[] optionButtons;
	public Buttons4UniversalProcess_MenuOption[] basicChoices = {
			Buttons4UniversalProcess_MenuOption.Process_Data,
			Buttons4UniversalProcess_MenuOption.Refresh, 
			Buttons4UniversalProcess_MenuOption.Clear_Record,
			Buttons4UniversalProcess_MenuOption.Set_Profile,
			Buttons4UniversalProcess_MenuOption.Clear_Profile_and_Results,
			Buttons4UniversalProcess_MenuOption.Output_Results, 
			Buttons4UniversalProcess_MenuOption.Exit,
			Buttons4UniversalProcess_MenuOption.OpenFile, 
			Buttons4UniversalProcess_MenuOption.ReadFile,
			Buttons4UniversalProcess_MenuOption.WriteFile, 
			Buttons4UniversalProcess_MenuOption.CloseFile,
			Buttons4UniversalProcess_MenuOption.PieChartDemo };


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
	public Helper4SuperEmployeeBase1 helper4Employee;
	//public static Verifier4SuperEmployeeBase verifier4Employee;
	public EmployeeBaseBook employeeBook;

	public JDesktopPane theDesktop; //added 23Dec17 after done 'InheritancePayrollSystem_28July19_v4
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
		setupComponents4JPanel();// move all components in contentPane inside of this method.

		initializeButtonArray();
		initializeTextFieldArrayList();

		initializeTitleNamesList4JTable();
		initialize4TitleNamesString4JTable();
		
		setupMenubarWithLookAndFeel(300, 0, 115, 35, EmployeeBaseJFrame_V0.class, this);

//		verifier4Employee = new Verifier4SuperEmployeeBase(this);
		helper4Employee = new Helper4SuperEmployeeBase1(this);

	}

	public static void Main_Run(EmployeeBaseJFrame_V0 component, String _employeeType,
			ButtonController4SuperBase _buttonController /* , JDesktopPane theDesktop */ ) {

		buttonController = _buttonController;
		buttonController.addActionListenerOnButtons();
		run2StartOrRefresh(_employeeType, component);

		component.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		component.pluginVerifier4TextFieldArrayList();
		component.setVisible(true);

	}
	
	public static void setTheLookAndFeelInMain(/* Component resourceBase */ EmployeeBaseJFrame_V0 _frame) {
	//  public static void setTheLookAndFellInMain(/*Component component){
			// Set the look and feel
			if (classNameCurrent == null) {
				initLookAndFeel(_frame.getClass());
				// initLookAndFeel(component.getClass());
			} else {
				try {
					UIManager.setLookAndFeel(classNameCurrent);
				} catch (Exception e) {
					System.out.println(e);
				}

				SwingUtilities.updateComponentTreeUI(_frame);
				// SwingUtilities.updateComponentTreeUI(component);
			}
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
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//original
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, Color.CYAN, null));// modified
		contentPane.setBackground(new Color(225, 225, 225)); //added on 17Dec23
		contentPane.setLayout(null); //without this line, layout is funny!

		box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();

		txtArea4RecordTextArea = new JTextArea(500, 650);// original (500, 400)
		txtArea4RecordTextArea.setEditable(false);
//		txtArea4RecordTextArea.setLineWrap(true);//with this line on --> no horizontal JScrollPane
		box1.add(new JScrollPane(txtArea4RecordTextArea));

		listArea4RecordListArea = new JList<>();
		listArea4RecordListArea.setBounds(10, 10, 500, 600);
		listArea4RecordListArea.setAutoscrolls(true);
		// add(box); //Can be deleted
		box2.add(new JScrollPane(listArea4RecordListArea));

		// Add both core-components of panel (for RecordBasic) and box to JTabbedPane
		tabbedPane = new JTabbedPane();// Create JTabbedPane();
		tabbedPane.addTab(title4InputArea, null, contentPane, tip4InputArea);
		tabbedPane.addTab(title4TextArea, null, box1, tip4InputArea);
		tabbedPane.addTab(title4List, null, box2, tip4List);
		tabbedPane.addTab(title4JTable, null, box3, tip4JTable);

		tabbedPane.setBackgroundAt(0, Color.CYAN);
		tabbedPane.setBackgroundAt(1, Color.GREEN);
		tabbedPane.setBackgroundAt(2, Color.YELLOW);
		tabbedPane.setBackgroundAt(3, Color.MAGENTA);

		getContentPane().add(tabbedPane);

		setSize(712, 760);
	    setVisible(true);
	    
	}


	

	/**
	 * Create the frame.
	 */
	protected void setupComponents4JPanel()  {
		lblTotalEmployees = new JLabel("Total Employees:");
		lblTotalEmployees.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEmployees.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotalEmployees.setBounds(445, 75, 104, 15);
		contentPane.add(lblTotalEmployees);

		lblCompanyName = new JLabel("Company:");
		lblCompanyName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompanyName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCompanyName.setBounds(29, 68, 69, 29);
		contentPane.add(lblCompanyName);

		txtFieldCN = new JTextField();
		txtFieldCN.setColumns(10);
		txtFieldCN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldCN.setBounds(108, 79, 131, 21);
		contentPane.add(txtFieldCN);

		txtFieldEN = new JTextField();
		txtFieldEN.setColumns(10);
		txtFieldEN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldEN.setBounds(559, 76, 96, 21);
		contentPane.add(txtFieldEN);

		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setForeground(Color.GREEN);
		separator.setBounds(new Rectangle(7, 7, 16, 16));
		separator.setBackground(new Color(75, 0, 130));
		separator.setBounds(29, 134, 626, 2);
		contentPane.add(separator);

		lblEarnings = new JLabel("Earnings:");
		lblEarnings.setOpaque(true);
		lblEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEarnings.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblEarnings.setBackground(new Color(250, 250, 210));
		lblEarnings.setBounds(29, 166, 69, 29);
		contentPane.add(lblEarnings);

		txtFieldEarnings = new JTextField();
		txtFieldEarnings.setFocusable(false);
		txtFieldEarnings.setEnabled(false);
		txtFieldEarnings.setEditable(false);
		txtFieldEarnings.setColumns(10);
		txtFieldEarnings.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldEarnings.setBounds(108, 170, 96, 21);
		contentPane.add(txtFieldEarnings);

		lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSSN.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSSN.setBounds(45, 245, 69, 29);
		contentPane.add(lblSSN);

		txtFieldSSN = new JTextField();
		txtFieldSSN.setColumns(10);
		txtFieldSSN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldSSN.setBounds(120, 249, 96, 21);
		contentPane.add(txtFieldSSN);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Tines New Roman", Font.BOLD, 12));
		lblFirstName.setBounds(45, 275, 69, 29);
		contentPane.add(lblFirstName);

		
		txtFieldFN = new JTextField();
		txtFieldFN.setColumns(10);
		txtFieldFN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
				        new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldFN.setBounds(120, 279, 96, 21);
		contentPane.add(txtFieldFN);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLastName.setBounds(45, 310, 69, 29);
		contentPane.add(lblLastName);
		
		txtFieldLN = new JTextField();
		txtFieldLN.setColumns(10);
		txtFieldLN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
				        new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLN.setBounds(120, 310, 96, 21);
		contentPane.add(txtFieldLN);
		
		
		lblEmpCounter = new JLabel("Employee Counter:");
		lblEmpCounter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpCounter.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmpCounter.setBounds(445, 208, 104, 29);
		contentPane.add(lblEmpCounter);

		txtFieldEmpCounter = new JTextField();
		txtFieldEmpCounter.setEditable(false);
		txtFieldEmpCounter.setColumns(10);
		txtFieldEmpCounter.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldEmpCounter.setBounds(559, 212, 96, 21);
		contentPane.add(txtFieldEmpCounter);

		lblHighestEarnings = new JLabel("Highest Earnings:");
		lblHighestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHighestEarnings.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHighestEarnings.setBounds(445, 242, 104, 29);
		contentPane.add(lblHighestEarnings);

		
		txtFieldHighestE = new JTextField();
		txtFieldHighestE.setEditable(false);
		txtFieldHighestE.setColumns(10);
		txtFieldHighestE.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175),null, null, null),
				        new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldHighestE.setBounds(559, 246, 96, 21);
		contentPane.add(txtFieldHighestE);

		lblLowestEarnings = new JLabel("Lowest Earnings:");
		lblLowestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLowestEarnings.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLowestEarnings.setBounds(445, 275, 104, 29);
		contentPane.add(lblLowestEarnings);

		txtFieldLowestE = new JTextField();
		txtFieldLowestE.setEditable(false);
		txtFieldLowestE.setColumns(10);
		txtFieldLowestE.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLowestE.setBounds(559, 279, 96, 21);
		contentPane.add(txtFieldLowestE);

		txtFieldAverageE = new JTextField();
		txtFieldAverageE.setEditable(false);
		txtFieldAverageE.setColumns(10);
		txtFieldAverageE.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldAverageE.setBounds(559, 314, 96, 21);
		contentPane.add(txtFieldAverageE);

		lblAverageEarnings = new JLabel("Average Earnings:");
		lblAverageEarnings.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAverageEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAverageEarnings.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAverageEarnings.setBounds(445, 310, 104, 29);
		contentPane.add(lblAverageEarnings);

		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setForeground(Color.GREEN);
		separator_1.setBounds(new Rectangle(7, 7, 16, 16));
		separator_1.setBackground(new Color(75, 0, 130));
		separator_1.setBounds(29, 411, 640, 2);
		contentPane.add(separator_1);

		lblDistribution = new JLabel("Distribution of Wage-Levels");
		lblDistribution.setOpaque(true);
		lblDistribution.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistribution.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblDistribution.setBounds(new Rectangle(2, 2, 2, 2));
		lblDistribution.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), null, null, null));
		lblDistribution.setBackground(new Color(175, 238, 238));
		lblDistribution.setBounds(29, 426, 640, 29);
		contentPane.add(lblDistribution);

		lblAlevel = new JLabel("A_Level  >=");
		lblAlevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlevel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlevel.setBounds(238, 465, 69, 29);
		contentPane.add(lblAlevel);

		txtFieldLA = new JTextField();
		txtFieldLA.setEditable(false);
		txtFieldLA.setColumns(10);
		txtFieldLA.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLA.setBackground(new Color(255, 228, 225));		
		txtFieldLA.setBounds(505, 469, 96, 21);
		contentPane.add(txtFieldLA);

		lblBlevel = new JLabel("B_Level   =");
		lblBlevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBlevel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBlevel.setBounds(238, 504, 69, 29);
		contentPane.add(lblBlevel);

		txtFieldLB = new JTextField();
		txtFieldLB.setEditable(false);
		txtFieldLB.setColumns(10);
		txtFieldLB.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLB.setBackground(new Color(255, 228, 225));
		txtFieldLB.setBounds(505, 508, 96, 21);
		contentPane.add(txtFieldLB);

		lblClevel = new JLabel("C_Level  <=");
		lblClevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClevel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblClevel.setBounds(238, 537, 69, 29);
		contentPane.add(lblClevel);

		txtFieldLC = new JTextField();
		txtFieldLC.setEditable(false);
		txtFieldLC.setColumns(10);
		txtFieldLC.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLC.setBackground(new Color(255, 228, 225));
		txtFieldLC.setBounds(505, 541, 96, 21);
		contentPane.add(txtFieldLC);

		lblALowerThreshold = new JLabel("");
		lblALowerThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		lblALowerThreshold.setOpaque(true);
		lblALowerThreshold.setHorizontalAlignment(SwingConstants.CENTER);
		lblALowerThreshold.setForeground(new Color(0, 0, 0));
		lblALowerThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblALowerThreshold.setBackground(new Color(250, 250, 210));
		lblALowerThreshold.setBounds(344, 465, 119, 29);
		contentPane.add(lblALowerThreshold);

		lblBLowerThreshold = new JLabel("");
		lblBLowerThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		lblBLowerThreshold.setOpaque(true);
		lblBLowerThreshold.setHorizontalAlignment(SwingConstants.CENTER);
		lblBLowerThreshold.setForeground(new Color(0, 0, 0));
		lblBLowerThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBLowerThreshold.setBackground(new Color(250, 250, 210));
		lblBLowerThreshold.setBounds(344, 502, 33, 29);
		contentPane.add(lblBLowerThreshold);

		lblCUpperThreshold = new JLabel("");
		lblCUpperThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblCUpperThreshold.setOpaque(true);
		lblCUpperThreshold.setHorizontalAlignment(SwingConstants.CENTER);
		lblCUpperThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCUpperThreshold.setBackground(new Color(250, 250, 210));
		lblCUpperThreshold.setBounds(344, 537, 119, 29);
		contentPane.add(lblCUpperThreshold);

		lblBUpperThreshold = new JLabel("");
		lblBUpperThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		lblBUpperThreshold.setOpaque(true);
		lblBUpperThreshold.setHorizontalAlignment(SwingConstants.CENTER);
		lblBUpperThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBUpperThreshold.setBackground(new Color(250, 250, 210));
		lblBUpperThreshold.setBounds(430, 502, 33, 29);
		contentPane.add(lblBUpperThreshold);

		lblRange = new JLabel("~");
		lblRange.setOpaque(true);
		lblRange.setHorizontalAlignment(SwingConstants.CENTER);
		lblRange.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRange.setBackground(new Color(250, 250, 210));
		lblRange.setBounds(387, 502, 33, 29);
		contentPane.add(lblRange);

		lblUnitSymbol = new JLabel("Unit:");
		lblUnitSymbol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitSymbol.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUnitSymbol.setBounds(46, 502, 43, 33);
		contentPane.add(lblUnitSymbol);

		separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setForeground(Color.GREEN);
		separator_2.setBounds(new Rectangle(7, 7, 16, 16));
		separator_2.setBackground(new Color(75, 0, 130));
		separator_2.setBounds(29, 576, 626, 2);
		contentPane.add(separator_2);

//		Icon calculateIcon = new ImageIcon();
		btnCalculate = new JButton((Icon) null /* Calculate */);
		btnCalculate.setHorizontalAlignment(SwingConstants.CENTER);
		btnCalculate.setText("Calculate");
		btnCalculate.setToolTipText("Calculate");
		btnCalculate.setEnabled(false);
		btnCalculate.setForeground(new Color(0, 0, 0));
		btnCalculate.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnCalculate.setBackground(new Color(128, 255, 128));
		btnCalculate.setBounds(29, 603, 122, 30);
		contentPane.add(btnCalculate);

		btnRefresh = new JButton("Refresh"); //Button-Refresh-ICONIFIED 24x24.ong
		btnRefresh.setToolTipText("Refresh");
		btnRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		btnRefresh.setForeground(new Color(0, 0, 0));
		btnRefresh.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnRefresh.setBackground(new Color(128, 255, 128));
		btnRefresh.setBounds(523, 603, 146, 30);
		contentPane.add(btnRefresh);

//		Icon outputAllIcon = new ImageIcon();
		btnOutputAll = new JButton((Icon) null /* Output to TextArea */);
		btnOutputAll.setToolTipText("COutput to Text Area");
		btnOutputAll.setText("Output Results");
		btnOutputAll.setHorizontalAlignment(SwingConstants.CENTER);
		btnOutputAll.setEnabled(false);
		btnOutputAll.setForeground(new Color(0, 0, 0));
		btnOutputAll.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnOutputAll.setBackground(new Color(128, 255, 128));
		btnOutputAll.setBounds(161, 603, 184, 30);
		contentPane.add(btnOutputAll);

//		Icon openIcon = new ImageIcon();
		btnOpenFile = new JButton((Icon) null /* Open File */);
		btnOpenFile.setText("Open File");
		btnOpenFile.setToolTipText("Open File");
		btnOpenFile.setHorizontalAlignment(SwingConstants.CENTER);
		btnOpenFile.setForeground(new Color(0, 0, 0));
		btnOpenFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnOpenFile.setBackground(new Color(128, 255, 128));
		btnOpenFile.setBounds(29, 657, 122, 30);
		contentPane.add(btnOpenFile);

//		Icon writeIcon = new ImageIcon();
		btnWriteFile = new JButton((Icon) null /* Write File */);
		btnWriteFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWriteFile.setText("Write File");
		btnWriteFile.setHorizontalAlignment(SwingConstants.CENTER);
		btnWriteFile.setToolTipText("Write File");
//		btnWriteFile.setIcon(new ImageIcon(EmployeeBaseJFrame_V4.class.getResource("")));
		btnWriteFile.setForeground(new Color(0, 0, 0));
		btnWriteFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnWriteFile.setBackground(new Color(128, 255, 128));
		btnWriteFile.setBounds(161, 657, 125, 30);
		contentPane.add(btnWriteFile);

		btnReadFile = new JButton("Read File");
		btnReadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReadFile.setHorizontalAlignment(SwingConstants.CENTER);
		btnReadFile.setToolTipText("Read File");
		btnReadFile.setForeground(new Color(0, 0, 0));
		btnReadFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnReadFile.setBackground(new Color(128, 255, 128));
		btnReadFile.setBounds(433, 657, 124, 30);
		contentPane.add(btnReadFile);

//		Icon closeIcon = new ImageIcon();
		btnCloseFile = new JButton((Icon) null /* Close File */);
		btnCloseFile.setText("Close File");
		btnCloseFile.setHorizontalAlignment(SwingConstants.CENTER);
		btnCloseFile.setToolTipText("Close File");
		btnCloseFile.setForeground(new Color(0, 0, 0));
		btnCloseFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnCloseFile.setBackground(new Color(128, 255, 128));
		btnCloseFile.setBounds(296, 657, 129, 30);
		contentPane.add(btnCloseFile);

		btnPieChartDemo = new JButton("Pie-Chart Demo");
		btnPieChartDemo.setHorizontalAlignment(SwingConstants.CENTER);
		btnPieChartDemo.setToolTipText("Pie-Chart Demo");
		btnPieChartDemo.setForeground(new Color(0, 0, 0));
		btnPieChartDemo.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnPieChartDemo.setBackground(new Color(128, 255, 128));
		btnPieChartDemo.setBounds(355, 603, 158, 30);
		contentPane.add(btnPieChartDemo);

//		Icon exitIcon = new ImageIcon();
		btnExit = new JButton((Icon) null /* "Exit" */);
		btnExit.setToolTipText("Exit");
		btnExit.setText("Exit");
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnExit.setBackground(new Color(128, 255, 128));
		btnExit.setBounds(567, 657, 102, 30);
		contentPane.add(btnExit);

		btnClearRecord = new JButton("Clear Record");
		btnClearRecord.setHorizontalAlignment(SwingConstants.CENTER);
		btnClearRecord.setToolTipText("Clear Record");
//		btnClearRecord.setIcon(new ImageIcon(""));
		btnClearRecord.setForeground(new Color(0, 0, 0));
		btnClearRecord.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnClearRecord.setBackground(new Color(211, 211, 211));
		btnClearRecord.setBounds(214, 170, 147, 30);
		contentPane.add(btnClearRecord);

		lblResultArea = new JLabel("Results Area");
		lblResultArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblResultArea.setBounds(445, 169, 210, 29);
		contentPane.add(lblResultArea);

		separatorResultTop = new JSeparator();
		separatorResultTop.setOrientation(SwingConstants.VERTICAL);
		separatorResultTop.setOpaque(true);
		separatorResultTop.setForeground(Color.GREEN);
		separatorResultTop.setBounds(new Rectangle(7, 7, 16, 16));
		separatorResultTop.setBackground(new Color(75, 0, 130));
		separatorResultTop.setBounds(445, 166, 210, 3);
		contentPane.add(separatorResultTop);

		separatorResultBottom = new JSeparator();
		separatorResultBottom.setOrientation(SwingConstants.VERTICAL);
		separatorResultBottom.setOpaque(true);
		separatorResultBottom.setForeground(Color.GREEN);
		separatorResultBottom.setBounds(new Rectangle(7, 7, 16, 16));
		separatorResultBottom.setBackground(new Color(75, 0, 130));
		separatorResultBottom.setBounds(445, 203, 210, 3);
		contentPane.add(separatorResultBottom);

//		Icon setProfileIcon = new ImageIcon();
		btnSetProfile = new JButton("Set Profile");
		btnSetProfile.setHorizontalAlignment(SwingConstants.CENTER);
		btnSetProfile.setText("Set Profile");
		btnSetProfile.setToolTipText("Set Profile");
		btnSetProfile.setForeground(new Color(0, 0, 0));
		btnSetProfile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnSetProfile.setBackground(new Color(255, 192, 203));
		btnSetProfile.setBounds(29, 23, 210, 30);
		contentPane.add(btnSetProfile);

		btnClearProfile = new JButton("Clear Profile/Results");
		btnClearProfile.setToolTipText("Clear Profile/Results");
		btnClearProfile.setForeground(new Color(0, 0, 0));
		btnClearProfile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnClearProfile.setBackground(new Color(255, 192, 203));
		btnClearProfile.setBounds(445, 23, 210, 30);
		contentPane.add(btnClearProfile);

		lblUnit = new JLabel("Thousand");
		lblUnit.setOpaque(true);
		lblUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnit.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblUnit.setBackground(Color.YELLOW);
		lblUnit.setBounds(96, 504, 96, 29);
		contentPane.add(lblUnit);
	}
	protected void initializeButtonArray() {
		JButton[] buttonsInitialized = { btnCalculate, btnRefresh, btnClearRecord, btnSetProfile, btnClearProfile,
				btnOutputAll, btnExit, btnOpenFile, btnReadFile, btnWriteFile, btnCloseFile, btnPieChartDemo };
	    optionButtons = buttonsInitialized;
	    for (int i = 0; i < basicChoices.length; i++) {
	        //optionButtons[i].setIcon(new ImageIcon(EmployeeBaseJFrame_V0.class.getResource(basicChoices[i].getImageIcon())));
			optionButtons[i].setIcon(new ImageIcon((basicChoices[i].getImageIcon())));
			optionButtons[i].setText(basicChoices[i].getButtonType());
			System.out.println("i=" + basicChoices[i].getImageIcon());

	        contentPane.add(optionButtons[i]); //I believe this line is no need. Confirm later
	    }
	} // end initializeButtonArray()

	protected void initializeTextFieldArrayList() {
		JTextField[] txtFieldsProfile = { txtFieldCN, txtFieldEN };
		JTextField[] txtFieldsEmployee = { txtFieldSSN, txtFieldFN, txtFieldLN, txtFieldEarnings };
		JTextField[] txtFieldsOutpu = { txtFieldEmpCounter, txtFieldLowestE, txtFieldHighestE, txtFieldAverageE,
				txtFieldLA, txtFieldLB, txtFieldLC };
	    
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

	    for (JTextField txtField : txtFieldsOutpu) {
	        listTxtFieldsResultsG.add(txtField);
	        //contentPane.add(txtField);
	    }

	}

	
	
//	protected void pluginVerifier4TextFieldArrayList() {
//	    for (JTextField txtField : listTxtFieldsEmployeeG) {
//	        txtField.setInputVerifier(verifier4Employee); // for verification
//	    }
//	    // listTxtFieldsEmployeeG
//
//	    for (JTextField txtField : listTxtFieldsProfileG) {
//	        txtField.setInputVerifier(verifier4Employee); // for verification
//	    }
//	    // listTxtFieldsProfileG
//	}

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
//			static Void initLookAndFeel(EmployeeBaseJFrame_V4 resourceBase) {
			SynthLookAndFeel lookAndFeel = new SynthLookAndFeel();

			try {
//				lookAndFeel.load(EmployeeBaseJFrame_V4.class.getResourceAsStream("synthDemo.xml"), EmployeeBaseJFrame_V4.class);
				lookAndFeel.load(resourceBase.getResourceAsStream("synthDemo.xml"), resourceBase);

//				lookAndFeel.load(EmployeeBaseJFrame_V4.class.getResourceAsStream("synthDemo.xml"),resourceBase);

				UIManager.setLookAndFeel(lookAndFeel);
			} catch (Exception e) {
				System.err.println("Couldn't get specified look and feel (" + lookAndFeel + "), for some reason.");
				System.err.println("Using the default look and feel.");
				e.printStackTrace();
			}
		}

	    
		protected void setupMenubarWithLookAndFeel(int _x, int _y, int _width, int _height, Class<?> resourceBase,Component component) {
//		    protected void setupMenubarWithLookAndFeel(int _x, int _y, int _width, int _height, EmployeeBaseJFrame resourceBase,
//		    		Component component) {
				menuBar = new JMenuBar();
				menuBar.setMargin(new Insets(4, 4, 4, 4));
				menuBar.setBackground(Color.CYAN);
				menuBar.setBounds(_x, _y, _width, _height); //e.g. menuBar.setBounds(300, 0, 115, 35);
				contentPane.add(menuBar);

				mnLookFeel = new JMenu("  Look&Feel");
				mnLookFeel.setHorizontalAlignment(SwingConstants.CENTER);
				mnLookFeel.setPreferredSize(new Dimension(115, 22));
				mnLookFeel.setToolTipText("Chanfe LOOK & FEEL");
				mnLookFeel.setBounds(new Rectangle(3, 3, 3, 3));
				mnLookFeel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 12));
				mnLookFeel.setBorderPainted(true);
				mnLookFeel.setBackground(new Color(255, 182, 193));
				mnLookFeel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.BLUE, new Color(255, 250, 205),
						new Color(135, 206, 235)));

				buttonGroup = new ButtonGroup();
				final UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
				for (int i = 0; i < info.length; i++) {
					JRadioButtonMenuItem item = new JRadioButtonMenuItem(info[i].getName(), i == 4);// i == 0    original
					item.setForeground(new Color(200, 0, 200)); //added by Wu
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
							SwingUtilities.updateComponentTreeUI(component);
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
