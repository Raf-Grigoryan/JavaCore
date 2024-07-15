package homework.homework3;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        // printArray(numbers);
        //printFirstElement(numbers);
        //printLastElement(numbers);
        //printLengthOfArray(numbers);
        // smallestNumberOfArray(numbers);
        // evenNumbersCount(numbers);
        //oddNumbersCount(numbers);
        // arrayNumbersSum(numbers);
        //averageOfArray(numbers);
        //printMiddleElement(numbers);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void printFirstElement(int[] array) {
        System.out.println("This a first number of array " + array[0]);
    }

    private static void printLastElement(int[] array) {
        System.out.println("This is a last element of array " + array[array.length - 1]);
    }

    private static void printLengthOfArray(int[] array) {
        System.out.println("This is a lenght of array " + array.length);
    }

    private static void smallestNumberOfArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("This is a smallest number of array " + min);
    }

    private static void evenNumbersCount(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println("Couple numbers count " + count);
    }

    private static void oddNumbersCount(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                count++;
            }
        }
        System.out.println("Odd numbers count " + count);
    }

    private static void arrayNumbersSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Array numbers sum " + sum);
    }

    private static void averageOfArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Average of array " + sum / array.length);
    }

    private static void printMiddleElement(int[] array) {
        if (array.length <= 2) {
            System.out.println("Can't print middle values.");
        } else {
            int index = array.length / 2 - 1;
            if (array.length % 2 == 0) {
                System.out.println(array[index] + " " + array[++index]);
            } else {
                System.out.println(array[index]);
            }
        }
    }
}
