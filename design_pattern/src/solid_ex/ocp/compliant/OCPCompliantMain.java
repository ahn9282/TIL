package solid_ex.ocp.compliant;

public class OCPCompliantMain {
        public static void main(String[] args) {
            Report pdfReport = new PDFReport();
            pdfReport.generate();  // Generating PDF report...

            Report htmlReport = new HTMLReport();
            htmlReport.generate();  // Generating HTML report...

            Report xmlReport = new XMLReport();
            xmlReport.generate();  // Generating XML report...
        }
}
