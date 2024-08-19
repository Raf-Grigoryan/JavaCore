package book.chapter7.test13;

public class VarArgs2 {
    static void vaTest(String msg,int ... v){
        System.out.println(msg + v.length + " Содержимое:");
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest("Один параметр  переменной длины: ",10);
        vaTest("Tpи параметр  переменной длины: ",1,2,3);
        vaTest("Без параметр  переменной длины:");
    }
}
