package book.chapter8.test2;

public class Acces {
    public static void main(String[] args) {
        B subOb = new B();
        subOb.setIJ(10,12);
        subOb.sum();
        System.out.println("Cyммa равнa " + subOb.total);
    }
}
