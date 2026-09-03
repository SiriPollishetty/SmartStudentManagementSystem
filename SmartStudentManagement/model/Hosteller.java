package SmartStudentManagement.model;

public class Hosteller extends Student {

    private double hostelFee;

    public Hosteller(int studentId, String name,
                     String department, int year,
                     double[] marks,
                     double hostelFee) {

        super(studentId, name, department, year, marks);
        this.hostelFee = hostelFee;
    }

    @Override
    public String getStudentType() {
        return "Hosteller";
    }

    @Override
    public double calculateFee() {

        return 50000 + hostelFee;
    }

    public void generateReport() {

        System.out.println("\n----- HOSTELLER REPORT -----");
        displayDetails();
        System.out.println("Hostel Fee: ₹" + hostelFee);
    }
}