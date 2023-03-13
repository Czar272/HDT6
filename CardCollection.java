import java.util.Map;

public interface CardCollection {
    void addCard(String cardName);
    String getCardType(String cardName);
    Map<String, Integer> getAllCards();
    Map<String, Integer> getCardsByType();
}
