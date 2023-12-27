package Lin.polymorphism.employee.menuoption;

public enum EmployeeType_MenuOption {
    // declare contents of enum type
    BaseEmployee (0, "Base-Employee"),
    SalariedEmployee (1, "Salaried-Employee"),
    HourlyEmployee (2, "Hourly-Employee"),
    CommissionEmployee (3, "Commission-Employee"),
    BasePlusCommissionEmployee (4, "BasePlusCommission-Employee"),
    Quit (5, "Quit");

    private final int value; // current menu option
    private final String employeeType; // current menu option

    EmployeeType_MenuOption(int valueOption, String optionType) {
        value = valueOption;
        employeeType = optionType;
    } // end MenuOptions enum constructor

    public int getValue() {
        return value;
    } // end method getValue

    public String getEmployeeType() {
        return employeeType;
    } // end method getEmployeeType

} // end enum EmployeeType_MenuOption