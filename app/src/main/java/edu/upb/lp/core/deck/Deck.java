package edu.upb.lp.core.deck;

import java.util.ArrayList;

public class Deck {
    private final ArrayList<Card> cards;
    private String closeTitle;

    public Deck(String closeTitle) {
        this.cards = new ArrayList<>();
        this.closeTitle = closeTitle;
    }

    public void addCard(String title, String description, String image) {
        cards.add(new CardScreen(title, description, image));
    }

    public ArrayList<Card> getCards() {
        ArrayList<Card> deckComplete = new ArrayList<>();
        deckComplete.addAll(cards);
        Card closeCard = new CardStart(this.closeTitle);
        deckComplete.add(closeCard);
        return deckComplete;
    }
}
