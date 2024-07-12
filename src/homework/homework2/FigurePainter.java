package homework.homework2;

public class FigurePainter {
    public static void main(String[] args) {
        firstFigure();
        secondFigure();
        thirdFigure();
        fourthFigure();
        fifthFigure();
    }

    private static void firstFigure() {
        System.out.println("First Figure");
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    private static void secondFigure() {
        System.out.println("Second Figure");
        for (int i = 5; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void thirdFigure() {
        System.out.println("Third Figure");
        int count = 0;
        for (int i = 5; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j < count + 1; j++) {
                System.out.print("* ");
            }
            count++;
            System.out.println();
        }
    }

    private static void fourthFigure() {
        System.out.println("Fourth Figure");
        int count = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("  ");
            }
            for (int j = count; j > 0; j--) {
                System.out.print("* ");
            }
            count--;
            System.out.println();
        }
    }

    private static void fifthFigure() {
        System.out.println("Fifth figure");
        int count = 0;
        int count2 = 5;
        for (int i = 5; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < count + 1; j++) {
                System.out.print("* ");
            }
            count++;
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = count2; j > 0 ; j--) {
                System.out.print(" *");
            }
            count2--;
            System.out.println();
        }
    }
}
