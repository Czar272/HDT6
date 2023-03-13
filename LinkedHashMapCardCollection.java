import java.util.LinkedHashMap;

public class LinkedHashMapCardCollection implements CardCollection {
    private LinkedHashMap<String, Card> cards;

    public LinkedHashMapCardCollection() {
        cards = new LinkedHashMap<>();
    }

    @Override
    public void addCard(Card card) {
        String name = card.getName();
        if (cards.containsKey(name)) {
            cards.put(name, new Card(name, card.getType(), cards.get(name).getQuantity() + 1));
        } else {
            cards.put(name, new Card(name, card.getType(), 1));
        }
    }
    
    @Override
    public void addCard(String name) {
        Card card = new Card(name, getCardType(name), 1);
        addCard(card);
    }

    @Override
    public void removeCard(String name) {
        if (cards.containsKey(name)) {
            Card card = cards.get(name);
            if (card.getQuantity() > 1) {
                cards.put(name, new Card(name, card.getType(), card.getQuantity() - 1));
            } else {
                cards.remove(name);
            }
        }
    }

    @Override
    public String getCardType(String name) {
        if (cards.containsKey(name)) {
            return cards.get(name).getType();
        }
        return null;
    }

    @Override
    public int getCardQuantity(String name) {
        if (cards.containsKey(name)) {
            return cards.get(name).getQuantity();
        }
        return 0;
    }

    @Override
    public LinkedHashMap<String, Card> getAllCards() {
        return cards;
    }

    @Override
    public LinkedHashMap<String, Card> getCardsByType() {
        LinkedHashMap<String, Card> cardsByType = new LinkedHashMap<>();
        for (Card card : cards.values()) {
            if (cardsByType.containsKey(card.getType())) {
                cardsByType.put(card.getType(), new Card(card.getName(), card.getType(), cardsByType.get(card.getType()).getQuantity() + card.getQuantity()));
            } else {
                cardsByType.put(card.getType(), new Card(card.getName(), card.getType(), card.getQuantity()));
            }
        }
        return cardsByType;
    }
}
