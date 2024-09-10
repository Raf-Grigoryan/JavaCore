package bank.serviceImpl;

import bank.model.card.Card;
import bank.model.card.Card_Type;
import bank.service.CardService;
import bank.util.CardNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CardServiceImpl implements CardService, CardNumbers {
    private final List<Card> cards = new ArrayList<>();
    private final AtomicInteger idNumber = new AtomicInteger(100);
    private final AtomicInteger cardNumber = new AtomicInteger(2000);
    private final Random random = new Random();

    @Override
    public Card add(Card card) {
        switch (card.getCardType()) {
            case VISA ->
                    card.setCardNumber(CardNumbers.VISA + "-" + random.nextInt(2000 + 4000) + "-" + cardNumber.getAndIncrement());
            case MASTER ->
                    card.setCardNumber(CardNumbers.MASTER_CARD + "-" + random.nextInt(2000 + 4000) + "-" + cardNumber.getAndIncrement());
            case AMERICAN_EXPRESS ->
                    card.setCardNumber(CardNumbers.AMERICAN_EXPRESS + "-" + random.nextInt(2000 + 4000) + "-" + cardNumber.getAndIncrement());
        }
        card.setId("C" + idNumber.getAndIncrement());
        cards.add(card);
        return card;
    }

    @Override
    public boolean transferMoney(Card fromCard, String toCardNumber, double amount) {
        Card recipient = getCardByCardNumber(toCardNumber);
        if (recipient != null && fromCard.getBalance() >= amount) {
            fromCard.setBalance(fromCard.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
            return true;
        } else {
            if (recipient == null) {
                System.out.println("Recipient card not found.");
            } else if (fromCard.getBalance() < amount) {
                System.out.println("Insufficient funds.");
            }
        }
        return false;
    }


    @Override
    public Card getCardByUserId(String userId) {
        for (Card card : cards) {
            if (card.getUserId().equals(userId)) {
                return card;
            }
        }
        return null;
    }

    @Override
    public Card getCardByCardNumber(String cardNumber) {
        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    @Override
    public boolean depositMoney(String cardNumber, double amount) {
        Card card = getCardByCardNumber(cardNumber);
        if (card != null) {
            if (amount > 0) {
                card.setBalance(card.getBalance() + amount);
            } else {
                System.out.println("Invalid amount!");
            }
        } else {
            System.out.println("Card not found!");
        }
        return false;
    }

    public void printPaymentSystems() {
        for (Card_Type value : Card_Type.values()) {
            System.out.println(value.name());
        }
    }

    @Override
    public boolean deactivatedCardByUserId(String userId) {
        for (Card card : cards) {
            if (card.getUserId().equals(userId)) {
                cards.remove(card);
                return true;
            }
        }
        return false;
    }

    public void printAllCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
