import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CardReader {
    public static void readCards(String fileName, Map<String, String> cardTypes) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    cardTypes.put(name, type);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
