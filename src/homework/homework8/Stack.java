package homework.homework8;

public class Stack {
    private Brace[] stck = new Brace[10];
    private int tos;

    Stack() {
        tos = -1;
    }

    public void push(Brace item) {
        if (tos == stck.length - 1) {
            extend();
        }
        stck[++tos] = item;
    }

    private void extend() {
        Brace[] tmp = new Brace[stck.length + 10];
        System.arraycopy(stck, 0, tmp, 0, tos + 1);
        stck = tmp;
    }

    public Brace pop() {
        if (tos < 0) {
            return null;
        }
        return stck[tos--];
    }

    public boolean isEmpty() {
        return tos < 0;
    }
}
