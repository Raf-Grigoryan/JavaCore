package book.chapter7.test8;

public class RecTest {
    int[] values;

    public RecTest(int count) {
        this.values = new int[count];
    }

    void print(int i) {
        if (i == 0) {
            return;
        } else {
            print(i - 1);
            System.out.println("[" + (i - 1) + "] " + values[i - 1]);
        }
    }
}
