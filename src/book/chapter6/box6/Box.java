package book.chapter6.box6;

public class Box {
    double width;
    double height;
    double depth;

    public Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
    double volume(){
        return width * height * depth;
    }
}
