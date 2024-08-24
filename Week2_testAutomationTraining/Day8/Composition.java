package Day8;


import java.util.Arrays;

class Department{
	private int id;
	private String department;
	private String hodName;
	
	public Department(int id, String department, String hodName) {
		super();
		this.id = id;
		this.department = department;
		this.hodName = hodName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + ", hodName=" + hodName + "]";
	}
	
	
	
}

class University{
	String name;
	String address;
	Department dept[];
	
	//constructor
	public University(String name, String address, Department[] dept) {
		super();
		this.name = name;
		this.address = address;
		this.dept = dept;
	}
	
	//getter setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department[] getDept() {
		return dept;
	}

	public void setDept(Department[] dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", address=" + address + ", dept=" + Arrays.toString(dept) + "]";
	}
	
	
	
}

public class Composition {

	//create atlest 2 depts
	//and set those 3 depts to university objects
	//display universty object
	
	public static void main(String[] args) {
		Department d1 = new Department(01, "CS", "Add1");
		Department d2 = new Department(02, "EC", "Add2");
		
		Department dArr[] =  new Department[2];
		dArr[0] = d1;
		dArr[1] = d2;
		
		University u = new University("Name1", "Address", dArr);
		System.out.println(u.toString());
		
		
		
	}
}

