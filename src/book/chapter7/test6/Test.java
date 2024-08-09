package book.chapter7.test6;

public class Test {
    int a;

    public Test(int a) {
        this.a = a;
    }
    Test incrementByTen(){
        Test temp = new Test(a + 10);
        return  temp;
    }

}
