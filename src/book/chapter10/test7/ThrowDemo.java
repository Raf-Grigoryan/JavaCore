package book.chapter10.test7;

import java.io.IOException;

public class ThrowDemo {
    static void demoProc() {
        try {
            throw new NullPointerException("Demo");
        } catch (NullPointerException e) {
            System.out.println("Иcключeниe перехвачено в теле" + " метода demoproc ()");
        }
    }

    public static void main(String[] args) {
        try {
            demoProc();
        } catch (NullPointerException e) {
            System.out.println("Пoвтopный перехват: " + e);
        }
    }
}
