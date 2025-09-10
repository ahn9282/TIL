package solid_ex.isp.wrong;

public class ISPWrongMain {
    public static void main(String[] args) {
        Worker employee = new Employee();
        employee.work(); // Employee is working
        employee.eat(); // Employee is eating

        Worker robot = new Robot();
        robot.work(); // Robot is working
        robot.eat(); // Throws UnsupportedOperationException
    }
}
