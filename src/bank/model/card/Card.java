package bank.model.card;

import java.util.Objects;

public class Card {
    private String id;
    private String cardNumber;
    private String pin;
    private Card_Type cardType;
    private boolean active = true;
    private double balance;
    private String userId;

    public Card() {

    }

    public Card( String pin, Card_Type cardType, String userId) {
        this.pin = pin;
        this.cardType = cardType;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Card_Type getCardType() {
        return cardType;
    }

    public void setCardType(Card_Type cardType) {
        this.cardType = cardType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return active == card.active && Double.compare(balance, card.balance) == 0 && Objects.equals(id, card.id) && Objects.equals(cardNumber, card.cardNumber) && Objects.equals(pin, card.pin) && cardType == card.cardType && Objects.equals(userId, card.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, pin, cardType, active, balance, userId);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardType=" + cardType +
                ", active=" + active +
                ", balance=" + balance +
                '}';
    }
}
