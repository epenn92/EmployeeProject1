package projectTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
//
import project.Employee;
import project.EmployeeServiceImpl;
//import com.Employee;
//import com.EmployeeService;
//
public class TestAssertions {
//
	EmployeeServiceImpl emp1 = new EmployeeServiceImpl();
	Employee e1 = new Employee(0, null, 0, null);
	
	@Test
	public void testChangeSalary() {
		e1.setEmpName("Charles");
		e1.setSalary(55000);
		assertEquals(55000, e1.getSalary());
	}
	
	@Test
	public void testChangeName() {
		e1.setEmpName("James");
		assertNotEquals("Sames", e1.getEmpName());
	}
	
	@Test
	public void testDelete() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emp1.deleteEmployee(e1);
				e1.getEmpName();
			
		});
	}
//
//	   void testExpectedExceptionFail() {
//	     //Code does not throw any exception
//	     //This assetion will fail, when it passes returns false
//		  assertThrows(IllegalArgumentException.class, () -> {
//	       Integer.parseInt("asd");
//			  //Integer.parseInt("1");
//	     });
//	    
//	   }
}
