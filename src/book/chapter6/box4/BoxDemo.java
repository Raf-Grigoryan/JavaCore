package book.chapter6.box4;

public class BoxDemo {
    public static void main(String[] args) {
        Box myBox = new Box();
        Box myBox2 = new Box();
        double vol;
        myBox.setDim(10, 20, 15);
        myBox2.setDim(3, 6, 9);
        vol = myBox.volume();
        System.out.println("Oбъeм равен: " + vol);
        vol = myBox2.volume();
        System.out.println("Oбъeм равен: " + vol);

    }
}
