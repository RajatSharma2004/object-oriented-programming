public class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayEmployeeInfo() {
        System.out.println("ID: " + employeeID + ", Department: " + department);
    }

    public static void main(String[] args) {
        Manager m = new Manager(101, "IT", 70000);
        m.displayEmployeeInfo();
        System.out.println("Salary: " + m.getSalary());
    }
}
