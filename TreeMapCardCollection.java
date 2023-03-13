import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapCardCollection implements CardCollection {
    private final Map<String, Integer> cardCount = new TreeMap<>();
    private final Map<String, String> cardTypes = new TreeMap<>();

    public TreeMapCardCollection() {
        CardReader.readCards("cards_desc.txt", cardTypes);
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
    public Map<String, Integer> getCardsByType() {
        Map<String, Integer> cardsByType = new HashMap<>();
        for (String cardName : cardCount.keySet()) {
            String cardType = cardTypes.get(cardName);
            if (cardsByType.containsKey(cardType)) {
                cardsByType.put(cardType, cardsByType.get(cardType) + cardCount.get(cardName));
            } else {
                cardsByType.put(cardType, cardCount.get(cardName));
            }
        }
        return cardsByType;
    }

    @Override
    public Map<String, Integer> getAllCards() {
        return cardCount;
    }
}
