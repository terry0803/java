package Lin.library.filestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileChoosing4WriteOrRead_27Oct20 extends JFrame {
	/*
	 * Binary-Based File using object
	 */
	public ObjectOutputStream outputO;
	public ObjectInputStream inputO;
	
	public String filePath = "./filePath";
	public boolean isOPEN_FILE_OK = false;
	public boolean isCANCEL_OPTION = false;
	public boolean isDirectory = false;
	public File fileName = null;
	public boolean writeOn = false, readOn = false;
	public int result = JFileChooser.APPROVE_OPTION;// i.e. 0

	public FileChoosing4WriteOrRead_27Oct20(boolean _writeOn, boolean _readOn) {
		writeOn = _writeOn;
		readOn = _readOn;

	}// allow user to specify file name

	public FileChoosing4WriteOrRead_27Oct20(boolean _isDirectory) {
		isDirectory = _isDirectory;
	}// allow user to specify file name

	/**
	 * Choose file
	 * @param _filePath
	 * @param titleOnDialogBox
	 * @return
	 */
	public File chooseFile(String _filePath, String titleOnDialogBox) {
		isOPEN_FILE_OK = false;

		// display file dialog, so user can choose file to open
		JFileChooser fileChooser = new JFileChooser(_filePath);// modified by MCLO
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setDialogTitle(titleOnDialogBox);// added by MCLo		
		result = fileChooser.showSaveDialog(this);

		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(this, "You just clicked on CANCEL_OPTION", "CANCEL_OPTION",
					JOptionPane.INFORMATION_MESSAGE);
			isCANCEL_OPTION = true;
			fileName = null;
			return null;
		}

		if (isDirectory)
			fileName = fileChooser.getCurrentDirectory();// get all files in the selected directory
		else
			fileName = fileChooser.getSelectedFile().getAbsoluteFile(); // get a selected file
		JOptionPane.showMessageDialog(this, "File Name:" + fileName.getName());
		isOPEN_FILE_OK = true;

		return fileName;
	} // end method chooseFile

	/**
	 * enable user to select file to open for reading or writing
	 * @param _filePath
	 * @param titleOnDialogBox
	 */
	public void chooseOpenFile2ReadOrWrite(String _filePath, String titleOnDialogBox) {
		isOPEN_FILE_OK = false;

		// Create directory now to make sure it will be created if not existed.
		File d = new File(_filePath);
		d.mkdirs();

		// display file dialog so user can select file to open
		JFileChooser fileChooser = new JFileChooser(_filePath);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle(titleOnDialogBox);// added by MCLo		
		result = fileChooser.showOpenDialog(this);

		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(this, "You just clicked on CANCEL_OPTION", "CANCEL_OPTION",
					JOptionPane.INFORMATION_MESSAGE);
			isCANCEL_OPTION = true;
			fileName = null;
			return;
		}

		// obtain selected file
		fileName = fileChooser.getSelectedFile();

		// display error if file name invalid
		if (fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(this, "Invalid File Name", "Invalid File Name", JOptionPane.ERROR_MESSAGE);
		else {
			// open file
			try {
				if (writeOn)
					outputO = new ObjectOutputStream(new FileOutputStream(fileName));
				if (readOn)
					inputO = new ObjectInputStream(new FileInputStream(fileName));

				isOPEN_FILE_OK = true;
			}
			// process exceptions opening file
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "Error Opening File", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} // end else

	} // end method chooseOpenFile2ReadOrWrite

	/**
	 *  close file and terminate application
	 */
	public void closeFile() {
		/**
		 * To solve out "NullPointerException" for processWindowEvent when clicking on
		 * canceling btn (no file opened)
		 */
		if (outputO != null || inputO != null) {
			// close file
			try {
				if (writeOn)
					outputO.close();
				if (readOn)
					inputO.close();

//					System.exit(0);//if having exit btn, then no need for this
			}

			// process exceptions from closing file
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "Error closing file", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No file open", "Window Close", JOptionPane.INFORMATION_MESSAGE);
		}
	} // end method closeFile
}// end class FileChoosing4WriteOrRead_27Oct20_lo0116
