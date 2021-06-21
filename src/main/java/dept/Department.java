package dept;

public class Department {
	int deptNo;
	String dname;
	String loc;
	
	public Department(int deptNo, String dname, String loc) {
		this.deptNo = deptNo;
		this.dname = dname;
		this.loc = loc;
		
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	public String getDname() {
		return dname;
	}
	
	public String setDname(String dname) {
		return this.dname = dname;
	}
	
	public String getLoc() {
		return loc;
	}
	
	public String setLoc(String loc) {
		return this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
}
