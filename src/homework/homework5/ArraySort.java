package homework.homework5;

public class ArraySort {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 3, 9, 0, 2};
        maxToMin(array);
        System.out.println();
        minToMax(array);
    }

    private static void maxToMin(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println("MAX To MIN");

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void minToMax(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println("MIN To MAX");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}
