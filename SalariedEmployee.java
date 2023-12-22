package Lin.polymorphism.employee;

// Fig. 10.5: SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee.

public class SalariedEmployee extends Employee {
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String firstName, String lastName, 
      String socialSecurityNumber, boolean _isSimpleFormat, double weeklySalary) {
      super(firstName, lastName, socialSecurityNumber, _isSimpleFormat); 

      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // set salary
   public void setWeeklySalary(double weeklySalary) {
      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // return salary
   public double getWeeklySalary() {return weeklySalary;}

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {return getWeeklySalary();}                

   // return String representation of SalariedEmployee object  
   @Override                                                   
   public String toString() {                                  
      return String.format(
    		  isSimpleFormat?("\r\n%10s\t%50s\t%15.2f\t%,15.2f")
    				        :("\r\n%10s\t%50s\t%15.2f\t%,15.2f"),
         "S-Employee",super.toString(), getWeeklySalary(),earnings());
   }    
   
   @Override 
   public String toString2() {   
	   return String.format("salaried employee: %s%n%s: $%,.2f",super.toString(), "weekly salary", getWeeklySalary());
   }
   
   @Override 
   public String toString3() {   
	   return String.format("\r\n%12s,%s,%-15.2f,%-15.2f","S-Employee",super.toString3(), getWeeklySalary(),earnings());
   }
} 