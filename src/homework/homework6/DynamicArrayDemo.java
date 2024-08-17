package homework.homework6;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dy = new DynamicArray();
        for (int i = 0; i < 100; i++) {
            dy.add(i);
        }
        dy.print();
        dy.add(20,23);
        dy.deleteByIndex(5);
        System.out.println(dy.exists(5));
        System.out.println(dy.getIndexByValue(56));
    }
}
