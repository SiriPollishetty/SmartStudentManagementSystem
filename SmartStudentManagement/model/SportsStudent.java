package SmartStudentManagement.model;

public class SportsStudent extends Student {

    private String sport;

    public SportsStudent(int studentId, String name,
                         String department, int year,
                         double[] marks,
                         String sport) {

        super(studentId, name, department, year, marks);
        this.sport = sport;
    }

    @Override
    public String getStudentType() {
        return "Sports Student";
    }

    @Override
    public double calculateFee() {

        return 40000;
    }

    public void generateReport() {

        System.out.println("\n----- SPORTS STUDENT REPORT -----");
        displayDetails();
        System.out.println("Sport: " + sport);
    }
}