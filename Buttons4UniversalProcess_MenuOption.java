package Lin.library.enummenu;

public enum Buttons4UniversalProcess_MenuOption {
	// declare contents of enum type
	Process_Data 			 	(1, "Calculate", "./resources/images/calculator_24x24.png" ),
	Refresh       			 	(2, "Refresh", "./resources/images/Button-Refresh-icon 24x24.png" ),
	Output_Results		 	 	(3, "Output Results", "./resources/images/Programming-Open-In-Browser-icon_24x24.png"),
	Clear_Record 			 	(4, "Clear Record", "./resources/images/edit_clear_24x24.png"), 
	Set_Profile              	(5, "Set Profile", "./resources/images/user_profile_edit_25x25.png"),
	Clear_Profile_and_Results	(6, "Clear Profile/Results", "./resources/images/edit_clear_24x24.png"),
	Exit        			 	(7, "Exit" , "./resources/images/exit_34x24.png"),
	OpenFile                 	(8, "Open File", "./resources/images/Open-icon_24x24.png"),
	ReadFile                 	(9, "Read File", "./resources/images/ReadFile_24x24.png"),
	WriteFile                	(10, "Write File","./resources/images/Write_File_25x25.png"),
	CloseFile                	(11, "Close File", "./resources/images/fileclose_24x24.png"),
	PieChartDemo             	(12, "Pie-Chart", "./resources/images/PieChartt_3_26x25.png");/*pie-chart.gif, PieChart_30x25.png, PieChartt_2_27x27.png*/
	
	private final int value; // current menu option
	private final String  buttonType; // current menu option
	private final String  imageIconString; // current menu option

	Buttons4UniversalProcess_MenuOption( int valueOption, String optionType, String _imageIconString )	
	{
		value = valueOption;
	    buttonType=optionType;
	    imageIconString=_imageIconString;
	} // end Button_MenuOption enum constructor

	public int getValue()
	{
		return value;
	} // end method getValue
	   
	public String getButtonType()
	{
		return buttonType;
	} // end method getButtonType()
	
	public String getImageIcon()
	{
		return imageIconString;
	} // end method getButtonType()
}//end enum Button_MenuOption
