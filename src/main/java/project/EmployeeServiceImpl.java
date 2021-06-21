package project;

import java.util.concurrent.ThreadLocalRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import java.util.Collections;

public class EmployeeServiceImpl implements EmployeeService {

		public ArrayList<Employee> eList = new ArrayList<Employee>(Arrays.asList(
				new Employee(100, "Jim", 8000, new Address("Conyers", "GA")),
				new Employee(101, "Alan", 5500, new Address("Some City", "PA")),
				new Employee(102, "Joan", 8500, new Address("Brooklyn", "NY")),
				new Employee(103, "Megan", 3000, new Address("Phoenix", "AZ")),
				new Employee(104, "James", 7000, new Address("Birmingham", "AL"))
						));
			
	public void sortList() {
		Collections.sort(eList);
	}
		
	public void displayAllEmployees() {
//		Collections.list(eList);
		for(Employee e1:eList) {
			System.out.println(e1.empNo + " " + e1.empName + " " + e1.salary + " " + e1.address.city + " " + e1.address.state);

		}
	}

	public ArrayList<Employee> getAllEmployees() {
		String QUERY = "SELECT * FROM employee";
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY))
			{
				while (rs.next()) {
					int eno = rs.getInt("empno");
					String ename = rs.getString("empname");
					int esalary = rs.getInt("empsalary");
					String ecity = rs.getString("empcity");
					String estate = rs.getString("empstate");
					System.out.println("Record");
					System.out.println(eno + "," +ename+ "," +esalary+ "," +ecity+ "," +estate);
				}
		} catch (SQLException e) {e.printStackTrace(); }
		return null;
	}
	
	public void addEmployee(Employee e1) {
		int min =1;
		int max = 999;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max);
		String QUERY = "INSERT into employee values("+ randomNum + ", 'Tim' , 3000, 'TestCity', 'TestState')";
		System.out.println(randomNum);
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement())
				
		{
			int result = stmt.executeUpdate(QUERY);
			System.out.println(" Record added :" + result);
			if (result == 1) {
				System.out.println("Data Added");
			}
			else
				System.out.println("Could not add data");
		} catch (SQLException e) {
			e.printStackTrace();
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

	public void updateEmployee(int i, Employee e1) {
		eList.set(i, e1);
//		e1.setAddress(new Address(e1.address.city, e1.address.state));
//		e1.setEmpName(e1.empName);
//		e1.setEmpNo(e1.empNo);
//		e1.setSalary(e1.salary);
//		ep.updateEmployee(EmployeeServiceImpl.eList.set(userInput, new Employee(1000, "test", 1, 
//				new Address("Witchita", "KA"))));
//		for(Employee e2:eList) {
//			if( e2.empNo == empNo) 
			
//		System.out.println(e1.empNo + " " + e1.empName + " " + e1.salary + " " + e1.address.city + " " + e1.address.state);
//		}
	}

	public void deleteEmployee(Employee e1) {
		eList.remove(e1);
	}
	
	public int getIndexOfEmpNo(int empNo) {
		  for(Employee e1:eList)  {
		     if(e1.getEmpNo() == (empNo))
		         return eList.indexOf(e1);
		   }
		 return -1; 
		 }
}
