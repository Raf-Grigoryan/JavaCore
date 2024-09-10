package book.chapter10.test10;

public class MultiCatch {
    public static void main(String[] args) {
        int a = 10, b = 0;
        int [] vals = {1,2,3};
        try {
            int result = a / b;
        }catch (ArithmeticException e){
            System.out.println("Иcключeниe перехвачено:");
        }
        System.out.println("Пocлe многократного перехвата.");
    }
}
