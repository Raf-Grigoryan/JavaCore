package chapter3;

public class BoolTest {
    public static void main(String[] args) {
        boolean b;
        b = false;
        System.out.println("B is a " + b);
        b = true;
        System.out.println("B is a " + b);
        if (b) {
            System.out.println("Этот код выполняется");
        }
        b = false;
        if (b){
            System.out.println("Этот код не выполняется");
        }

    }
}
