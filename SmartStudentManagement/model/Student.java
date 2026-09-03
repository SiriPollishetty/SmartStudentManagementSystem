package SmartStudentManagement.model;

public abstract class Student {

    private int studentId;
    private String name;
    private String department;
    private int year;
    private double[] marks;

    public static final String COLLEGE_NAME =
            "ABC Institute of Technology";

    // Parameterized constructor
    public Student(int studentId, String name,
                   String department, int year,
                   double[] marks) {

        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.year = year;
        this.marks = marks;
    }

    // Constructor overloading
    public Student(int studentId, String name) {

        this.studentId = studentId;
        this.name = name;
        this.department = "CSE";
        this.year = 2;
        this.marks = new double[3];
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public double[] getMarks() {
        return marks;
    }

    // Method to calculate average
    public double calculateAverage() {

        double sum = 0;

        for (double mark : marks) {
            sum += mark;
        }

        return sum / marks.length;
    }

    // Method overloading
    public double calculateAverage(double internalMarks) {

        return (calculateAverage() + internalMarks) / 2;
    }

    public String calculateGrade() {

        double average = calculateAverage();

        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "F";
    }

    // Abstract method
    public abstract String getStudentType();

    public abstract double calculateFee();

    // Common display method
    public void displayDetails() {

        System.out.println("\nStudent ID  : " + studentId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Year        : " + year);
        System.out.println("Student Type: " + getStudentType());
        System.out.println("Average     : " + calculateAverage());
        System.out.println("Grade       : " + calculateGrade());
        System.out.println("Fee         : ₹" + calculateFee());
    }
}