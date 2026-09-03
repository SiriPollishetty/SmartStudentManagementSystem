package SmartStudentManagement.main;

import java.util.Scanner;

import SmartStudentManagement.model.Student;
import SmartStudentManagement.model.DayScholar;
import SmartStudentManagement.model.Hosteller;
import SmartStudentManagement.model.SportsStudent;
import SmartStudentManagement.services.StudentService;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service =
                new StudentService(100);

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("   SMART STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Day Scholar");
            System.out.println("2. Add Hosteller");
            System.out.println("3. Add Sports Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Search Student");
            System.out.println("6. Generate Student Report");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    addDayScholar(sc, service);
                    break;

                case 2:

                    addHosteller(sc, service);
                    break;

                case 3:

                    addSportsStudent(sc, service);
                    break;

                case 4:

                    service.displayAllStudents();
                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    Student student =
                            service.searchStudent(id);

                    if (student != null) {
                        student.displayDetails();
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 6:

                    System.out.print("Enter Student ID: ");
                    int reportId = sc.nextInt();

                    service.displayStudentReport(reportId);
                    break;

                case 7:

                    System.out.println(
                            "\nThank you for using the system!");

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }

    public static void addDayScholar(
            Scanner sc,
            StudentService service) {

        System.out.print("Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        double[] marks = readMarks(sc);

        System.out.print("Transport Fee: ");
        double transportFee = sc.nextDouble();

        Student student = new DayScholar(
                id, name, department, year,
                marks, transportFee);

        service.addStudent(student);
    }

    public static void addHosteller(
            Scanner sc,
            StudentService service) {

        System.out.print("Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        double[] marks = readMarks(sc);

        System.out.print("Hostel Fee: ");
        double hostelFee = sc.nextDouble();

        Student student = new Hosteller(
                id, name, department, year,
                marks, hostelFee);

        service.addStudent(student);
    }

    public static void addSportsStudent(
            Scanner sc,
            StudentService service) {

        System.out.print("Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        double[] marks = readMarks(sc);

        sc.nextLine();

        System.out.print("Sport: ");
        String sport = sc.nextLine();

        Student student = new SportsStudent(
                id, name, department, year,
                marks, sport);

        service.addStudent(student);
    }

    public static double[] readMarks(Scanner sc) {

        double[] marks = new double[3];

        System.out.println("Enter marks for 3 subjects:");

        for (int i = 0; i < marks.length; i++) {

            System.out.print("Subject "
                    + (i + 1) + ": ");

            marks[i] = sc.nextDouble();
        }

        return marks;
    }
}