package book.chapter5;

public class NoChange {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        for (int num : nums) {
            System.out.print(num + " ");
            num = num * 10;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
