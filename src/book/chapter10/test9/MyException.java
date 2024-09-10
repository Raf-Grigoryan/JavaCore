package book.chapter10.test9;

public class MyException extends Exception{
    private int detail;
    MyException(int a){
        detail = a;
    }
    public String toString(){
        return "MyExciption [ " + detail + "]";
    }

}
