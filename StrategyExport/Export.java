package StrategyExport;

public class Export {
    public static void main(String[] args) {
        ExportService service = new ExportService();
        service.setExportService(new PdfExport());
        service.exportFile("PDF file");

        service.setExportService(new Excel());
        service.setExportService(new Excel());
        service.exportFile("Excel file");
        
    }
}
