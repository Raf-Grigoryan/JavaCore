package book.chapter9.test3;

import book.chapter9.test1.CallBack;

public class AnotherClient implements CallBack {

    @Override
    public void callBack(int p) {
        System.out.println("Еще один вариант метода callback()");
        System.out.println("p в квадрате равно  " + (p * p))
        ;
    }
}
