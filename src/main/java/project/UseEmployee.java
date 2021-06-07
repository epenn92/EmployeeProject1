package project;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseEmployee {
	
	
		private static final Logger LOGGER = Logger.getLogger(UseEmployee.class.getName());
	

	public static void main(String[] args) {
		
		LOGGER.info("Logger Name: " + LOGGER.getName());
		
		LOGGER.warning("Can cause IndexOutOfBoundException");
		
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("Choose option");
		int userInput = input.nextInt();
		int newNo = 0;
		String newName = null;
		int newSalary = 0;
		String newCityAddress = null;
		String newStateAddress = null;
		EmployeeServiceImpl ep = new EmployeeServiceImpl();
		
		switch(userInput) {
			case 1: 
				ep.displayAllEmployees();
				EmployeeServiceImpl.eList.stream().filter((s) -> s.empName.startsWith("J"))
				.forEach(System.out::println);
				break;
			case 2:
				System.out.println("Which employee salary?");
				userInput = input.nextInt();
				ep.calculateYearlySalary(EmployeeServiceImpl.eList.get(userInput));
//				System.out.println();
				break;
			case 3:
				System.out.println("Which employee by number?");
				userInput = input.nextInt();
				ep.findByEmployeeNo(userInput);
				break;
			case 4:
				System.out.println("Which employee to update?");
				userInput = input.nextInt();
//				ep.updateEmployee(EmployeeServiceImpl.eList.set(userInput, new Employee(1, "new", 1, new Address("test", "test1"))));
				System.out.println("New Employee #?");
				newNo = input.nextInt();
				System.out.println("New Employee Name?");
				newName = input.next();
				System.out.println("New Salary?");
				newSalary = input.nextInt();
				System.out.println("New City Address?");
				newCityAddress = input.nextLine();
				input.nextLine();
				System.out.println("New State Address?");
				newStateAddress = input.next();
				
				System.out.println(EmployeeServiceImpl.eList.get(userInput));
				ep.updateEmployee(userInput, new Employee(newNo, newName, newSalary, new Address(newCityAddress, newStateAddress)));
				System.out.println(EmployeeServiceImpl.eList.get(userInput));
				
				break;
			case 5:
				System.out.println("Which employee to delete?");
				userInput = input.nextInt();
				try {
//				ep.deleteEmployee(EmployeeServiceImpl.eList.remove(userInput));
				ep.deleteEmployee(EmployeeServiceImpl.eList.get(userInput));
				System.out.println(EmployeeServiceImpl.eList.get(userInput));
				} catch(IndexOutOfBoundsException ex) {
					LOGGER.log(Level.WARNING, "Deleted array index and searched it", ex);
				}
				break;
		
				
				
		}
		
		input.close();
	}
}
