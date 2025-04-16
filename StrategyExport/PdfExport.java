package StrategyExport;

public class PdfExport implements StrategyInterface{
    @Override
    public void export(String file) {
        System.out.println("Exported PDF of file "+ file);
    }
}
