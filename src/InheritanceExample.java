import java.util.Scanner;
class Employee extends Person {

    private double annualSalary;
    private int yearOfStart;
    private String nationalInsuranceNo;
    Employee(String name, double annualSalary, int yearOfStart, String nationalInsuranceNo) {
        super(name);
        this.annualSalary = annualSalary;
        this.yearOfStart = yearOfStart;
        this.nationalInsuranceNo = nationalInsuranceNo;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public int getYearOfStart() {
        return yearOfStart;
    }

    public void setYearOfStart(int yearOfStart) {
        this.yearOfStart = yearOfStart;
    }

    public String getNationalInsuranceNo() {
        return nationalInsuranceNo;
    }

    public void setNationalInsuranceNo(String nationalInsuranceNo) {
        this.nationalInsuranceNo = nationalInsuranceNo;
    }
}


public class InheritanceExample{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double annualSalary = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Year of Start: ");
        int yearOfStart = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("National Insurance Number: ");
        String nationalInsuranceNo = scanner.nextLine();

        Employee employee = new Employee(name, annualSalary, yearOfStart, nationalInsuranceNo);


        System.out.println("\nDetails of Employee:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Year Of Joining: " + employee.getYearOfStart());
        System.out.println("Annual Salary: " + employee.getAnnualSalary());
        System.out.println("Insurance Number: " + employee.getNationalInsuranceNo());

        scanner.close();
    }
}

/*A subclass does not inherit the private members of its parent class. 
However, if the superclass has public or protected methods for accessing 
its private fields, these can also be used by the subclass.*/