import java.io.*;
import java.util.*;

public class DataProcessor {

    public static List<SalesRecord> loadData(String filePath) {
        List<SalesRecord> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String product = data[0];
                int month = Integer.parseInt(data[1]);
                int quantity = Integer.parseInt(data[2]);

                records.add(new SalesRecord(product, month, quantity));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

    public static void analyzeSales(List<SalesRecord> records) {
        Map<Integer, Integer> monthlySales = new HashMap<>();

        for (SalesRecord r : records) {
            monthlySales.put(r.month,
                    monthlySales.getOrDefault(r.month, 0) + r.quantity);
        }

        for (int month : monthlySales.keySet()) {
            System.out.println("Month " + month + ": " + monthlySales.get(month));
        }
    }

    public static void topProducts(List<SalesRecord> records) {
        Map<String, Integer> productSales = new HashMap<>();

        for (SalesRecord r : records) {
            productSales.put(r.product,
                    productSales.getOrDefault(r.product, 0) + r.quantity);
        }

        productSales.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}