package book.chapter6.box1;

public class BoxDemo2 {
    public static void main(String[] args) {
        Box myBox = new Box();
        Box myBox2 = new Box();
        double vol;
        myBox.width = 10;
        myBox.height = 20;
        myBox.depth = 15;
        myBox2.width = 3;
        myBox2.height = 6;
        myBox2.depth = 9;
        vol = myBox.width * myBox.height * myBox.depth;
        System.out.println("MyBox - 1 Oбъeм равен: " + vol);
        vol = myBox2.width * myBox2.height * myBox2.depth;
        System.out.println("MyBox - 2 Oбъeм равен: " + vol);

    }
}
