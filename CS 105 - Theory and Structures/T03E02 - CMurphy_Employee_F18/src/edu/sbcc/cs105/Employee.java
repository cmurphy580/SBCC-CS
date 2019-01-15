/**
 * CS 105 Theory and Practice I
 * CRN: [39626]
 * Assignment: Employee
 *
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 *
 * @author [Conor Murphy]
 */
package edu.sbcc.cs105;
 
/**
 * This class implements an employee which is a person with a name and a salary.
 *
 */
public class Employee {
	private String name;
	private double salary; 
    /**
     * Constructor that creates a new Employee with an initial name and salary.
     *
     */
    public Employee(String employeeName, double currentSalary) {
    	name = employeeName;
    	salary = currentSalary; 
    }
    // Accessors that are obvious and have no side effects don't have to have 
    // any documentation unless you are creating a library to be used by other 
    // people. 
    public String getName() {
    	return name;
    }
 
    public double getSalary() {
    	return salary; 
    }
    
    public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
     * Raise the salary by the amount specified by the explicit argument.
     *
     */
    public void raiseSalary(double byPercent) {
    	 setSalary(salary + (salary * (byPercent/100.00)));
    }
}