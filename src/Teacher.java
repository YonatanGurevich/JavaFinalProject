import java.util.Scanner;

public class Teacher extends Person {
    public double wage;

    @Override
    public void input(Scanner scn) {
        System.out.println("Enter ID: ");
        this.id = scn.nextLine();
        System.out.println("First name: ");
        this.firstName = scn.nextLine();
        System.out.println("Last name: ");
        this.lastName = scn.nextLine();
        System.out.print("Marital status ( ");
        for (var s : MaritalStatus.values()) {
            System.out.print(s.status + " ");
        }
        System.out.print("): ");
        String new_status = scn.nextLine().toUpperCase();
        this.status = MaritalStatus.valueOf(new_status);
        System.out.println("Enter wage: ");
        this.wage = scn.nextDouble();
    }

    @Override
    public String toString() {
        return ("ID: " + this.id + "\nFirst name: " + this.firstName + "\nLast name: "
                + lastName + "\nmarital status: " + this.status.status + "\nWage: " + wage);
    }
}