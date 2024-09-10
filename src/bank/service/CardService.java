package bank.service;

import bank.model.card.Card;

public interface CardService {

    boolean transferMoney(Card fromCard, String toCardNumber, double amount);

    Card add(Card card);

    Card getCardByUserId(String userId);

    Card getCardByCardNumber(String cardNumber);

    boolean depositMoney(String cardNumber, double amount);

    void printPaymentSystems();

    boolean deactivatedCardByUserId(String userId);
    void printAllCards();
}
