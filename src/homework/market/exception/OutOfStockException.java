package homework.market.exception;

public class OutOfStockException extends Exception {
    public OutOfStockException() {
    }

    public OutOfStockException(String message) {
        super(message);
    }
}
