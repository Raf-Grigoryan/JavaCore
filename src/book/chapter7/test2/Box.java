package book.chapter7.test2;

public class Box {
    double widht;
    double height;
    double depth;

    Box(double w, double h,double d){
        widht = w;
        height = h;
        depth = d;
    }
    Box(){
        widht = -1;
        height = -1;
        depth = -1;
    }
    Box(double len){
        widht = height = depth = len;
    }
    double volume(){
        return  widht * height * depth;
    }
}
