package StrategyExport;

public class ExportService {
    private StrategyInterface strategy;
    void setExportService(StrategyInterface strategy) {
        this.strategy = strategy;
    }
    void exportFile(String file) {
        this.strategy.export(file);
    }
}
