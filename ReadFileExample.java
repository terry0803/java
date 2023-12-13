package Lin.library.filestream;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ReadFileExample {	
	public String stringContent = "";	
	public boolean useJPane = true;
	public boolean useSimpleOne = false;
	public String filePath = "./filePath";

	public static void main(String[] args) {
		File file = new File("./testData/test1.txt");//or ".\\testData\\test1.txt"

		ReadFileExample readfile = new ReadFileExample(file);
	}
	
	public ReadFileExample(File file) 
	{
		FileInputStream fis = null;
		 

		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size to read (in bytes) : "
					+ fis.available());

			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
				
				stringContent += (char) content;
			}

		} catch (IOException e) {
//			e.printStackTrace();
		 
			JOptionPane.showMessageDialog(null, e.getMessage(), "Re-choose file.",
				JOptionPane.INFORMATION_MESSAGE);
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
//				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Re-choose file.",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}//End ReadFileExample
	
}