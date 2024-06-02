package Student;

import java.util.Scanner;

public class Teacher {
    public String name;
    public String facultyID;
    public String department;

    public Teacher() {}

    public Teacher(String name, String facultyID, String department) {
        this.name = name;
        this.facultyID = facultyID;
        this.department = department;
    }

    public void getInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Faculty Name: ");
        name = sc.nextLine();

        System.out.println("Enter Faculty ID: ");
        facultyID = sc.nextLine();

        System.out.println("Enter Department: ");
        department = sc.nextLine();
    }

    public void display() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Faculty ID: " + facultyID);
        System.out.println("Department: " + department);
    }
}
