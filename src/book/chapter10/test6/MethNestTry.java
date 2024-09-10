package book.chapter10.test6;

public class MethNestTry {
    static void nestTry(int a) {
        try {
            if (a == 1) a = a / (a - a);
            if (a == 2) {
                int[] c = {1};
                c[42] = 99;
            }
        } catch (ArithmeticException e) {
            System.out.println("Индeкc за пределами массива: " + e);
        }
    }

    public static void main(String[] args) {
        try {
            int a = args.length;
            int b = 42 / a;
            System.out.println("a = " + a);
            nestTry(a);
        }catch (ArithmeticException e){
            System.out.println("Дeлeниe нa нyль: " + e);
        }
    }
}
