package book.chapter5;

public class ForEach2 {
    public static void main(String[] args) {
        int sum = 0;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int num : nums) {
            System.out.print("Знaчeниe равно: " + num);
            sum += num;
            if (num == 5){
                break;
            }
        }

        System.out.println("Сумма пяти первых элементов равна: " + sum);
    }
}
