package project;

public interface EmployeeService {

	public void displayAllEmployees();
	
	public double calculateYearlySalary(Employee e1);
	
	public void findByEmployeeNo(int empNo);
	
	public void updateEmployee(int x, Employee e1);
	
	public void deleteEmployee(Employee e1);
}
