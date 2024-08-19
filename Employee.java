package Assignment1;

public class Employee {
    private int pid;
    private String pname;

    // Constructor
    public Employee(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    // Default constructor
    public Employee() {
        this(0, "Unknown");
    }

    // Getter for pid
    public int getPid() {
        return pid;
    }

    // Setter for pid
    public void setPid(int pid) {
        this.pid = pid;
    }

    // Getter for pname
    public String getPname() {
        return pname;
    }

    // Setter for pname
    public void setPname(String pname) {
        this.pname = pname;
    }

    // Method to print Employee details
    public void printDetails() {
        System.out.println("PID: " + this.pid + ", Name: " + this.pname);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "John Doe");
        emp1.printDetails();

        Employee emp2 = new Employee();
        emp2.setPid(2);
        emp2.setPname("Jane Doe");
        emp2.printDetails();
    }
}
