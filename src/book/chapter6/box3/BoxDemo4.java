package book.chapter6.box3;

public class BoxDemo4 {
    public static void main(String[] args) {
        Box myBox = new Box();
        Box myBox2 = new Box();
        myBox.width = 10;
        myBox.height = 20;
        myBox.depth = 15;
        double vol = myBox.volume();
        System.out.println("Oбъeм равен: " + vol);
        vol = myBox2.volume();
        System.out.println("Oбъeм равен: " + vol);
    }
}
