package book.chapter9.test1;

public class Client implements CallBack {

    @Override
    public void callBack(int p) {
        System.out.println("Method callback () " +  " parametr " + p);
    }
}
