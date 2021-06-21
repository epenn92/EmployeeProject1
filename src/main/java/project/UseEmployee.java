package project;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseEmployee {
	
	
		private static final Logger LOGGER = Logger.getLogger(UseEmployee.class.getName());
	

	public static void main(String[] args) throws InvalidSalaryException {
		
		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can cause IndexOutOfBoundException");
		
		int userInput = 0;
		int newNo = 0;
		String newName = null;
		double newSalary = 0;
		String newCityAddress = null;
		String newStateAddress = null;
		
//		System.out.println();
		EmployeeServiceImpl ep = new EmployeeServiceImpl();
		do {
		System.out.println("Choose option");
		System.out.println("1) List all current employees");
		System.out.println("2) View yearly employee salary");
		System.out.println("3) Get employee by id");
		System.out.println("4) Update an employee");
		System.out.println("5) Delete an employee");
		System.out.println("6) DB get all test");
		System.out.println("7) DB add test");
		System.out.println("8) Exit");
		
		ep.sortList();
		Scanner input = new Scanner(System.in);
		userInput = input.nextInt();
//		input.nextLine();
		
		switch(userInput) {
			case 1:  {
				ep.displayAllEmployees();
				ep.eList.stream().filter((s) -> s.empName.startsWith("*"))
				.forEach(System.out::println);
				break;
			}
			case 2:	 {
				System.out.println("Which employee salary?");
				userInput = input.nextInt();
				ep.calculateYearlySalary(ep.eList.get(userInput));
//				System.out.println();
				break;
			}
			case 3:
				System.out.println("Which employee by number?");
				userInput = input.nextInt();
				ep.findByEmployeeNo(userInput);
				break;
			case 4: {
				System.out.println("Which employee to update?");
//				ep.updateEmployee(EmployeeServiceImpl.eList.set(userInput, new Employee(1, "new", 1, new Address("test", "test1"))));
				userInput = input.nextInt();
				System.out.println("New Employee #?");
				newNo = input.nextInt();
				System.out.println("New Employee Name?");
				newName = input.next();
				System.out.println("New Salary?");
				newSalary = input.nextDouble();	
				try {
					InvalidSalaryException.validate(newSalary);
				} catch(InvalidSalaryException e1) {
						System.out.println("Please enter salary 2500 or more");
						newSalary = input.nextDouble();
				} finally {
					InvalidSalaryException.validate(newSalary);
				}
//				InvalidSalaryException.validate(newSalary);
				input.nextLine();

				System.out.println("New City Address?");
				newCityAddress = input.nextLine();
				input.nextLine();
				System.out.println("New State Address?");
				newStateAddress = input.next();
				int i = ep.getIndexOfEmpNo(userInput);
//				System.out.println(ep.getIndexOfEmpNo(userInput));
				ep.updateEmployee(i, new Employee(newNo, newName, newSalary, new Address(newCityAddress, newStateAddress)));
				ep.displayAllEmployees();

				System.out.println(ep.eList.get(i));
				
				break;
			}
			case 5: {
				System.out.println("Which employee to delete?");
				userInput = input.nextInt();
				try {
//				ep.deleteEmployee(EmployeeServiceImpl.eList.remove(userInput));
				int i = ep.getIndexOfEmpNo(userInput);
				ep.deleteEmployee(ep.eList.get(i));
				ep.displayAllEmployees();
				System.out.println(ep.eList.get(userInput));
				} catch(IndexOutOfBoundsException ex) {
					LOGGER.log(Level.WARNING, "Deleted array index and searched it", ex);
				}
				break;
		}
			case 6: {
				ep.getAllEmployees();
				input.nextLine();
				break;
			}
			case 7: {
				ep.addEmployee(null);
				input.nextLine();
				break;
			}
			case 8: {
				input.close();
				
			}
		}
				
				
		}
		while (userInput != 8);
		
		
	}
}
