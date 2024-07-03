package chapter2;

public class TestForAndIf {

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        for (int i = 1; i <= 100; i++) {

            if (i % x == 0 && i % y == 0) {
                System.out.println("FizzBuzz " + i);
            } else {
                if (i % x == 0) {
                    System.out.println("Fizz " +
                            "" + i);
                } else if (i % y == 0) {
                    System.out.println("Buzz " + i);
                }
            }
        }
    }
}
