package homework.homework1;

public class CoupleNumbers {

    public static void main(String[] args) {
        int count = 0;
        for (int number = 1; number <= 100; number++) {
            if ((number / 2) * 2 == number) {
                count++;
            }
        }
        System.out.println(count);
    }
}
