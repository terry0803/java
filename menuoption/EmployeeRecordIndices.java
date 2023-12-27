package Lin.polymorphism.employee.menuoption;

public enum EmployeeRecordIndices {
    // declare contents of enum type
    COMPANY_NAME (0, "Company Name"),
    EMPLOYEE_NO (1, "No of Employees"),
    SSN (2, "SSN"),
    FIRST_NAME (3, "First Name"),
    LAST_NAME (4, "Last Name"),
    WEEKLY_SALARY (5, "Weekly S."),
    HOURLY_WAGE (6, "Hourly W."),
    HOURS_WORKED (7, "Work Hours"),
    GROSS_SALES (8, "Gross Sales"),
    COMMISSION_RATE (9, "C. Rate"),
    BASE_SALARY (10, "Base Salary"),
    EARNINGS (11, "Earnings"),
    EMPLOYEE_COUNTER (12, "Employee Counter"),
    LOWEST_EARNINGS (13, "Lowest E."),
    HIGHEST_EARNINGS (14, "Highest E."),
    AVERAGE_EARNINGS (15, "Average E."),
    WAGE_LEVEL (16, "Wage Level"),
    INDEX_COLOR (17, "Index Color"),
    EXTRA_HOURS_RATE (18, "Rate4ExtraHours"),
    MAX_WORKED_HOURS (168, "Max Worked-Hours"); //168=24*7(total hours in one week)

    private final int value; // current menu option
    private final String recordIndexType; // current menu option

    EmployeeRecordIndices(int valueOption, String optionT) {
        value = valueOption;
        recordIndexType = optionT;
    } // end EmployeeRecordIndices enum constructor

    public int getValue() {
        return value;
    } // end method getValue

    public String getRecordIndexType() {
        return recordIndexType;
    } // end method getRecordIndexType
} // end enum EmployeeRecordIndices