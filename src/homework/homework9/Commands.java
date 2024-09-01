package homework.homework9;

public interface Commands {
    String EXIT = "0";
    String ADD_BOOK = "1";
    String PRINT_ALL_BOOKS = "2";
    String BOOK_BY_NAME = "3";
    String UPDATE_BOOK = "4";
    String SEARCH_BY_PRICE = "5";
    String DELETE_BOOK = "6";

    static void commands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_BOOK + " for add book");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for print books");
        System.out.println("Please input " + BOOK_BY_NAME + " for search book by name");
        System.out.println("Please input " + UPDATE_BOOK + " for update book");
        System.out.println("Please input " + SEARCH_BY_PRICE + " for search by price");
        System.out.println("Pelase input " + DELETE_BOOK + " for delete book by id");
    }
}
