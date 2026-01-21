
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the base currency (eg. USD):");
        String from = sc.next().toUpperCase();

        System.out.println("Enter the target currency (eg INR):");
        String to = sc.next().toUpperCase();

        System.out.println("Enter the amount to convert:");
        double amount = sc.nextDouble();

        try {
            String apiUrl = "https://api.frankfurter.app/latest?amount="
                    + amount + "&from=" + from + "&to=" + to;

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            String resultString = response.toString();
            int index = resultString.indexOf(to);
            int start = resultString.indexOf(":", index) + 1;
            int end = resultString.indexOf("}", start);

            double convertedAmount = Double.parseDouble(resultString.substring(start, end));

            System.out.println("\n Converted Amount:");
            System.out.println(amount + " " + from + "=" + convertedAmount + " " + to);

        } catch (Exception e) {
            System.out.println("error occurred while fetching exchange rates.");
            System.out.println("Reason: " + e.getMessage());
        }
        sc.close();
    }
}
