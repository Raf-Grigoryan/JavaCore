package book.comporable;


public class DuplicateDemo {
    public static void main(String[] args) {
        int[] array = {90, 213,321,4325,654,24234,54646};
        printDuplicateNumbers(array);
    }
    private static void printDuplicateNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
