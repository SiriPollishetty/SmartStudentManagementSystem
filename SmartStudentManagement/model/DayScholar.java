package SmartStudentManagement.model;

public class DayScholar extends Student {

    private double transportFee;

    public DayScholar(int studentId, String name,
                      String department, int year,
                      double[] marks,
                      double transportFee) {

        super(studentId, name, department, year, marks);
        this.transportFee = transportFee;
    }

    @Override
    public String getStudentType() {
        return "Day Scholar";
    }

    @Override
    public double calculateFee() {

        return 50000 + transportFee;
    }

    public void generateReport() {

        System.out.println("\n----- DAY SCHOLAR REPORT -----");
        displayDetails();
        System.out.println("Transport Fee: ₹" + transportFee);
    }
}