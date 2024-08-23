package homework.homework7and8;

import java.util.Scanner;

public class BraceCheckerDemo {
    private static BraceChecker braceChecker = new BraceChecker();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        takeText();
    }

    private static void takeText() {
        System.out.println("Hi please input text");
        String text = scanner.nextLine();
        braceChecker.setText(text);
        braceChecker.check();

    }
}
