package book.chapter7.test;

public class OverLoadDemo {
    void test() {
        System.out.println("Пapaмeтpы отсутствуют");
    }

    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    double test(double a) {
        System.out.println("double a: " + a);
        return a * a;
    }

}
