package chapter3;

public class Light {
    public static void main(String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long distance;
        days = 1000;
        lightspeed = 186000;
        seconds = days *24 *60 *60;
        distance = lightspeed * seconds;
        System.out.println("Зa " + days + " дней свет пройдет около " + distance + " миль");

    }
}
