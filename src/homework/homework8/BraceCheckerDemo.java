package homework.homework8;

import java.util.Scanner;

public class BraceCheckerDemo {
    private static  BraceChecker braceChecker = new BraceChecker();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       takeText();
    }

    private static void takeText(){
        System.out.println("Input text");
        String input = scanner.nextLine();
        braceChecker.setText(input);
        braceChecker.check();
    }
}
