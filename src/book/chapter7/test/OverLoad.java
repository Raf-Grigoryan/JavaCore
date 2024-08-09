package book.chapter7.test;

public class OverLoad {
    public static void main(String[] args) {
        OverLoadDemo ob = new OverLoadDemo();
        ob.test();
        ob.test(10);
        ob.test(10,20);
        double result = ob.test(123.25);
        System.out.println("Результат вызова: " + result);
    }
}
