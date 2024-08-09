package book.chapter7.test5;

public class Test {
    int a, b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void meth(Test o){
        o.a *= 2;
        o.b /= 2;
    }

}
