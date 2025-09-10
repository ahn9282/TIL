package solid_ex.isp.compliant;

// Class representing a regular worker
public class Employee implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Employee is working");
    }

    @Override
    public void eat() {
        System.out.println("Employee is eating");
    }
}