package homework.homework7;

public class Stack {
    private char[] stck = new char[10];
    private int tos;

    Stack() {
        tos = -1;
    }

    public void push(char item) {
        if (tos == stck.length - 1) {
            extend();
        } else {
            stck[++tos] = item;
        }
    }

    private void extend() {
        char[] tmp = new char[stck.length + 10];
        System.arraycopy(stck, 0, tmp, 0, tos + 1);
        stck = tmp;
    }

    public char pop() {
        if (tos < 0) {
            return '0';
        } else {
            return stck[tos--];
        }
    }

    public int getTopIndex() {
        return tos;
    }

    public boolean isEmpty() {
        return tos < 0;
    }
}

