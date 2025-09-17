package solid_ex.ocp.compliant;

public class PDFReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating PDF report...");
    }
}
