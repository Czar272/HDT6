import java.util.HashMap;
import java.util.Map;

public class HashMapCardCollection implements CardCollection {
    private final Map<String, Integer> cardCount = new HashMap<>();
    private final Map<String, String> cardTypes = new HashMap<>();

    public HashMapCardCollection() {
        // Leer el archivo y agregar las cartas al mapa cardTypes
    }

    @Override
    public void addCard(String cardName) {
        if (!cardTypes.containsKey(cardName)) {
            throw new IllegalArgumentException("Carta no disponible");
        }

        cardCount.merge(cardName, 1, Integer::sum);
    }

    @Override
    public String getCardType(String cardName) {
        return cardTypes.get(cardName);
    }

    @Override
    public Map<String, Integer> getAllCards() {
        return new HashMap<>(cardCount);
    }

    @Override
    public Map<String, Integer> getCardsByType() {
        Map<String, Integer> cardsByType = new HashMap<>();

        for (Map.Entry<String, Integer> entry : cardCount.entrySet()) {
            String cardName = entry.getKey();
            int count = entry.getValue();
            String cardType = cardTypes.get(cardName);

            cardsByType.merge(cardType, count, Integer::sum);
        }

        return cardsByType;
    }
}
