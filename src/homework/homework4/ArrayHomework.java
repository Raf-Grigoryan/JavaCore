package homework.homework4;

public class ArrayHomework {
    public static void main(String[] args) {
        int[] numbers = {12, 321, 123, 34, 6, 312, 43, 56, 454, 554, 123};
        similarNumberArray(numbers, 6);
        reverseArray(numbers);
        similarNumbersArray(numbers);
        char[] chars = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};
        vowelLetterArray(chars);

    }

    private static void similarNumberArray(int[] array, int similarNumber) {
        int count = 0;
        for (int i : array) {
            if (i == similarNumber) {
                count++;
            }
        }
        System.out.println("The match happens " + count + " times");
    }

    private static void reverseArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int element = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = element;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void similarNumbersArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("Similar numbers count: " + count);
    }

    private static void vowelLetterArray(char[] array) {
        char[] vowelLetter = {'ա', 'ե', 'ը', 'ի', 'ո', 'ւ', 'և'};
        int vowelCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < vowelLetter.length; j++) {
                if (array[i] == vowelLetter[j]) {
                    vowelCount++;
                }
            }
        }
        System.out.println("Vovel count in array: " + vowelCount);
    }


}


