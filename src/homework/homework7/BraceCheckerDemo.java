package homework.homework7;

import java.util.Scanner;

public class BraceCheckerDemo {
    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker("Hello {java}}");
        braceChecker.check();
    }
}
