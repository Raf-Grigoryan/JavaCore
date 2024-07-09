package homework.homework1;

public class ForIfExamples {

    public static void main(String[] args) {
        //forUpToTen();
        //totalSum();
        //reverseFor();
        //oddNumbers();
        //coupleNumbersCount();
    }

    private static void forUpToTen() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    private static void totalSum() {
        int totalSum = 0;
        for (int i = 0; i <= 100; i++) {
            totalSum = totalSum + i;
        }
        System.out.println("Total Sum " + totalSum);
    }

    private static void reverseFor() {
        for (int i = 50; i >= 1; i--) {
            System.out.println(i);
        }
    }

    private static void oddNumbers() {
        for (int i = 1; i < 20; i = i + 2) {
            System.out.println(i);
        }
    }

    private static void coupleNumbersCount() {
        int count = 0;
        for (int i = 2; i <= 100; i= i +2) {
        count++;
        }
        System.out.println(count);
    }

}
