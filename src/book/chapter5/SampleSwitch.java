package book.chapter5;

public class SampleSwitch {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0 -> System.out.println("i: " + i);
                case 1 -> System.out.println("i: " + i);
                case 2 -> System.out.println("i: " + i);
                case 3 -> System.out.println("i: " + i);
                default -> System.out.println("i больше трех.");
            }

        }
    }
}
