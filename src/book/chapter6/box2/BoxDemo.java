package book.chapter6.box2;

public class BoxDemo {
    public static void main(String[] args) {
        Box myBox = new Box();
        Box myBox2 = new Box();
        myBox.width = 10;
        myBox.height = 20;
        myBox.depth = 15;
        myBox2.width = 3;
        myBox2.height = 6;
        myBox2.depth = 9;
        myBox.volume();
        myBox2.volume();
    }
}
