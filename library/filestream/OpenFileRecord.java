package Lin.library.filestream;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
//import javax.net.ssl.ExtendedSSLSession;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@SuppressWarnings({ "unused", "serial" })
public class OpenFileRecord /* extends JFrame */ {
	public static File FileName;
	public static Formatter output;
	private final int Text_BASED = 1, BYE_EASED = 2;
	private int stream_Based = Text_BASED;	
	public static final int CONSOLE_MODE = 1, GUI_MODE = 2;
	private int Console_or_GUI_Mode = GUI_MODE;

	public static boolean useSimpleOne = false;// useJPane
	public static boolean useJPane = true;// useJPane
	public String filePath = "./filePath";

	public OpenFileRecord(int _Stream_Based, int _Console_or_GUI_Mode, boolean _useJPane) {
		stream_Based = _Stream_Based;
		Console_or_GUI_Mode = _Console_or_GUI_Mode;
		useJPane = _useJPane;
	}

	public static File getfile(String _filePath, boolean _useJPane) throws FileNotFoundException, NullPointerException {
//		isOPEN_FILE_OK=false;
		useJPane = _useJPane;
		JFileChooser fileChooser = new JFileChooser(_filePath);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			FileName = fileChooser.getSelectedFile().getAbsoluteFile();
		} else {// if user clicked Cancel button on dialog, return

			JOptionPane.showMessageDialog(null,
					"You just made:\r\n         'CANCEL_  or  ERROR_ OPTION'!",
					"No file Chosen. Are you sure?", JOptionPane.INFORMATION_MESSAGE);
//         	System.exit(1);
			return null;
		}

		return FileName;
	}// End getfile

	public static void openFile(File _Filename) {
		try {
			output = new Formatter(FileName.getAbsoluteFile()); // open the file
			JOptionPane.showMessageDialog(null, FileName.getName());
		} catch (SecurityException securityException) {
			JOptionPane.showMessageDialog(null, "Write permission denied. Terminating.");
			// System.err.println("Write permission denied. Terminating.");
			System.exit(1); // terminate the program
		} catch (FileNotFoundException fileNotFoundException) {
			JOptionPane.showMessageDialog(null, "Error opening file--> FileNotFoundException.");
			// System.err.println("Error opening file. Terminating.");
//			System.exit(1); // terminate the program
		}
	}// End openFil

	public static void closeFile() {
		if (output != null)
			output.close();
		JOptionPane.showMessageDialog(null, "Close File");
	}// End closeFile

	/**
	 * 1) Choose File and display read content into a JTextArea considered; 2) After
	 * seeing content from chosen file, then decide if it is needed to continue
	 * choosing a file for further process
	 * 
	 * @param txtArea
	 * @return
	 * @throws FileNotFoundException
	 */
	public static boolean readFile2PreviewContent4ContinueOrNot(JTextArea txtArea, String filePath,
			boolean _useSimpleOne) throws FileNotFoundException {
		boolean isFileNeeded = false;
		String[] YorN = { "YES", "NO" };
		JPanel panel = null;

		File fileRead = OpenFileRecord.getfile(filePath, _useSimpleOne);
		if (fileRead != null) {
			ReadFileExample readFile = new ReadFileExample(fileRead);
			JOptionPane.showMessageDialog(null, readFile.stringContent, "Preview Content in File",
					JOptionPane.INFORMATION_MESSAGE);

			txtArea.setText(readFile.stringContent);//think-->frameEmployee.txtArea4RecordTextArea.setText(readFile.stringContent);

			/**
			 * google "JOptionPane.showInputDialog java color" Below Used for better
			 * appearance shown on JoptionPane (this line/function is optional)
			 * https://www.mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
			 * https://stackoverflow.com/questions/9064943/how-to-change-background-color-of-joptionpane/9064970
			 */
			if (useJPane)
				panel = getUImanager4JOptionPane(_useSimpleOne);

			ImageIcon icon = new ImageIcon("./resources/images/qustion_message_40x40.png");
			String choice = (String) JOptionPane.showInputDialog(null, (panel == null ? "Your choice" : panel),
					"CONTINE? (YES/NO)", JOptionPane.QUESTION_MESSAGE, icon/* null */, YorN, YorN[0]);

			if (choice == "YES") {
				isFileNeeded = true;
			} else if (choice == "NO") {
				JOptionPane.showMessageDialog(null, "You need to re-choose file!");
			} else {
				JOptionPane.showMessageDialog(null, "you just cancel the action!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No file choosen");
		}

		return isFileNeeded;
	}//end readFile2PreviewContent4ContinueOrNot

	/**
	 * google "JOptionPane.showInputDialog java color" see
	 * https://stackoverflow.com/questions/9064943/how-to-change-background-color-of-joptionpane/9064970
	 * https://www.mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/     (GOOD)
	 * 2 articles has also been saved into doc folder under project considered.
	 */
	public static JPanel getUImanager4JOptionPane(boolean _useSimpleOne) {
		JPanel panel = null;
		useSimpleOne = _useSimpleOne;
		if (useSimpleOne) {
//		UIManager um = new UIManager();
			UIManager.put("OptionPane.messageForeground", Color.red);
			UIManager.put("Panel.background", new Color(128, 255, 255));
		} else {
			panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0));
			panel.setSize(new Dimension(250, 240));// (250, 32)
			panel.setLayout(null);

			JLabel label = new JLabel("what is you choice:)");
			label.setForeground(new Color(255, 0, 255));
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setFont(new Font("Arial", Font.BOLD, 14));// 11
			label.setBounds(0, 0, 250, 62);// (0, 0, 250, 32)
			panel.add(label);

			UIManager.put("OptionPane.minimumSize", new Dimension(270, 240));// 270, 120

			/**
			 * below 2 lines are optional choice. And colors can changed by preference...
			 */
			UIManager.put("OptionPane.background", Color.red);
			UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(225, 255, 225));
		}

		return panel;

	}//end JPanel getUImanager4JOptionPane
}//end class  OpenFileRecord
