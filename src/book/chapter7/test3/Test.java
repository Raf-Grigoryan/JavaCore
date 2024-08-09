package book.chapter7.test3;

public class Test {
    int a;
    int b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }
    boolean equalTo(Test ob){
        if (ob.a  == this.a && ob.b == this.b){
            return true;
        }
        return false;
    }
}
