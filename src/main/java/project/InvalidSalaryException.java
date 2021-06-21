package project;

public class InvalidSalaryException extends Exception{
	
	public InvalidSalaryException(String message) {
		super(message);
	}
	
	public static void validate(double newSalary) throws InvalidSalaryException {
		if (newSalary < 2500)  {
			throw new InvalidSalaryException("Not valid Salary, Please enter valid salary");
//			newSalary = salary;
		}
			else 
				System.out.println("valid salary");
	}
}
