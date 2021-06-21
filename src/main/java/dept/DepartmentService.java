package dept;

import java.util.List;

public interface DepartmentService {

	  public List<Department> getAllDepartments();
	  public List<Department> getDepartmentsByLocation(String loc);
	  public void updateDepartmentById(int deptNo);
	  public void deleteDepartmentById(int deptNo);
	  public void addDepartment(Department d);
}
