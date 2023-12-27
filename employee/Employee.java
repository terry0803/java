// Fig. 10.4: Employee.java
// Employee abstract superclass.
package Lin.polymorphism.employee;

import java.io.Serializable;
import java.awt.Color;

public abstract class Employee implements Serializable {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	private String levelLetter;
	private Color indexColor;
	public boolean isSimpleFormat = true;

	// constructor
	public Employee(String _firstName, String _lastName, String _socialSecurityNumber, boolean _isSimpleFormat) {
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.socialSecurityNumber = _socialSecurityNumber;
		isSimpleFormat = _isSimpleFormat;
	}

	// return first name
	public String getFirstName() {
		return firstName;
	}

	// return last name
	public String getLastName() {
		return lastName;
	}

	// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setLevel(String _levelLetter) {
		levelLetter = _levelLetter;
	}

	public String getLevel() {
		return levelLetter;
	}

	// return String representation of Employee object
	@Override
	public String toString() {
		return String.format("%15s\t%15s\t%15s", getFirstName(), getLastName(), getSocialSecurityNumber());
	}

	public String toString2() {
		return String.format("\r%15s %15s%nsocial security number: %s", getFirstName(), getLastName(),
				getSocialSecurityNumber());
	}

	public String toString3() {
		return String.format("%15s, %15s, %15s", getFirstName(), getLastName(), getSocialSecurityNumber());
	}

	// abstract method must be overridden by concrete subclasses
	public abstract double earnings(); // no implementation here

	public void setColor(Color indexColor2) {
		// TODO Auto-generated method stub
		
	}
}