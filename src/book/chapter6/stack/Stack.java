package book.chapter6.stack;

public class Stack {
    int[] stack = new int[10];
    int tos = -1;

    void push(int item) {
        if (tos == 9) {
            System.out.println("Stack is full");
        } else {
            stack[++tos] = item;
        }
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Stack is empty");
            return 0;
        }
        return stack[tos--];

    }
}
