package book.chapter5;

public class Switch {
    public static void main(String[] args) {
        int month = 4;
        String season;
        switch (month) {
            case 12, 1, 2 -> season = "winter";
            case 3, 4, 5 -> season = "spring";
            case 6, 7, 8 -> season = "summer";
            case 9, 10, 11 -> season = "autumn";
            default -> season = "There is no such month";
        }
        System.out.println("April is a " + month);

    }
}
