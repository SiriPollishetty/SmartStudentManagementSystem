package SmartStudentManagement.services;

import SmartStudentManagement.model.Student;

public class StudentService {

    private Student[] students;
    private int count;

    public StudentService(int size) {

        students = new Student[size];
        count = 0;
    }

    public void addStudent(Student student) {

        if (count < students.length) {

            students[count] = student;
            count++;

            System.out.println("\nStudent added successfully!");

        } else {

            System.out.println("\nStudent storage is full.");
        }
    }

    public void displayAllStudents() {

        if (count == 0) {

            System.out.println("\nNo students available.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");

        for (int i = 0; i < count; i++) {

            students[i].displayDetails();
            System.out.println("--------------------------------");
        }
    }

    public Student searchStudent(int id) {

        for (int i = 0; i < count; i++) {

            if (students[i].getStudentId() == id) {

                return students[i];
            }
        }

        return null;
    }

    public void displayStudentReport(int id) {

        Student student = searchStudent(id);

        if (student != null) {

            student.displayDetails();

        } else {

            System.out.println("\nStudent not found.");
        }
    }
}