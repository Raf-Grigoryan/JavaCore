package book.chapter7.test6;

public class RetOb {
    public static void main(String[] args) {
         Test ob1 = new Test(2);
         Test ob2;
         ob2 = ob1.incrementByTen();
        System.out.println("Ob1.a: " + ob1.a);
        System.out.println("Ob2.a: " + ob2.a);
    }
}
