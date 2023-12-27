package Lin.library.filestream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Lin.library.enummenu.FileStreamType_MenuOption;

public class FileChoosing4WriteOrRead_20Dec23_extends extends FileChoosing4WriteOrRead_27Oct20 {
	boolean isDEBUG_ON = false;
	/*
	 * Binary-Based File using object
	 */
//	public ObjectOutputStream outputO;// output object to a file
//	public ObjectInputStream inputO;// input object from a file

	/*
	 * File using text base
	 */
	public Scanner inputT = null;// input text from a file
	public Formatter outputT = null;// output text to a file

	/*
	 * Character-Based File
	 */
	public BufferedReader br_Reader = null;
	public BufferedWriter br_Writer = null;

//	public String filePath = "./filePath";
//	public boolean isOPEN_FILE_OK = false;
//	public boolean isCANCEL_OPTION = false;
//	public boolean isDirectory = false;
//	public File fileName = null;
//	public boolean writeOn = false, readOn = false;
//	public int result = JFileChooser.APPROVE_OPTION;// i.e. 0

	private int Stream_Based = FileStreamType_MenuOption.BYTE_BASED.getValue();

	public FileChoosing4WriteOrRead_20Dec23_extends(boolean _writeOn, boolean _readOn, int _streamBased) {
		super(_writeOn, _readOn);
		Stream_Based = _streamBased;
	}

	public FileChoosing4WriteOrRead_20Dec23_extends(boolean _writeOn, boolean _readOn, int _streamBased,
			String _filePath) {
		super(_writeOn, _readOn);
		Stream_Based = _streamBased;
		
		filePath = _filePath;
		File d = new File(filePath);

		// Create directory now.
		d.mkdirs();
	}// allow user to specify file name

//	public File chooseFile(String _filePath, String titleOnDialogBox) {
//		isOPEN_FILE_OK=false;
//		
//		// display file dialog, so user can choose file to open
//		JFileChooser fileChooser = new JFileChooser(_filePath);// modified by MCLO
//		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//
//		fileChooser.setDialogTitle(titleOnDialogBox);
//
//		result = fileChooser.showSaveDialog(this);
//
//		// if user clicked Cancel button on dialog, return
//		if (result == JFileChooser.CANCEL_OPTION) {
//			JOptionPane.showMessageDialog(this, "You just clicked on CANCEL_OPTION", "CANCEL_OPTION",
//					JOptionPane.INFORMATION_MESSAGE);
//			isCANCEL_OPTION = true;
//			fileName = null;
//			return null;
//		}
//
//		if (isDirectory)
//			fileName = fileChooser.getCurrentDirectory();// get all files in the selected directory
//		else
//			fileName = fileChooser.getSelectedFile().getAbsoluteFile(); // get a selected file
//
//		JOptionPane.showMessageDialog(this, "File Name:" + fileName.getName());
//		isOPEN_FILE_OK = true;
//
//		return fileName;
//	} // end method openFile

	/**
	 *  enable user to select file to open for reading or writing
	 * @param _filePath
	 * @param titleOnDialogBox
	 * @param reminder
	 */
	public void chooseOpenFile2ReadOrWrite(String _filePath, String titleOnDialogBox, String reminder) {
		isOPEN_FILE_OK=false;
	       
	    // Create directory now to make sure it will be created if not existed.
		File d = new File( _filePath);	
	    d.mkdirs();
		
		// display file dialog so user can select file to open
		JFileChooser fileChooser = new JFileChooser(_filePath);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle(titleOnDialogBox);		 
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
					if (Stream_Based == FileStreamType_MenuOption.BYTE_BASED.getValue())
						outputO = new ObjectOutputStream(new FileOutputStream(fileName));
					else if (Stream_Based == FileStreamType_MenuOption.STANDARD_BASED.getValue())
						outputT = new Formatter(fileName.getAbsoluteFile()); // open the file
					else {//Character-Based File
						// this can be substituted by either one of below 2 alternative approaches
						br_Writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
				}
				if (readOn)
					if (Stream_Based == FileStreamType_MenuOption.BYTE_BASED.getValue())
						inputO = new ObjectInputStream(new FileInputStream(fileName));
					else if (Stream_Based == FileStreamType_MenuOption.STANDARD_BASED.getValue())
						inputT = new Scanner(fileName.getAbsoluteFile());
					else
						br_Reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

				if (isDEBUG_ON)
					JOptionPane.showMessageDialog(this, "Open File: " + fileName, reminder,
							JOptionPane.INFORMATION_MESSAGE);

				isOPEN_FILE_OK = true;
			}
			// process exceptions opening file
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "Error Opening File", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} // end else
	} // end method chooseOpenFile2ReadOrWrite

	public void openFile2Write(String reminder/* , File _fileName */) {
		isOPEN_FILE_OK = false;
		
		// display error if file name invalid
		if (fileName == null || fileName.getName().equals(""))// OK
//		if (fileName.getName().isEmpty())// OK???
		{
			JOptionPane.showMessageDialog(this, "Invalid or Empty File Name", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			// open file
			try {
				if (Stream_Based == FileStreamType_MenuOption.BYTE_BASED.getValue())
					outputO = new ObjectOutputStream(new FileOutputStream(fileName));
				else if (Stream_Based == FileStreamType_MenuOption.STANDARD_BASED.getValue())
					outputT = new Formatter(fileName.getAbsoluteFile()); // open the file
				else {//Character-Based File
					// this can be substituted by either one of below 2 alternative approaches
					br_Writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
				}
				/**
				 * Alternative 1: Path file =Paths.get(fileName.getAbsolutePath()); OutputStream
				 * output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
				 * br_Writer = new BufferedWriter(new OutputStreamWriter(output));
				 * 
				 * Alternative 2: OutputStream output = new
				 * BufferedOutputStream(Files.newOutputStream(fileName.toPath(), CREATE));
				 * br_Writer = new BufferedWriter(new OutputStreamWriter(output));
				 */

				if (isDEBUG_ON)
					JOptionPane.showMessageDialog(this, "Open File: " + fileName, reminder,
							JOptionPane.INFORMATION_MESSAGE);

				isOPEN_FILE_OK = true;
			}
			// process exceptions opening file
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "Error Opening File", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} // end else
	}// end openFile2Write

	public void openFile2Read(String reminder/* , File _fileName */) {
		isOPEN_FILE_OK = false;
		
		// display error if file name invalid
		if (fileName == null || fileName.getName().equals("")) {
			JOptionPane.showMessageDialog(this, "Invalid File Name", "Invalid File Name", JOptionPane.ERROR_MESSAGE);
		} else {
			// open file
			try {
				if (Stream_Based == FileStreamType_MenuOption.BYTE_BASED.getValue())
					inputO = new ObjectInputStream(new FileInputStream(fileName));
				else if (Stream_Based == FileStreamType_MenuOption.STANDARD_BASED.getValue())
					inputT = new Scanner(fileName.getAbsoluteFile());
				else
					br_Reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

				if (isDEBUG_ON)
					JOptionPane.showMessageDialog(this, "Open File: " + fileName, reminder,
							JOptionPane.INFORMATION_MESSAGE);
				isOPEN_FILE_OK = true;
			}
			// process exceptions opening file
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "Error Opening File", "Error", JOptionPane.ERROR_MESSAGE);

			}
		} // end else
	}// end openFile2Write

	// close file and terminate application
	@Override
	public void closeFile() {
		//close file
		if ((outputO != null || inputO != null) || outputT != null || inputT != null
				|| (br_Writer != null || br_Reader != null)) {
			try {
				if (writeOn) {
					if (Stream_Based == FileStreamType_MenuOption.BYTE_BASED.getValue())
						outputO.close();
					else if (Stream_Based == FileStreamType_MenuOption.CHARACTER_BASED.getValue())
						br_Writer.close();
					else
						outputT.close();
				}

				if (readOn) {
					if (Stream_Based == FileStreamType_MenuOption.BYTE_BASED.getValue())
						inputO.close();
					else if (Stream_Based == FileStreamType_MenuOption.CHARACTER_BASED.getValue())
						br_Reader.close();// IJ.showMessage("I am in CHARACTER_BASED="+CHARACTER_BASED);
					else
						inputT.close();// IJ.showMessage("I am in TEXT_BASED="+TEXT_BASED);
				}
			}

			// process exceptions from closing file
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "Error closing file", "Error", JOptionPane.ERROR_MESSAGE);
//					System.exit(1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No file open", "Window Close", JOptionPane.INFORMATION_MESSAGE);
		}
	} // end method closeFile
}//end class FileChoosing4WriteOrRead_25Dec20_lo116_V2
