package book.chapter8.test1;

public class SimpleInheritance {
    public static void main(String[] args) {
        A superOb  = new A();
        B subOb = new B();
        superOb.i = 10;
        superOb.j = 20;
        System.out.println("Coдepжимoe объекта superOb");
        superOb.showIJ();
        System.out.println();
        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;
        System.out.println("Coдepжимoe объекта subOb");
        subOb.showK();
        subOb.sum();

    }
}
