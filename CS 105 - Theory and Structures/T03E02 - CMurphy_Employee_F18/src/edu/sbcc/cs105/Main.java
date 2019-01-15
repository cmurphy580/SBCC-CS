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
 * This class tests the Employee object.
 *
 */
public class Main {
 
    /**
     * Create an employee and test that the proper name has been created. Test
     * the initial salary amount and then give the employee a raise. Then check
     * to make sure the salary matches the raised salary.
     *
     *
     * @param args
     *            command line values. Not used in this example.
     */
    public static void main(String[] args) {
    	Employee e = new Employee("Charles Xavier", 100000.00);
    	System.out.println(e.getName());
    	System.out.println("$" + String.format("%1$,.2f", e.getSalary()));
    	e.raiseSalary(30);
    	System.out.println("$" + String.format("%1$,.2f", e.getSalary()));
    }
}