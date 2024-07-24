package book.chapter5;

public class Search {
    public static void main(String[] args) {
        int[] nums = {6, 8, 3, 7, 5, 6, 1, 4};
        int val = 5;
        boolean found = false;
        for (int num : nums) {
            if (num == val) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Знaчeниe найдено!");
        }
    }
}
