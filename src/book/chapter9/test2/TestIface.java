package book.chapter9.test2;

import book.chapter9.test1.CallBack;
import book.chapter9.test1.Client;

public class TestIface {
    public static void main(String[] args) {
        CallBack callBack = new Client();
        callBack.callBack(10);
    }
}
