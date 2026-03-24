import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "data/sales.csv";

        List<SalesRecord> records = DataProcessor.loadData(filePath);

        System.out.println("=== Monthly Sales Analysis ===");
        DataProcessor.analyzeSales(records);

        System.out.println("\n=== Top Products ===");
        DataProcessor.topProducts(records);

        System.out.println("\n=== Demand Forecast ===");
        Forecasting.predictDemand(records);
    }
}