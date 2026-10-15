import java.util.ArrayList;

abstract class Employee
{
    private String name;
    private int id;

    public Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString()
    {
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee
{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary)
    {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee
{
    private int hoursWorked;

    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hourlyWorked, double hourlyRate)
    {
        super(name, id);
        this.hoursWorked = hourlyWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public  double calculateSalary()
    {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem
{
    private ArrayList<Employee> employeeList;

    public PayrollSystem()
    {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }

    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;
        for(Employee employee : employeeList)
        {
            if(employee.getId() == id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees()
    {
        for(Employee employee : employeeList)
            System.out.println(employee);
    }
}
public class Main
{
    public static void main(String[] args)
        {
            PayrollSystem payrollSystem = new PayrollSystem();
            FullTimeEmployee fEmp1 = new FullTimeEmployee("Yash", 114, 70000);
            PartTimeEmployee pEmp1 = new PartTimeEmployee("Robin", 125, 45, 500);

            payrollSystem.addEmployee(fEmp1);
            payrollSystem.addEmployee(pEmp1);

            System.out.print("Initial Employee Details: ");
            payrollSystem.displayEmployees();
            System.out.println("Removing Employee");
            payrollSystem.removeEmployee(125);
            System.out.println("Remaining Employee Details: ");
            payrollSystem.displayEmployees();
        }
}