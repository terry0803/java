package Lin.polymorphism.employee.menuoption;

public enum EmployeeType_Menu2 {    
	// declare contents of enum type
    BaseEmployee (0, "Base-Employee"),
    SalariedEmployee (1, "Salaried-Employee"),
    HourlyEmployee (2, "Hourly-Employee"),
    CommissionEmployee (3, "Commission-Employee"),
    BasePlusCommissionEmployee (4, "BasePlusCommission-Employee"),
    Quit (5, "Quit");

    private final int valueOption; // current menu option
    private final String employeeType; // current menu option

    EmployeeType_Menu2(int _valueOption, String optionType) {
        valueOption = _valueOption;
        employeeType = optionType;
    } // end MenuOptions enum constructor

    public int getValueOption() {
        return valueOption;
    } // end method getValue

    public String getEmployeeType() {
        return employeeType;
    } // end method getEmployeeType
} // end enum EmployeeType_MenuOption

