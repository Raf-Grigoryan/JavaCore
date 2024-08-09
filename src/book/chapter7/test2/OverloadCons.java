package book.chapter7.test2;

public class OverloadCons {
    public static void main(String[] args) {
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box();
        Box myBox3 = new Box(7);
        double vol = myBox1.volume();
        System.out.println("MyBox1 volume: " + vol);
        vol = myBox2.volume();
        System.out.println("MyBox2 volume: " + vol);
        vol = myBox3.volume();
        System.out.println("MyBox3 volume: " + vol);

    }
}
