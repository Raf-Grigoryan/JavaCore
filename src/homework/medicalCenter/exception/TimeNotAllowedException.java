package homework.medicalCenter.exception;

public class TimeNotAllowedException extends Exception {
    public TimeNotAllowedException() {
    }

    public TimeNotAllowedException(String message) {
        super(message);
    }
}
