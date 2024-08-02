package book.chapter6.box1;

public class BoxDemo {
    public static void main(String[] args) {
        Box myBox = new Box();
        double vol;
        myBox.width = 10;
        myBox.height = 20;
        myBox.depth = 15;
        vol  = myBox.width * myBox.height * myBox.depth;
        System.out.println("Oбъeм равен: " + vol);
    }
}
