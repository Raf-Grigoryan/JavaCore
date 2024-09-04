package book.chapter9.test3;

import book.chapter9.test1.CallBack;
import book.chapter9.test1.Client;

public class TestIFace3 {
    public static void main(String[] args) {
        CallBack callBack = new Client();
        CallBack callBack1 = new AnotherClient();
        callBack1.callBack(42);
        callBack.callBack(42);
    }
}
