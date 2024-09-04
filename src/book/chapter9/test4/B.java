package book.chapter9.test4;

public class B implements A.NestedIf {


    @Override
    public boolean isNotNegative(int x) {
        return x < 0 ? false : true;
    }
}
