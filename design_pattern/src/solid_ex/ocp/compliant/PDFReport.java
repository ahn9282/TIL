package solid_ex.ocp.compliant;

public class PDFReport extends Report {
    @Override
    public void generate() {
        System.out.println("Generating PDF report...");
    }
}
