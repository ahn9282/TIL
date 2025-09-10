package solid_ex.isp.compliant;

// Class representing a robot
public class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
    // Robot does not implement Eatable interface
}
