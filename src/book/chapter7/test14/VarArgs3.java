package book.chapter7.test14;

public class VarArgs3 {
    static void vaTest(int... v) {
        System.out.println("vaTest(int ...)" + " Количество аргументов" +  v.length + " Сoдержимое:");
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
