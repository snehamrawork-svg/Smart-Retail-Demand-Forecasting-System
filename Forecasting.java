import java.util.*;

public class Forecasting {

    public static void predictDemand(List<SalesRecord> records) {
        Map<String, List<Integer>> productTrend = new HashMap<>();

        for (SalesRecord r : records) {
            productTrend.putIfAbsent(r.product, new ArrayList<>());
            productTrend.get(r.product).add(r.quantity);
        }

        for (String product : productTrend.keySet()) {
            List<Integer> sales = productTrend.get(product);

            int sum = 0;
            for (int s : sales)
                sum += s;

            int avg = sum / sales.size();

            System.out.println(product + " predicted demand: " + avg);
        }
    }
}