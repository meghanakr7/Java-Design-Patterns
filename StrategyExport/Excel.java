package StrategyExport;

public class Excel implements StrategyInterface{
    @Override
    public void export(String file) {
        System.out.println("Exporting Excel " + file);
    }
}
