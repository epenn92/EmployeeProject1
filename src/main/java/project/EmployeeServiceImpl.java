package project;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;

public class EmployeeServiceImpl implements EmployeeService {

		static ArrayList<Employee> eList = new ArrayList<Employee>(Arrays.asList(
				new Employee(100, "Jim", 80000, new Address("Conyers", "GA")),
				new Employee(101, "Alan", 55000, new Address("Some City", "PA")),
				new Employee(102, "Joan", 85000, new Address("Brooklyn", "NY")),
				new Employee(103, "Megan", 10000, new Address("Phoenix", "AZ")),
				new Employee(104, "James", 70000, new Address("Birmingham", "AL"))
						));
			
//		{{
//	eList.add(new Employee(100, "Jim", 80000, new Address("GA", "Conyers")));
//	eList.add(new Employee(101, "Alan", 55000, new Address("PA", "Some City")));
//	eList.add(new Employee(102, "Joan", 85000, new Address("NY", "Brooklyn")));
//	eList.add(new Employee(103, "Megan", 10000, new Address("AZ", "Phoenix")));
//	eList.add(new Employee(104, "James", 70000, new Address("AL", "Birmingham")));
//	}};
	public void displayAllEmployees() {
//		Collections.list(eList);
		for(Employee e1:eList) {
			System.out.println(e1.empNo + " " + e1.empName + " " + e1.salary + " " + e1.address.city + " " + e1.address.state);

		}
	}

	public double calculateYearlySalary(Employee e1) {
		 double yearlySalary = 0;
	     yearlySalary = e1.getSalary() * 12;
	     System.out.println(yearlySalary);
	     return yearlySalary;
		
	}

	public void findByEmployeeNo(int empNo) {
		for(Employee e1:eList) {
			if( e1.empNo == empNo) {
				System.out.println(e1.empNo + " " + e1.empName + " " + e1.salary + " " + e1.address.city + " " + e1.address.state);
			}
		}
		
	}

	public void updateEmployee(int x, Employee e1) {
//		e1.setAddress(new Address(e1.address.city, e1.address.state));
//		e1.setEmpName(e1.empName);
//		e1.setEmpNo(e1.empNo);
//		e1.setSalary(e1.salary);
//		ep.updateEmployee(EmployeeServiceImpl.eList.set(userInput, new Employee(1000, "test", 1, 
//				new Address("Witchita", "KA"))));
		eList.set(x ,e1);
//		System.out.println(e1.empNo + " " + e1.empName + " " + e1.salary + " " + e1.address.city + " " + e1.address.state);
	}

	public void deleteEmployee(Employee e1) {
		eList.remove(e1);
	}
	
	
}
