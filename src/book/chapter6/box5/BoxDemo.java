package book.chapter6.box5;

public class BoxDemo {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();
        double vol;
        vol = myBox1.volume();
        System.out.println("Oбъeм равен: " + vol);
        vol  = myBox2.volume();
        System.out.println("Oбъeм равен: " + vol);
    }
}
