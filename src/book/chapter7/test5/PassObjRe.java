package book.chapter7.test5;

public class PassObjRe {
    public static void main(String[] args) {
        Test test = new Test(15,20);
        System.out.println("a and b до вызова:" +  test.a + " " + test.b);
        test.meth(test);
        System.out.println("a и Ь после вызова:" + test.a + " " + test.b);

    }
}
