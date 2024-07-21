package book.chapter5;

public class DoWhile {
    public static void main(String[] args) {
        int n = 10;
        do {
            System.out.println("Такт: " + n);
            n--;
        }while (n > 0);
    }
}
