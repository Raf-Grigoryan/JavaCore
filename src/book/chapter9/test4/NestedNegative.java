package book.chapter9.test4;

public class NestedNegative {
    public static void main(String[] args) {
        A.NestedIf nif = new B();
        if (nif.isNotNegative(10)){
            System.out.println("Чиcлo 10 неотрицательное\"");
        }
        if (nif.isNotNegative(12)){
            System.out.println("Этo не будет выведено");
        }
    }
}
