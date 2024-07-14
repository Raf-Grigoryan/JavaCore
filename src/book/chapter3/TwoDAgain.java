package book.chapter3;

public class TwoDAgain {
    public static void main(String[] args) {
        int[][] twod = new int[4][];
        twod[0] = new int[1];
        twod[1] = new int[2];
        twod[2] = new int[3];
        twod[3] = new int[4];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                twod[i][j] = k;
                k++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(twod[i][j] + " ");
            }
        }
    }
}
