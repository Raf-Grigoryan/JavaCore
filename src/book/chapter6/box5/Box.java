package book.chapter6.box5;

public class Box {
    double width;
    double height;
    double depth;
    Box(){
        System.out.println("Koнcтpyиpoвaниe объекта Вох");
        width = 10;
        height = 10;
        depth = 10;
    }

    double volume(){
        return  width * height * depth;
    }
}
